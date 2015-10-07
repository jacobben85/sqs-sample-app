package com.univision.deportes.services.sqs;


import org.junit.Test;

import java.io.IOException;

/**
 * Created by jbjohn on 10/7/15.
 */
public class QueueServiceTest {

    @Test
    public void testProcess() throws IOException {
        QueueService queueService = new QueueService();
        queueService.process();
    }
}