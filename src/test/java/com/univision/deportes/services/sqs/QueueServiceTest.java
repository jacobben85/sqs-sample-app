package com.univision.deportes.services.sqs;


import org.junit.Test;

/**
 * Created by jbjohn on 10/7/15.
 */
public class QueueServiceTest {

    @Test
    public void testProcess() {
        QueueService queueService = new QueueService();
        queueService.process();
    }
}