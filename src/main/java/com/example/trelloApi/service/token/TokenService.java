package com.example.trelloApi.service.token;

import com.example.trelloApi.configs.security.UserDetails;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:11 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */
public interface TokenService {

    String generateToken(UserDetails userDetails);

    Boolean isValid(String token);


}
