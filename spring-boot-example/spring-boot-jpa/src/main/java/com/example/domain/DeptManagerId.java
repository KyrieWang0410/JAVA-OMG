package com.example.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Kyrie.Wang
 */
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class DeptManagerId implements Serializable {
    private static final long serialVersionUID = 6277859520611270439L;
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;
    @Column(name = "dept_no", nullable = false, length = 4)
    private String deptNo;


}
