package com.example.trelloApi.dto.auth;

import com.example.trelloApi.dto.base.BaseGenericDto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 12:14 PM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */


public record UserCreateDto(String email, String password) implements BaseGenericDto {
}
