package com.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Kyrie.Wang
 */
@Embeddable
@Getter
@Setter
public class TitlesId implements Serializable {
    private static final long serialVersionUID = -5072311849576088448L;
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

}
