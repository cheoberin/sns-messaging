package com.cheobs.sns_messaging.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.stereotype.Service;

@Service
public class SnsMessagingService {

    private final AmazonSNS amazonSNS;

    public SnsMessagingService(AmazonSNS amazonSNS) {
        this.amazonSNS = amazonSNS;
    }

    public String sendMessage(String topic, String subject, String message) {
        PublishRequest publishRequest = new PublishRequest(
                topic,
                message,
                subject
        );

        amazonSNS.publish(publishRequest);
        return "Notification sent";
    }

}
