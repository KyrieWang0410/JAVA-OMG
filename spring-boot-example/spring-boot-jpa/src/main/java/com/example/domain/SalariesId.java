package com.example.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class SalariesId implements Serializable {
    private static final long serialVersionUID = -3598789827464869130L;
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;


}
