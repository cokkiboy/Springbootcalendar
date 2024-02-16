package com.app.sharedcalendar.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowDTO {
    private Long id;
    private String fromUsername;
    private String toUsername;
    private String status; /// self, following, none

}
