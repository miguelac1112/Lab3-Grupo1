package com.example.lab3.Repository;

import com.example.lab3.Dto.SalarioDto;
import com.example.lab3.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
    @Query(value = "select job_title, concat('$ ',max_salary) as 'max_salary', concat('$ ',min_salary) as 'min_salary', concat('$ ',sum(salary)) as 'total', concat('$ ',round(avg(salary),2))  as 'promedio'\n" +
            "from employees e\n" +
            "\tinner join jobs j on (e.job_id = j.job_id)\n" +
            "group by e.job_id;",nativeQuery = true)
    List<SalarioDto> salarios();
}