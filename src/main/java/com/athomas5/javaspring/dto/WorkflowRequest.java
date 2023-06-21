package com.athomas5.javaspring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowRequest {
    private Long id;
    private String name;
//    private WorkflowLifecycle lifecycle;
//    private WorkflowOwnership ownership;
    private boolean testWorkflow;
}
