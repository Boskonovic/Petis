package org.rami.petis.base;

public enum UserType {
    ADMIN(0),OWNER(1),SITTER(2),BOTH(3);
    private final int code;
    UserType(int code) {
        this.code = code;
    }
    int getCode(){
        return this.code;
    }
}
