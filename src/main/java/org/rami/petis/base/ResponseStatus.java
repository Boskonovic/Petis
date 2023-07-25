package org.rami.petis.base;

public enum ResponseStatus {
    PROPOSED(1), ACCEPTED(2), REJECTED(3);
    private final int code;
    ResponseStatus(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
