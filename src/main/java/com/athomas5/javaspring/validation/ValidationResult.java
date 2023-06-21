package com.athomas5.javaspring.validation;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationResult {
    public enum ErrorLevel {
        INFO(0),
        WARN(1),
        ERROR(2);

        private final int severity;

        ErrorLevel(int severity) {
            this.severity = severity;
        }

        public boolean isBlocking() {
            return this.severity > WARN.severity;
        }
    }

    private final List<Error> validationErrors;
    private boolean isValid;

    public ValidationResult() {
        this.validationErrors = new ArrayList<>();
        this.isValid = true;
    }

    public void add(String error, ErrorLevel level) {
        this.validationErrors.add(new Error(error, level));
        this.isValid = this.isValid && !level.isBlocking();
    }

    public boolean isValid() {
        return this.isValid;
    }

    public List<Error> getValidationErrors() {
        return this.validationErrors;
    }

    public List<String> getValidationMessages() {
        return this.validationErrors.stream()
            .map(Error::getDescription)
            .collect(Collectors.toList());
    }

    @Data
    @RequiredArgsConstructor
    public class Error {
        final String description;
        final ErrorLevel level;
    }
}
