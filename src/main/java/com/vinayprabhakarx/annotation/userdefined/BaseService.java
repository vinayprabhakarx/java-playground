package com.vinayprabhakarx.annotation.userdefined;

@AuditInfo(createdBy = "Vinay", description = "Base class annotation")
public class BaseService {
    public void execute() {
        System.out.println("Base service executed");
    }
}
