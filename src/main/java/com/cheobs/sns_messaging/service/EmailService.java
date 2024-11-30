package com.cheobs.sns_messaging.service;

import com.cheobs.sns_messaging.controller.request.NotificationRequestDto;
import com.cheobs.sns_messaging.controller.response.NotificationResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${cloud.aws.sns.topic}")
    private String topic;
    private final SnsMessagingService snsMessagingService;

    public EmailService(SnsMessagingService snsMessagingService) {
        this.snsMessagingService = snsMessagingService;
    }

    public NotificationResponseDto sendNotification(NotificationRequestDto notificationRequestDto) {
        var status = snsMessagingService.sendMessage(topic, notificationRequestDto.subject(), notificationRequestDto.message());
        return new NotificationResponseDto(status);
    }
}
