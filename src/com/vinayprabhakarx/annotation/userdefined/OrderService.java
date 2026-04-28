package com.vinayprabhakarx.annotation.userdefined;

public class OrderService extends BaseService {
    @AuditInfo(createdBy = "Vinay", description = "Method annotation")
    public void createOrder() {
        System.out.println("Order created");
    }
}
