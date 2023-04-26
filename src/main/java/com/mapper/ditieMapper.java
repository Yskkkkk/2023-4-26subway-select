package com.mapper;

import com.pojo.ditiepojo;
import com.pojo.huanc;
import com.pojo.zhandian;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ditieMapper {
    @Select("select  * from ditie1")
    List<ditiepojo> selectAll();
    List<ditiepojo> tiaocha(ditiepojo ditiepojo);
    List<ditiepojo> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("ditiepojo") ditiepojo ditiepojo);

    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(ditiepojo ditiepojo);
    //导入地铁信息
    @Insert("insert into ditie1 values(#{xianlu},#{cid},#{zhandian},#{huanc},null)")
    void add(ditiepojo ditiepojo);
    @Select("select *from ceshi1")
    List<zhandian> select();
    //导入换成信息
    @Insert("insert  into xjiao values (#{xianlu1},#{xianlu2},#{gzhandain})")
    void add1(huanc huanc);
    @Select("select * from ditie1 where zhandian=#{zhandian}")
    ditiepojo lix(@Param("zhandian")String zhandian);
    //查询起始点的信息
    @Select("select * from ditie1 where zhandian=#{zhandian}")

    List<ditiepojo> qzcha(@Param("zhandian")String zhandian);
    @Select("select * from ditie1 where zhandian=#{zhandian}and xianlu=#{xianlu}")
   ditiepojo qzchass(@Param("zhandian")String zhandian,@Param("xianlu")String xianlu);
    @Select("select * from ditie1 where xianlu=#{xianlu}")

    ditiepojo xzcha(@Param("xianlu")String xianlu);
    @Select("select * from ditie1 where id=#{id}")
    ditiepojo idcha(@Param("id")int id);
    //查询换乘
    @Select("select  * from xjiao where xianlu1=#{xianlu1}")
    List<huanc> hcha(@Param("xianlu1")String xianlu1);
    @Select("select  * from xjiao where xianlu1=#{xianlu1}and xianlu2=#{xianlu2}")
    huanc  licha(@Param("xianlu1")String xianlu1,@Param("xianlu2")String xianlu2);
    @Select("select * from ditie1 where huanc=#{huanc}")
    List<ditiepojo>cha0(@Param("huanc")String huanc);
    @Select("select * from ditie1 where xianlu=#{xianlu}")
    List<ditiepojo>xianlu(@Param("xianlu")String xianlu);
}
