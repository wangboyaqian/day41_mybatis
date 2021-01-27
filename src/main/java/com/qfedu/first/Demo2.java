package com.qfedu.first;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo2 {
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
    public static void add2() {
        SqlSession session = factory.openSession();
        //开始执行插入的操作
        Employee employee = new Employee();
        employee.setName("老邢");
        employee.setAge(36);
        employee.setSex("男");
        session.insert("empMapper.add2", employee);
        session.commit();
        session.close();
    }

    public static void add3() {
        SqlSession session = factory.openSession();
        session.insert("empMapper.add3", "帅栋");
        session.commit();
        session.close();
    }
    public static void add4() {
        SqlSession session = factory.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "小萝卜");
        map.put("age", 18);

        session.insert("empMapper.add4", map);
        session.commit();
        session.close();
    }
    public static void deleteById() {
        SqlSession session = factory.openSession();
        session.delete("empMapper.deleteById", 4);
        session.commit();
        session.close();
    }
    public static void update(){
        SqlSession session = factory.openSession();
        Employee employee = new Employee();
        employee.setId(3);
        employee.setName("杨仔");
        employee.setSex("男");
        employee.setAge(36);
        employee.setPhone("16728829");
        session.update("empMapper.update", employee);
        session.commit();
        session.close();
    }
    public static void findAll() {
        SqlSession session = factory.openSession();
        List<Employee> employees = session.selectList("empMapper.findAll");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        session.commit();
        session.close();
    }
    public static void findId() {
        SqlSession session = factory.openSession();
        Employee employee = session.selectOne("empMapper.findById2", 3);
        System.out.println(employee);
        session.commit();
        session.close();
    }
    public static void findByAge() {
        SqlSession session = factory.openSession();
        Employee employee1 = new Employee();
        employee1.setAge(36);
        List<Employee> employee = session.selectList("empMapper.findByAge", employee1);
        for (Employee employee2 : employee) {
            System.out.println(employee2);
        }
        session.commit();
        session.close();
    }
    public static void findByAge1() {
        SqlSession session = factory.openSession();

        List<Employee> employee = session.selectList("empMapper.findByAge1", 50);
        for (Employee employee2 : employee) {
            System.out.println(employee2);
        }
        session.commit();
        session.close();
    }
    public static void main(String[] args) {
       //add4();
        //deleteById();
       // update();
        //findId();
        findByAge1();
    }
}
