package com.web.servlet;

import com.pojo.ditiepojo;
import com.pojo.huanc;
import com.service.ditieService;
import com.service.impl.ditieimpl;

import java.util.List;

public class sunafa {
    private ditieService ditieServices=new ditieimpl();
    public  String jl = "";
    public  int zid=0; public String lu="";
    public int zd(String xianlu1,String xianlu2,String qdian,String zdian) {
        int lid1=0;int lid2=0;int id3=0;
        List<ditiepojo> qzcah = ditieServices.qzcah(qdian);
        int id = qzcah.get(0).getId();
        List<ditiepojo> qzcah2 = ditieServices.qzcah(zdian);
        int id2 = qzcah2.get(0).getId();
        if(id2>id)
        {
            lid1=id2-id;
            for(int i=id;i<=id2;i++)
            {
                ditiepojo idcha = ditieServices.idcha(i);
                // System.out.println(idcha.getZhandian());
                jl=jl+idcha.getZhandian();
                jl+=" ";

            }

        }
        else{
            lid1=id-id2;
            for(int i=id;i>=id2;i--)
            {
                ditiepojo idcha = ditieServices.idcha(i);
                // System.out.println(idcha.getZhandian());
                jl=jl+idcha.getZhandian();
                jl+=" ";

            }

        }zid=zid+lid1;
        return zid;
    }
    public String hx(String xianlu1,String xianlu2)
    {
        List<huanc> hcha = ditieServices.hcha(xianlu1);
        for(huanc u:hcha)
        {
            if(u.getXianlu2().equals(xianlu2))
            {
                lu=lu+xianlu1+" "+u.getXianlu2();
                break;
                // return 1;
            }
            else{
                lu=lu+u.getXianlu1()+" ";
                hx(u.getXianlu2(),xianlu2);
            }
        }
        return lu;

    }
}
