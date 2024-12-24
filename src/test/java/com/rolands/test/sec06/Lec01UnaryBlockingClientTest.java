package com.rolands.test.sec06;

import com.google.protobuf.Empty;
import com.rolands.models.sec06.BalanceCheckRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01UnaryBlockingClientTest extends AbstractTest{
    public static final Logger log = LoggerFactory.getLogger(Lec01UnaryBlockingClientTest.class);

   @Test
    public void getBalanceTest(){
        var request = BalanceCheckRequest.newBuilder()
                                                            .setAccountNumber(1)
                                                            .build();

        var balance = this.blockingStub.getAccountBalance(request);
        log.info("Unary balance received: {}", balance);
        Assertions.assertEquals(10, balance.getBalance());
    }

    @Test
    public void getAllAccountTest(){
        var allAccounts = this.blockingStub.getAllAccounts(Empty.getDefaultInstance());
        log.info("Unary all account's size: {}", allAccounts.getAccountsCount());
        Assertions.assertEquals(10, allAccounts.getAccountsCount());
    }
}
