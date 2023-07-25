package org.rami.petis.base;

public enum ReviewGrade {
    WORST(0), BAD(1), ACCEPTABLE(2), GOOD(3), WONDERFUL(4);
    private final int  grade;
    ReviewGrade(int code) {
        this.grade = code;
    }
    public int getGrade() {
        return grade;
    }
}
