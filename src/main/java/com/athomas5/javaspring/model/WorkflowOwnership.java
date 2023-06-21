package com.athomas5.javaspring.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WorkflowOwnership {
    private long ownerId;
    private List<Long> editorIds;
}
