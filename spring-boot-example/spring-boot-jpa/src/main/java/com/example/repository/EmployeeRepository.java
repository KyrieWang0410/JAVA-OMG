package com.example.repository;

import com.example.domain.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * EmployeeRepository
 *
 * @author Kyrie.Wang
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Integer>, JpaSpecificationExecutor<Employees> {
    /**
     * 通过员工编号查询员工信息
     *
     * @param empno 员工工号
     * @return 员工对象
     */
    Employees findEmployeeByEmpNo(Integer empno);

    /**
     * 通过姓模糊查询
     *
     * @param lastName 名字前缀
     * @return Employees 集合
     */
    List<Employees> findTopByLastNameStartingWith(String lastName);


    /**
     * 根据 性别 和 姓氏 统计员工个数
     * @return 员工个数
     * @param gender 性别
     * @param lastName 姓氏
     */
    int countByGenderAndLastNameLike(String gender, String lastName);



    /**
     * 通过司龄获取员工
     *
     * @param year 入职年份
     * @return 员工列表
     */
    @Query(value = "SELECT * FROM Employees e WHERE DATE(hire_date) <=  DATE_SUB(CURDATE(), INTERVAL :year YEAR)", nativeQuery = true)
    List<Employees> queryEmployeesBySeniority(@Param("year") Integer year);


}
