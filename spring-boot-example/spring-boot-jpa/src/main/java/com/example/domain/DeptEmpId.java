package com.example.domain;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Kyrie.Wang
 */
@Embeddable
public class DeptEmpId implements Serializable {
    private static final long serialVersionUID = 8351654235192745024L;
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;
    @Column(name = "dept_no", nullable = false, length = 4)
    private String deptNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        DeptEmpId deptEmpId = (DeptEmpId) o;
        return empNo != null && Objects.equals(empNo, deptEmpId.empNo)
                && deptNo != null && Objects.equals(deptNo, deptEmpId.deptNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, deptNo);
    }
}
