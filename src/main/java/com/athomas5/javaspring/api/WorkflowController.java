package com.athomas5.javaspring.api;

import com.athomas5.javaspring.dto.WorkflowRequest;
import com.athomas5.javaspring.dto.WorkflowResponse;
import com.athomas5.javaspring.handlers.WorkflowHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workflow")
public class WorkflowController {
    private final WorkflowHandler workflowHandler;

    public WorkflowController(WorkflowHandler workflowHandler) {
        this.workflowHandler = workflowHandler;
    }

    @PostMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<WorkflowResponse> getWorkflows(@RequestBody List<Long> workflowIds) {
        return workflowHandler.getWorkflows(workflowIds);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WorkflowResponse> listWorkflows() {
        return workflowHandler.listWorkflows();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkflowResponse createWorkflow(@RequestBody WorkflowRequest workflowRequest) {
        return workflowHandler.createWorkflow(workflowRequest);
    }

    @PutMapping
    public WorkflowResponse updateWorkflow(@RequestBody WorkflowRequest workflowRequest) {
        return workflowHandler.updateWorkflow(workflowRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkflow(@PathVariable("id") long id) {
        workflowHandler.deleteWorkflow(id);
    }
}
