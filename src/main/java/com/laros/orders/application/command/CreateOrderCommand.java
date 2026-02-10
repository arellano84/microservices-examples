package com.laros.orders.application.command;

public class CreateOrderCommand {

    private String description;

    public CreateOrderCommand() {}

    public CreateOrderCommand(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
