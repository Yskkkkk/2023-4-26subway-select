package com.service;

import com.pojo.PageBean;
import com.pojo.ditiepojo;
import com.pojo.huanc;
import com.pojo.zhandian;

import java.util.List;

public interface ditieService {
    List<ditiepojo> selectAll();
    List<ditiepojo> tiaocha(ditiepojo ditiepojo);
    PageBean<ditiepojo> selectByPageAndCondition(int currentPage, int pageSize, ditiepojo ditiepojo);
    void add(ditiepojo ditiepojo);
    List<zhandian> select();
    void add1(huanc huanc);
    List<ditiepojo> qzcah(String zhandian);
    ditiepojo idcha(int id);
    List<huanc> hcha(String xianlu1);
    ditiepojo xzcha(String xianlu);
    huanc licah(String xianlu1,String xianlu2);
    ditiepojo qzchass(String zhandian,String xianlu);
    List<ditiepojo>cha0(String haunc);
    List<ditiepojo>xianlu(String xianlu);
    ditiepojo lix(String zhandian);

}
