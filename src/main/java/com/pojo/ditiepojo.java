package com.pojo;

public class ditiepojo {
    private String xianlu;
    private String cid;
    private  String zhandian;
    private  String huanc;
    private int id;

    public ditiepojo(String xianlu, String cid, String zhandian, String huanc) {
        this.xianlu = xianlu;
        this.cid = cid;
        this.zhandian = zhandian;
        this.huanc = huanc;

    }



    public String getXianlu() {
        return xianlu;
    }

    public void setXianlu(String xianlu) {
        this.xianlu = xianlu;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getZhandian() {
        return zhandian;
    }

    public void setZhandian(String zhandian) {
        this.zhandian = zhandian;
    }

    public String getHuanc() {
        return huanc;
    }

    public void setHuanc(String huanc) {
        this.huanc = huanc;
    }

    @Override
    public String toString() {
        return "ditiepojo{" +
                "xianlu='" + xianlu + '\'' +
                ", cid='" + cid + '\'' +
                ", zhandian='" + zhandian + '\'' +
                ", huanc='" + huanc + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
