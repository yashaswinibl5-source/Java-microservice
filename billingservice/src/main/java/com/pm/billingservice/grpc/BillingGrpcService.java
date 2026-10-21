package com.pm.billingservice.grpc;

import billing.BillingServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(billing.BillingRequest request,
                               io.grpc.stub.StreamObserver<billing.BillingResponse> responseObserver) {
        // Implement your own logic to retrieve billing information based on the request
        log.info("Received billing request for patientId: {}", request.toString());


        // business logic eg perform calculation , save to db etc
        billing.BillingResponse response = billing.BillingResponse.newBuilder()
                .setAccountId("12345")
                        .setStatus("ACTIVE")
                                .build();

        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
