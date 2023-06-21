package com.athomas5.javaspring.database.dao;

import com.athomas5.javaspring.model.Workflow;
import com.athomas5.javaspring.repositories.WorkflowRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class WorkflowDAO implements DAO<Workflow> {
    WorkflowRepository workflowRepository;

    public WorkflowDAO(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    @Override
    public List<Workflow> get(List<Long> ids) {
        return workflowRepository.findAllById(ids);
    }

    @Override
    public List<Workflow> list() {
        return workflowRepository.findAll();
    }

    @Override
    public Workflow create(Workflow workflow) {
        workflowRepository.save(workflow);
        return workflow;
    }

    @Override
    public Workflow update(Workflow workflow) {
        return workflowRepository.save(workflow);
    }

    @Override
    public void delete(long id) {
        workflowRepository.deleteById(id);
    }
}
