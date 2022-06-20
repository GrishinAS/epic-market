package com.innteam.epicmarket.seller.api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innteam.epicmarket.seller.api.dto.Lot;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class KafkaProducer implements QueueManager {

    private static final String TOPIC_NAME = "saveLotTopic";
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void send(Lot lot) throws Exception {
        var future =
                kafkaTemplate.send(TOPIC_NAME, objectMapper.writeValueAsString(lot));
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent lot=[" + lot +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send lot=["
                        + lot + "] due to : " + ex.getMessage());
            }
        });
    }
}
