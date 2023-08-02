package com.javachallenge.wsserver.dataaccess.dtos;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatDTO {
    private String topic;
    private String message;

}