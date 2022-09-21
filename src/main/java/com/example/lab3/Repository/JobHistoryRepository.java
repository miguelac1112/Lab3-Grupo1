package com.example.lab3.Repository;

import com.example.lab3.Entity.JobHistory;
import com.example.lab3.Entity.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
}