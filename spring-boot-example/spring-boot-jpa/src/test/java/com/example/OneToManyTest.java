package com.example;

import com.example.domain.Employees;
import com.example.domain.Salaries;
import com.example.repository.EmployeeRepository;
import com.example.repository.SalariesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * OneToManyTest
 *
 * @author Kyrie.Wang
 */
@SpringBootTest
class OneToManyTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SalariesRepository salariesRepository;

    /**
     * 通过一查询多
     */
    @Test
    @Transactional(readOnly = true)
    void queryManyByOne() {
        Optional<Employees> employees = employeeRepository.findById(10008);
        System.out.println(employees);

        // 懒加载-需要在测试方法上标明@Transactional(readOnly = true)
        System.out.println("==========================");
        List<Salaries> salaries = employees.get().getSalaries();
        salaries.forEach(System.out::println);

    }

    @Test
    @Transactional
    @Commit
    void deleteManyByOne() {
        Employees emp = employeeRepository.findEmployeeByEmpNo(10001);

        List<Salaries> salaries = emp.getSalaries();

        Salaries salarie = new Salaries();
        salarie.setSalary(9999);
        salarie.setEmpNo(emp);
        salarie.setToDate(LocalDate.now());

        salariesRepository.save(salarie);
        // employeeRepository.delete(emp);

        // employeeRepository.save(emp);

    }


}
