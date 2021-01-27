package com.qfedu.one2many;

import java.util.List;

public interface DepartmentDao {
    public Department findByDid(Integer did);
    public Department findByDid2(Integer did);
    public List<Department> findAll();
}
