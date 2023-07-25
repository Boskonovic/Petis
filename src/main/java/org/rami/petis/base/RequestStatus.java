package org.rami.petis.base;

public enum RequestStatus {
    NEW(1),SOLVED(2),CANCELLED(3);
    private final int code;
    RequestStatus(int code) {
        this.code=code;
    }
    int getCode(){
        return this.code;
    }
}
