package com.qfedu.one2many;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
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
        DepartmentDao mapper = session.getMapper(DepartmentDao.class);
        Department department = mapper.findByDid(1);
        List<Employee> empList = department.getEmpList();
        for (Employee employee : empList) {
            System.out.println(employee);
        }
        session.commit();
        session.close();
    }
    public static void select1 () {
        SqlSession session = factory.openSession();
        DepartmentDao mapper = session.getMapper(DepartmentDao.class);
        Department department = mapper.findByDid2(1);
        List<Employee> empList = department.getEmpList();
        for (Employee employee : empList) {
            System.out.println(employee);
        }
        session.commit();
        session.close();
    }
    public static void findAll () {
        SqlSession session = factory.openSession();
        DepartmentDao mapper = session.getMapper(DepartmentDao.class);
        List<Department> all = mapper.findAll();
        for (Department department : all) {

            List<Employee> empList = department.getEmpList();
            for (Employee employee : empList) {
                System.out.println(employee);
            }
        }

        session.commit();
        session.close();
    }
    public static void findByEid(){
        SqlSession session = factory.openSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee employee = mapper.findByEid1(1);
        System.out.println(employee.getEname());
//        Department dept = employee.getDept();
//        System.out.println(dept.getDname());
        session.commit();
        session.close();
    }
    public static void main(String[] args) {
        findByEid();
    }
}
