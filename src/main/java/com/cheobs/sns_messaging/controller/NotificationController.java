package com.cheobs.sns_messaging.controller;

import com.cheobs.sns_messaging.controller.request.NotificationRequestDto;
import com.cheobs.sns_messaging.controller.response.NotificationResponseDto;
import com.cheobs.sns_messaging.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notification")
public class NotificationController {

    private final EmailService emailService;

    public NotificationController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<NotificationResponseDto> sendNotification(@RequestBody @Valid NotificationRequestDto notificationRequestDto) {
        var response = emailService.sendNotification(notificationRequestDto);
        return ResponseEntity.ok(response);

    }


}
