package com.athomas5.javaspring.validation;

import com.athomas5.javaspring.LifecycleStatus;
import com.athomas5.javaspring.model.Workflow;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Data
@Component
public class WorkflowValidator {
    public ValidationResult validate(Workflow workflow) {
        ValidationResult result = new ValidationResult();
        validateRequiredFields(workflow, result);

        //if (workflow.getLifecycle() != null
          //      && (workflow.getLifecycle().getStatus() == LifecycleStatus.LIFECYCLE_LIVE
            //    || workflow.getLifecycle().getStatus() == LifecycleStatus.LIFECYCLE_SCHEDULED)) {
            //validateRequiredFieldsForScheduledOrLiveStatus(workflow, result);
            //validateLifecycle(workflow, result);
            // validateAudienceStatus(workflow, result);
        //}

        // validateApprovedPlacementContent(workflow, result);

        return result;
    }

    private void validateRequiredFields(Workflow workflow, ValidationResult result) {
        if (workflow.getName() == null || workflow.getName().isEmpty()) {
            result.add("Name cannot be null or empty.", ValidationResult.ErrorLevel.ERROR);
        }
    }

    private void validateRequiredFieldsForScheduledOrLiveStatus(Workflow workflow, ValidationResult result) {
        //if (workflow.getLifecycle() != null) {
        //    if (workflow.getLifecycle().getEndAt() == null) {
        //        result.add("Lifecycle start cannot be null.", ValidationResult.ErrorLevel.ERROR);
       //     }

        //    if (workflow.getLifecycle().getEndAt() == null) {
        //        result.add("Lifecycle end cannot be null.", ValidationResult.ErrorLevel.ERROR);
        //    }
       // }
    }

    private void validateLifecycle(Workflow workflow, ValidationResult result) {
        //if (workflow.getLifecycle() == null
        //    || workflow.getLifecycle().getEndAt() == null
        //    || workflow.getLifecycle().getStartAt() == null) {
        //    return;
        //}

       // long startAtMs = Instant.parse(workflow.getLifecycle().getStartAt()).toEpochMilli();
        //long endAtMs = Instant.parse(workflow.getLifecycle().getEndAt()).toEpochMilli();

        //if (startAtMs > endAtMs) {
        //    result.add("Lifecycle start at cannot be after end at.", ValidationResult.ErrorLevel.ERROR);
        //}
    }
}
