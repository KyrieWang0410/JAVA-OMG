package com.example.repository;

import com.example.domain.Salaries;
import com.example.domain.SalariesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Kyrie.Wang
 */
public interface SalariesRepository extends JpaRepository<Salaries,SalariesId>, JpaSpecificationExecutor<Salaries> {
}
