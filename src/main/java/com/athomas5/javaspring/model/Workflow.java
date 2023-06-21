package com.athomas5.javaspring.model;

import com.athomas5.javaspring.dto.WorkflowRequest;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Workflow {
    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    // @Column(nullable = false)
    // private WorkflowLifecycle lifecycle;

    // @Column(nullable = false)
    // private WorkflowOwnership ownership;

    @Column(nullable = false)
    private boolean testWorkflow;
}
