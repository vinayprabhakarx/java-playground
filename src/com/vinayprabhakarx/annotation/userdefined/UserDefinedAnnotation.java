package com.vinayprabhakarx.annotation.userdefined;

import java.lang.reflect.Method;

public class UserDefinedAnnotation {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<OrderService> serviceClass = OrderService.class;

        // OrderService inherits AuditInfo from BaseService because AuditInfo uses @Inherited.
        AuditInfo classAuditInfo = serviceClass.getAnnotation(AuditInfo.class);
        System.out.println("Class created by: " + classAuditInfo.createdBy());
        System.out.println("Class description: " + classAuditInfo.description());

        Method method = serviceClass.getMethod("createOrder");
        AuditInfo methodAuditInfo = method.getAnnotation(AuditInfo.class);
        System.out.println("Method created by: " + methodAuditInfo.createdBy());
        System.out.println("Method description: " + methodAuditInfo.description());

        OrderService orderService = new OrderService();
        orderService.execute();
        orderService.createOrder();
    }
}
