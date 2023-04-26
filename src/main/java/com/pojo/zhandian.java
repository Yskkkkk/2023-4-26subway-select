package com.pojo;

public class zhandian {
    private String xianlu;
    private String zhandian1;

    public zhandian(String xianlu, String zhandian1) {
        this.xianlu = xianlu;
        this.zhandian1 = zhandian1;
    }

    public String getXianlu() {
        return xianlu;
    }

    public void setXianlu(String xianlu) {
        this.xianlu = xianlu;
    }

    public String getZhandian1() {
        return zhandian1;
    }

    public void setZhandian1(String zhandian1) {
        this.zhandian1 = zhandian1;
    }

    @Override
    public String toString() {
        return "zhandian{" +
                "xianlu='" + xianlu + '\'' +
                ", zhandian1='" + zhandian1 + '\'' +
                '}';
    }
}
