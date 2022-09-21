package com.example.lab3.Repository;

import com.example.lab3.Entity.JobHistory;
import com.example.lab3.Entity.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {

    @Query(value="SELECT e.employee_id, concat(e.first_name, \" \",e.last_name) 'Nombre', j.job_title, d.department_name, \n" +
            "\t\tconcat(m.first_name, \" \", m.last_name) 'jefe', h.start_date, h.end_date\n" +
            "FROM employees e \n" +
            "\tinner join job_history h on (e.employee_id = h.employee_id)\n" +
            "    inner join jobs j on (e.job_id = j.job_id)\n" +
            "    inner join departments d on (e.department_id = d.department_id)\n" +
            "    inner join employees m on (e.manager_id = m.employee_id)\n" +
            "order by start_date desc", nativeQuery = true)
    List<JobHistory> ObtenerHistorial();

}