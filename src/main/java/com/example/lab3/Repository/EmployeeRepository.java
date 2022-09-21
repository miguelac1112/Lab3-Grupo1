package com.example.lab3.Repository;

import com.example.lab3.Dto.EmployeeDto;
import com.example.lab3.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value="SELECT e.employee_id, e.first_name, e.last_name, e.email, j.job_title, e.salary, \n" +
            "\t\t l.city, d.department_name\n" +
            "FROM employees e\n" +
            "\tinner join jobs j on (e.job_id = j.job_id)\n" +
            "    inner join departments d on (e.department_id = d.department_id)\n" +
            "    inner join locations l on (d.location_id = l.location_id)\n" +
            "    inner join countries c on (l.country_id = c.country_id)\n" +
            "    inner join regions r on (c.region_id = r.region_id)\n" +
            "    inner join employees m on (e.manager_id = m.employee_id)\n" +
            "order by employee_id;\n",nativeQuery = true)
    List<EmployeeDto> obtenerEmpleados();

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE `hr`.`employees` SET `manager_id` = ?1, `job_id` = ?2 WHERE (`employee_id` = ?3);")
    void actualizarEmpleado(int managerid, int jobid, int empleadoid);



    @Query(value="SELECT * FROM employees group by manager_id",nativeQuery = true)
    List <Employee> buscaJefes();



}