package com.qfedu.cache;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    private static SqlSessionFactory factory = null;
    static {
        Reader resourceAsReader = null;
        try {
            resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(resourceAsReader);

    }
    public static void select () {
        SqlSession session = factory.openSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee byId = mapper.findById(6);
        System.out.println(byId.getName());

        //查询相同的记录，session 关闭之前，会放到一级缓存中，session  直接从session中取出来
        Employee byId2 = mapper.findById(6);
        System.out.println(byId2.getName());
        session.commit();
        session.close();

    }
    public static void select1(){
        SqlSession session1 = factory.openSession();
        EmployeeDao mapper = session1.getMapper(EmployeeDao.class);
        Employee byId = mapper.findById(5);
        System.out.println(byId.getName());
        session1.commit();
        session1.close();
        SqlSession session2 = factory.openSession();
        EmployeeDao mapper1 = session2.getMapper(EmployeeDao.class);
        System.out.println(mapper1.findById(5).getName());
        session2.commit();
        session2.close();
    }
    public static void main(String[] args) {
        select1();
    }
}
