package com.example.trelloApi.service.token;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.NonNull;
import java.time.Clock;
import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:18 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */
public class AbstractTokenService {
    private static final SignatureAlgorithm algorithm = SignatureAlgorithm.HS512;


    protected String getSubject(String token, String secret) {
        Claims claims=new DefaultClaims();
        return getClaim(token, Claims::getSubject, secret);
    }

    private  <T> T getClaim(String token, Function<Claims, T> func, String secret) {
        Jws<Claims> claimsJws = jwtClaims(token, secret);
        Claims claims = claimsJws.getBody();
        return func.apply(claims);
    }

    protected String jwt(@NonNull final String subject,
                         @NonNull final String secret,
                         int amountToAdd, TemporalUnit unit) {
        return jwtBuilder(subject, secret, amountToAdd, unit).compact();
    }

    protected Jws<Claims> jwtClaims(@NonNull final String token, @NonNull final String secret) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private JwtBuilder jwtBuilder(@NonNull final String subject,
                                  @NonNull final String secret,
                                  int amountToAdd,
                                  TemporalUnit unit) {
        Instant now = Instant.now(Clock.systemDefaultZone());
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(amountToAdd, unit)))
                .signWith(algorithm, secret);
    }

    protected boolean isTokenValid(String token, String secret) {
        String subject = getSubject(token, secret);
        Date expiration = getClaim(token, Claims::getExpiration, secret);
        return (Objects.nonNull(subject) && !isTokenExpired(expiration));
    }

    private boolean isTokenExpired(Date expiration) {
        Instant now = Instant.now(Clock.systemDefaultZone());
        return now.isAfter(expiration.toInstant());
    }
}
