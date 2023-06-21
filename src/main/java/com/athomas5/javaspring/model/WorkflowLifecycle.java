package com.athomas5.javaspring.model;

import com.athomas5.javaspring.LifecycleStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkflowLifecycle {
    private String startAt;

    private String endAt;

    private LifecycleStatus status;
}
