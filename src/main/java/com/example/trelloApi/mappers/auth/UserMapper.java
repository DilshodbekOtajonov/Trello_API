package com.example.trelloApi.mappers.auth;

import com.example.trelloApi.domains.auth.AuthUser;
import com.example.trelloApi.dto.auth.UserDto;
import org.mapstruct.Mapper;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 12:21 PM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto fromUser(AuthUser authUser);
}
