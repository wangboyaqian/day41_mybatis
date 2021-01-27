package com.qfedu.mapper;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
    public void add(Employee employee);
    public void add2(Employee employee);
    public void add3(Employee employee);
    public List<Employee> findByCondition(Employee employee);
    public void update(Employee employee);
    public void deleteByIds(List<Integer> ids);
    public void deleteByIds1(Integer[] ids);
}
