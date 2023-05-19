package com.api.backend.entity;

public enum Status {
    PENDING("En cours"),
    PAY("PAYER");

    String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Status() {
    }
}
