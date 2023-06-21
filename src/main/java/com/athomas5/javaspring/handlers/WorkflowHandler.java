package com.athomas5.javaspring.handlers;

import com.athomas5.javaspring.database.dao.WorkflowDAO;
import com.athomas5.javaspring.dto.WorkflowRequest;
import com.athomas5.javaspring.dto.WorkflowResponse;
import com.athomas5.javaspring.exceptions.InvalidRequestException;
import com.athomas5.javaspring.utils.IdGenerator;
import com.athomas5.javaspring.validation.ValidationResult;
import com.athomas5.javaspring.validation.WorkflowValidator;
import lombok.RequiredArgsConstructor;
import com.athomas5.javaspring.model.Workflow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowHandler {
    private final WorkflowDAO workflowDAO;
    private final WorkflowValidator workflowValidator;

    public List<WorkflowResponse> getWorkflows(List<Long> workflowIds) {
        return workflowDAO.get(workflowIds)
                .stream()
                .map(this::mapToWorkflowResponse)
                .toList();
    }

    public List<WorkflowResponse> listWorkflows() {
        return workflowDAO.list()
                .stream()
                .map(this::mapToWorkflowResponse)
                .toList();
    }

    public WorkflowResponse createWorkflow(WorkflowRequest workflowRequest) throws InvalidRequestException {
        Workflow initializeWorkflow = initializeWorkflow(workflowRequest);
        validateNewWorkflow(initializeWorkflow);

        return mapToWorkflowResponse(workflowDAO.create(initializeWorkflow));
    }

    public WorkflowResponse updateWorkflow(WorkflowRequest workflowRequest) {
        Workflow workflow = convertToWorkflow(workflowRequest);

        return mapToWorkflowResponse(workflowDAO.update(workflow));
    }

    public void deleteWorkflow(long id) {
        workflowDAO.delete(id);
    }

    public Workflow convertToWorkflow(WorkflowRequest workflowRequest) {
        return Workflow.builder()
                .id(workflowRequest.getId())
                .name(workflowRequest.getName())
                .testWorkflow(workflowRequest.isTestWorkflow())
                .build();
    }

    private WorkflowResponse mapToWorkflowResponse(Workflow workflow) {
        return WorkflowResponse.builder()
            .id(workflow.getId())
            .name(workflow.getName())
            .testWorkflow(workflow.isTestWorkflow())
            .build();
    }

    private Workflow initializeWorkflow(WorkflowRequest workflowRequest) {
        return Workflow.builder()
                .id(IdGenerator.generateId())
                .name(workflowRequest.getName())
                .testWorkflow(workflowRequest.isTestWorkflow())
                .build();
    }

    private void validateNewWorkflow(Workflow workflow) throws InvalidRequestException {
        ValidationResult workflowValidationResult = workflowValidator.validate(workflow);

        if (!workflowValidationResult.isValid()) {
            List<String> validationErrors = workflowValidationResult.getValidationMessages();
            throw new InvalidRequestException(String.join(" ", validationErrors));
        }
    }
}
