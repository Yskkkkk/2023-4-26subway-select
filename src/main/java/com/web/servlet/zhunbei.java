package com.web.servlet;

import com.pojo.ditiepojo;
import com.service.ditieService;
import com.service.impl.ditieimpl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class zhunbei {
    public int op=0;
    public int linenum = 0;public List<Line> lines = new ArrayList<>();
    private ditieService ditieServices=new ditieimpl();
    public List<String> stations = new ArrayList<String>();
    public List<Line> lines2 = new ArrayList<>();//存储.txt中的所有数据
    public Result result;
    public Map map;
    public List<String> list1 = new ArrayList<>(); //存储经过单个站点的地铁线的名字，以列表储存
    public List<List<String>> lists = new ArrayList<>(); //存储经过所有站点的地铁线的名字，将list1依次添加进lists中
    public List<Integer> passStation = new ArrayList<>(); //储存经过站点在数组中的下标
    public void zhunbei1s()
    {
        String content="";
        List<ditiepojo> ditiepojos = ditieServices.selectAll();
        int size = ditiepojos.size();
        String linename="";linename=ditiepojos.get(0).getXianlu();
        for(int i=0;i<size-1;i++)
        {
            if(ditiepojos.get(i).getXianlu().equals(ditiepojos.get(i+1).getXianlu())==false)
            {
                //System.out.println(ditiepojos.get(i).getZhandian());
                content+=ditiepojos.get(i).getZhandian()+" ";
                Line newline = new Line();
                List<String> line = new ArrayList<String>();
                String[] station_single = content.split(" ");
                for(int j=0;j<station_single.length;j++) {
                    if(j==station_single.length-1 && station_single[j].equals(station_single[1]))
                        continue;
                    line.add(station_single[j]);
                }
                newline.setName(linename);
                newline.setStations(line);
                lines.add(newline);
                linename=ditiepojos.get(i+1).getXianlu();
                content="";

            }
            else
            {
                content+=ditiepojos.get(i).getZhandian()+" ";
            }

        }
        content+=ditiepojos.get(size-1).getZhandian();
        Line newline = new Line();
        List<String> line = new ArrayList<String>();
        String[] station_single = content.split(" ");
        for(int j=0;j<station_single.length;j++) {
            if(j==station_single.length-1 && station_single[j].equals(station_single[1]))
                continue;
            line.add(station_single[j]);
        }
        newline.setName(linename);
        newline.setStations(line);
        lines.add(newline);
        int size1 = lines.size();linenum=size1;



    }
    public String zuiduan(String qidian,String zdian)
    {
        zhunbei1s();
        lines2.addAll(lines);
        //把所有站点加入stations中
        for(int i=0;i<linenum;i++) {
            stations.addAll(lines.get(i).getStations());
        }
        map = new Map(stations);//此map非彼map

        //初始化各个站点间的距离为1
        for(int i=0;i<lines.size();i++) {
            for(int j=0;j<lines.get(i).getStations().size()-1;j++) {
                map.initDis(lines.get(i).getStations().get(j), lines.get(i).getStations().get(j+1));
            }
        }

        //求最短路径
        result = new Result(map.getSubwayline());
        int qw = map.getIndex(qidian);
        System.out.println(qw);
        int j = map.getIndex(zdian);
        System.out.println(j);
        int shortest = result.getMinDis(qw,j);
        shortest++;
        System.out.println(shortest);
        String path="";
        //  String path = qidian+"到"+zdian+"需经过"+shortest+"个站\n";
        passStation = result.indexToList(qw,j);
        for(int k=0;k<passStation.size();k++) {
            String ty="";
            List<String> list = new ArrayList<>();
            if(op==1)
            {
                ty=map.getName(passStation.get(k));
            }
            else
            {path+=(map.getName(passStation.get(k)));}
//					System.out.println(path);
            int size = lines2.size();int h=0;int gs=0;
            //System.out.print(size);
            for(Line l:lines2) {
                int flag=0;
                for(String name:l.getStations()) {
                    //System.out.println(map.getName(passStation.get(k)));

                    if(map.getName(passStation.get(k)).equals(name)){ //path+="（";
                        // path+=(l.getName());
                        //path+="）";
                       /* if(op==1)
                        {
                            path+=l.getName()+" "+ty;op=0;
                        }
                            gs++;*/
                        // System.out.println(path);
                        list.add(l.getName());
                        //System.out.println(l.getName());
                        if(!list1.contains(name)) {
                            list1.add(name);
                            //System.out.println(name);
                            flag=1;
                        }
                    }
                }
                if(flag==1) lists.add(list);

            }
/*
               if(gs>1)
               {
                   path+="转线站";op=1;
               }
              */ if(op==0)
            {
                path+=" ";
            }


        }
        //path+=")";
        //path+="\n";

        List<String> transfer = new ArrayList<>();
        for(int p=2;p<lists.size();p++) {
            int flag=0;
            for(int q=0;q<lists.get(p).size();q++) {
                for(int w=0;w<lists.get(p-2).size();w++)
                    if(lists.get(p-2).get(w).equals(lists.get(p).get(q))) {
                        flag=1;break;
                    }
            }
            if(flag==0) {
                if(!transfer.contains(list1.get(p-1))); {transfer.add(list1.get(p-1));
                }
            }
        }
        //path+="）"        }
        String[] split = path.split(" ");
        int b=split.length;
        path+="需要换乘"+transfer.size()+"次：";
        for(int a=0;a<transfer.size();a++) {
            System.out.println(transfer.get(a));
            String xianlu="";
            for(int i=0;i<b-1;i++)
            {
                if(split[i].equals(transfer.get(a)))
                {
                    List<ditiepojo> qzcah = ditieServices.qzcah(split[i + 1]);
                    int gh=qzcah.size();
                    if(gh<2)
                    {
                        xianlu = qzcah.get(0).getXianlu();
                    }
                    else {
                        int op=0;
                        List<ditiepojo> qzcah1 = ditieServices.qzcah(split[i]);
                        int fh=qzcah1.size();
                        for(int u=0;u<fh;u++)
                        {
                            for(int ui=0;ui<gh;ui++)
                            {
                                if(qzcah1.get(u).getXianlu().equals(qzcah.get(ui).getXianlu()))
                                {
                                    op=1;
                                    xianlu=qzcah.get(ui).getXianlu();
                                    break;
                                }
                            }
                            if(op==1)
                            {
                                break;
                            }
                            op=0;
                        }
                    }
                    break;
                }
            }
            path+=(transfer.get(a)+"换乘"+xianlu+" ");
            //path+=(transfer.get(a)+" ");
        }

        path+=qidian+"到"+zdian+"需经过"+shortest+"个站";
        System.out.println(path);
        return path;

    }
}
