package com.pojo;

public class huanc {
    private String xianlu1;
    private String xianlu2;
    private String gzhandain;

    public huanc(String xianlu1, String xianlu2, String gzhandain) {
        this.xianlu1 = xianlu1;
        this.xianlu2 = xianlu2;
        this.gzhandain = gzhandain;
    }

    @Override
    public String toString() {
        return "huanc{" +
                "xianlu1='" + xianlu1 + '\'' +
                ", xianlu2='" + xianlu2 + '\'' +
                ", gzhandain='" + gzhandain + '\'' +
                '}';
    }

    public String getXianlu1() {
        return xianlu1;
    }

    public void setXianlu1(String xianlu1) {
        this.xianlu1 = xianlu1;
    }

    public String getXianlu2() {
        return xianlu2;
    }

    public void setXianlu2(String xianlu2) {
        this.xianlu2 = xianlu2;
    }

    public String getGzhandain() {
        return gzhandain;
    }

    public void setGzhandain(String gzhandain) {
        this.gzhandain = gzhandain;
    }
}
