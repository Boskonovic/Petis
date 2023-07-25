package org.rami.petis.base;

public enum PetType {
    CAT(1),DOG(2),BIRD(3),OTHER(4);
    private final int code;
    PetType(int code) {
        this.code=code;
    }
    int getCode(){
        return this.code;
    }
}
