package com.pojo;

public class lix {
    private String qidian;
    private String zdain;

    public lix(String qidian, String zdain) {
        this.qidian = qidian;
        this.zdain = zdain;
    }

    @Override
    public String toString() {
        return "lix{" +
                "qidian='" + qidian + '\'' +
                ", zdain='" + zdain + '\'' +
                '}';
    }

    public String getQidian() {
        return qidian;
    }

    public void setQidian(String qidian) {
        this.qidian = qidian;
    }

    public String getZdain() {
        return zdain;
    }

    public void setZdain(String zdain) {
        this.zdain = zdain;
    }
}
