package com.qfedu.mapper;

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
    public static void findAll() {
        SqlSession session = factory.openSession();
        //获取某个接口的代理对象
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        List<Employee> all = mapper.findAll();
        for (Employee employee : all) {
            System.out.println(employee);
        }
        session.commit();
        session.close();

    }
    public static void add() {
        SqlSession session = factory.openSession();
        //获取某个接口的代理对象
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setName("翠花");
        employee.setAge(20);
        mapper.add2(employee);
        System.out.println(employee.getId());//null
        session.commit();
        session.close();
    }

    public static void add3() {
        SqlSession session = factory.openSession();
        //获取某个接口的代理对象
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setName("胡萝卜");
        employee.setSex("男");
        mapper.add3(employee);

        session.commit();
        session.close();
    }
    public static void findByCondition() {
        SqlSession session = factory.openSession();
        //获取某个接口的代理对象
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee employee = new Employee();
//        employee.setName("翠花");
//        employee.setAge(89);
        List<Employee> byCondition = mapper.findByCondition(employee);
        for (Employee employee1 : byCondition) {
            System.out.println(employee1);
        }
        session.commit();
        session.close();
    }
    public static void update() {
        SqlSession session = factory.openSession();
        //获取某个接口的代理对象
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setId(9);
        employee.setName("翠花3");
        employee.setAge(89);
        employee.setSex("男");
        mapper.update(employee);
        session.commit();
        session.close();
    }
    public static void deleteByIds() {
        SqlSession session = factory.openSession();
        //获取某个接口的代理对象
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        List<Integer> integers = new ArrayList<>();
        integers.add(7);
        integers.add(8);
        integers.add(9);
        mapper.deleteByIds(integers);
        session.commit();
        session.close();
    }
    public static void deleteByIds1() {
        SqlSession session = factory.openSession();
        //获取某个接口的代理对象
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);

        mapper.deleteByIds1(new Integer[]{1, 2,3});
        session.commit();
        session.close();
    }
    public static void main(String[] args) {
        deleteByIds1();
    }
}
