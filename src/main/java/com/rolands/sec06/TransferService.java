package com.rolands.sec06;

import com.rolands.models.sec06.TransferRequest;
import com.rolands.models.sec06.TransferResponse;
import com.rolands.models.sec06.TransferServiceGrpc;
import io.grpc.stub.StreamObserver;

public class TransferService extends TransferServiceGrpc.TransferServiceImplBase {
    @Override
    public StreamObserver<TransferRequest> transfer(StreamObserver<TransferResponse> responseObserver) {

    }
}
