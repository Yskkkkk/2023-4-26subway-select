package com.service.impl;

import com.mapper.ditieMapper;
import com.pojo.PageBean;
import com.pojo.ditiepojo;
import com.pojo.huanc;
import com.pojo.zhandian;
import com.service.ditieService;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ditieimpl implements ditieService{
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<ditiepojo> selectAll() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);

        //4. 调用方法
        List<ditiepojo> ditiepojos = mapper.selectAll();

        //5. 释放资源
        sqlSession.close();

        return ditiepojos;
    }



    @Override
    public List<ditiepojo> tiaocha(ditiepojo ditiepojo) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);
        String xianlu = ditiepojo.getXianlu();
        if (xianlu != null && xianlu.length() > 0) {
            ditiepojo.setXianlu("%" + xianlu+ "%");
        }

        String zhandian = ditiepojo.getZhandian();
        if (zhandian!= null && zhandian.length() > 0) {
            ditiepojo.setZhandian("%" + zhandian+ "%");
        }
        //4. 调用方法
        List<ditiepojo> ditiepojos = mapper.tiaocha(ditiepojo);


        //5. 释放资源
        sqlSession.close();

        return ditiepojos;
    }

    @Override
    public PageBean<ditiepojo> selectByPageAndCondition(int currentPage, int pageSize, ditiepojo ditiepojo) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
       ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);


        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        String xianlu = ditiepojo.getXianlu();
        if (xianlu != null && xianlu.length() > 0) {
            ditiepojo.setXianlu("%" + xianlu+ "%");
        }

        String zhandian = ditiepojo.getZhandian();
        if (zhandian!= null && zhandian.length() > 0) {
            ditiepojo.setZhandian("%" + zhandian+ "%");
        }

        //5. 查询当前页数据
        List<ditiepojo> rows = mapper.selectByPageAndCondition(begin, size, ditiepojo);

        //6. 查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(ditiepojo);

        //7. 封装PageBean对象
        PageBean<ditiepojo> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        //8. 释放资源
        sqlSession.close();

        return pageBean;
    }

    @Override
    public void add(ditiepojo ditiepojo) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
       ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);

        //4. 调用方法
        mapper.add(ditiepojo);
        sqlSession.commit();//提交事务
        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public List<zhandian> select() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);
        List<zhandian> select = mapper.select();
        return select;
    }

    @Override
    public void add1(huanc huanc) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);

        //4. 调用方法
        mapper.add1(huanc);
        sqlSession.commit();//提交事务
        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public List<ditiepojo> qzcah(String zhandian) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);
        List<ditiepojo> qzcha = mapper.qzcha(zhandian);
        sqlSession.close();
        return qzcha;

}

    @Override
    public ditiepojo idcha(int id) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);
       ditiepojo idcha = mapper.idcha(id);
        return  idcha;
    }

    @Override
    public List<huanc> hcha(String xianlu1) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);
        List<huanc> hcha = mapper.hcha(xianlu1);
        sqlSession.close();
        return hcha;
    }

    @Override
    public ditiepojo xzcha(String xianlu) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);
        ditiepojo xzcha = mapper.xzcha(xianlu);
        return xzcha;
    }

    @Override
    public huanc licah(String xianlu1, String xianlu2) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);
        huanc licha = mapper.licha(xianlu1, xianlu2);
        return licha;
    }

    @Override
    public ditiepojo qzchass(String zhandian, String xianlu) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);
        ditiepojo qzchass = mapper.qzchass(zhandian, xianlu);
        return qzchass;
    }

    @Override
    public List<ditiepojo> cha0(String haunc) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);
        List<ditiepojo> huancs = mapper.cha0(haunc);
        return huancs;
    }

    @Override
    public List<ditiepojo> xianlu(String xianlu) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);
        List<ditiepojo> xianlu1 = mapper.xianlu(xianlu);
        return xianlu1;
    }

    @Override
    public ditiepojo lix(String zhandian) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ditieMapper mapper = sqlSession.getMapper(ditieMapper.class);
        ditiepojo lix = mapper.lix(zhandian);
        return lix;
    }
}
