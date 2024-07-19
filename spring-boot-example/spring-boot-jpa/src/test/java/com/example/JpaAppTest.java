package com.example;

import com.example.domain.Employees;
import com.example.enums.Gender;
import com.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * 程序测试类
 *
 * @author Kyrie.Wang
 */
@SpringBootTest
class JpaAppTest {

    @Autowired
    EmployeeRepository employeeRepository;


    /** 普通查询 */
    @Test
    void queryNormal() {
        List<Employees> employees = employeeRepository.findAll();
        employees.forEach(System.out::println);
    }

    /** 测试分页查询 */
    @Test
    void queryPaging() {
        Page<Employees> employees = employeeRepository.findAll(PageRequest.of(2, 5));
        employees.forEach(System.out::println);
    }

    /** 测试分页排序 */
    @Test
    void queryPagingSort() {
        // 声明类型安全
        Sort.TypedSort<Employees> typedSort = Sort.sort(Employees.class);
        Sort sort = typedSort.by(Employees::getBirthDate).descending();

        Page<Employees> employees = employeeRepository.findAll(PageRequest.of(0, 10, sort));
        employees.forEach(System.out::println);
    }

    /** Example 查询方式 */
    @Test
    void queryExample() {

        Employees employees = new Employees();
        employees.setEmpNo(10004);
        employees.setFirstName("CHIRSTIAN");

        // 匹配器
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase("firstName");

        Example<Employees> example = Example.of(employees, matcher);
        List<Employees> list = employeeRepository.findAll(example);

        System.out.println("==================");
        list.forEach(System.out::println);
        System.out.println("==================");
    }

    /** 通过Specification 查询 **/
    @Test
    void querySpecification() {
        List<Employees> employees = employeeRepository.findAll((Specification<Employees>) (root, query, criteria) -> {

            Path<Integer> empNo = root.get("empNo");
            Path<String> gender = root.get("gender");

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteria.lessThan(empNo, 10004));
            predicates.add(criteria.equal(gender, Gender.F.getKey()));

            return criteria.and(predicates.toArray(new Predicate[0]));
        });

        employees.forEach(System.out::println);
    }

    /** 通过 命名接口 查询*/
    @Test
    void queryNamed() {
        Employees employee = employeeRepository.findEmployeeByEmpNo(10007);
        System.out.println(employee);

        List<Employees> employeesList = employeeRepository.findTopByLastNameStartingWith("Kall");
        System.out.println("==================");
        employeesList.forEach(System.out::println);
        System.out.println("==================");

        int i = employeeRepository.countByGenderAndLastNameLike("F","%t%");
        System.out.println("======================="+ i);
    }

    /** 通过 nativeQuery 查询*/
    @Test
    void queryHQL() {
        List<Employees> employeesList = employeeRepository.queryEmployeesBySeniority(35);
        System.out.println("==================");
        employeesList.forEach(System.out::println);
        System.out.println("==================");
    }


}
