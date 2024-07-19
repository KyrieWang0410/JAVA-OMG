package com.example;

import com.example.domain.Employees;
import com.example.domain.Salaries;
import com.example.repository.SalariesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

/**
 * 多对一表关联查询
 *
 * @author Kyrie.Wang
 */
@SpringBootTest
class ManyToOneTest {

    @Autowired
    SalariesRepository salariesRepository;



    /**
     * 通过一查询多
     */
    @Test
    @Transactional(readOnly = true)
    void test1() {
        Employees emp = new Employees();
        emp.setEmpNo(10001);
        Sort.TypedSort<Salaries> typedSort = Sort.sort(Salaries.class);
    }



}
