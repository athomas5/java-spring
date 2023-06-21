package com.athomas5.javaspring.repositories;

import com.athomas5.javaspring.model.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
}
