package com.rolands.sec06.requesthandlers;

import com.rolands.models.sec06.AccountBalance;
import com.rolands.models.sec06.TransferRequest;
import com.rolands.models.sec06.TransferResponse;
import com.rolands.models.sec06.TransferStatus;
import com.rolands.sec06.repository.AccountRepository;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransferRequestHandler implements StreamObserver<TransferRequest> {
    private static final Logger log = LoggerFactory.getLogger(TransferRequestHandler.class);
    private final StreamObserver<TransferResponse> responseObserver;

    public TransferRequestHandler(StreamObserver<TransferResponse> responseObserver) {
        this.responseObserver = responseObserver;
    }


    @Override
    public void onNext(TransferRequest transferRequest) {
        var status = this.transfer(transferRequest);
        log.info("Status2: {}",status);
        if(TransferStatus.COMPLETED.equals(status)) {
            var response = TransferResponse.newBuilder()
                    .setStatus(status)
                    .setFromAccount(this.toAccountBalance(transferRequest.getFromAccount()))
                    .setToAccount(this.toAccountBalance(transferRequest.getToAccount()))
                    .build();

            this.responseObserver.onNext(response);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("client error: {}", throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        log.info("transfer request stream completed");
        this.responseObserver.onCompleted();
    }

    private TransferStatus transfer(TransferRequest request){
        var amount = request.getAmount();
        var fromAccount = request.getFromAccount();
        var toAccount = request.getToAccount();
        var status = TransferStatus.REJECTED;

        var balance = AccountRepository.getBalance(fromAccount);
        if(balance != null){
            if (balance >= amount && (fromAccount != toAccount)) {
                AccountRepository.deducedAmount(fromAccount, amount);
                AccountRepository.addAmount(toAccount, amount);
                status = TransferStatus.COMPLETED;
            }
        }
        log.info("Statussss: {}",status);
        return  status;
    }

    private AccountBalance toAccountBalance(int accountNumber){
        return AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(AccountRepository.getBalance(accountNumber))
                .build();
    }
}
