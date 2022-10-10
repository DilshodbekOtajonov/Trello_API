package com.example.trelloApi.dto.workspace;

import lombok.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/28/22 5:03 PM (Sunday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class WorkspaceMemberDto {
    private Long id;
    private String memberEmail;
}
