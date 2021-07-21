package com.hohocompany.user.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Message {
    private boolean isSuccess;
    private String message;
    @Builder
    public Message(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

}
