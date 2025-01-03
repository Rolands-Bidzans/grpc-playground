package com.rolands.test.common;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbstractChannelTest {

    protected ManagedChannel channel;

    @BeforeAll
    public void setupChanel () {
        this.channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()// to use HTTP instead of HTTPS
                .build();

    }

    @AfterAll
    public void stopChannel() throws InterruptedException {
        this.channel.shutdown()
                .awaitTermination(5, TimeUnit.SECONDS);
    }
}
