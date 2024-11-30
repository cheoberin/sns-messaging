package com.cheobs.sns_messaging.controller.request;

import jakarta.validation.constraints.NotBlank;

public record NotificationRequestDto(
        @NotBlank String subject,
        @NotBlank String message
) {
}
