package com.rolands.common;

// import com.rolands.sec06.TransferService;
// import com.rolands.sec07.FlowControlService;

import com.rolands.sec09.BankService;

public class Demo {
    public static void main(String[] args) {
//        GrpcServer.create(new BankService(), new TransferService())
//                .start()
//                .await();

//        GrpcServer.create(new FlowControlService())
//                .start()
//                .await();

        GrpcServer.create(new BankService())
                .start()
                .await();
    }
}
