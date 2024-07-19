package com.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author Kyrie.Wang
 */
@Entity
@Table(name = "titles")
@Getter
@Setter
public class Titles {
    @EmbeddedId
    private TitlesId id;

    @MapsId("empNo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_no", nullable = false)
    private Employees empNo;

    @Column(name = "to_date")
    private LocalDate toDate;


}
