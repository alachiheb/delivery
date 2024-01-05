package com.carrefour.delivery.exception;


public enum DeliverySlotExceptionMessage {

    DELIVERY_SLOT_NOT_FOUND( "Ce creneau n'existe pas", 1);

    private final String description;
    private final String code;

    private DeliverySlotExceptionMessage(String description, int code) {
        this.code = String.valueOf(code);
        this.description = description;
    }

    public String toErrorMessage() {
        return String.join(" : ", this.code,this.description);
    }
}
