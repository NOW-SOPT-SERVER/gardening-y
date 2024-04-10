package org.example.domain.common;

import java.time.LocalDateTime;

public abstract class BaseTime {
    private final LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    protected BaseTime() {
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now;
        this.lastModifiedDate = now;
    }

    public void updateLastModifiedDate() {
        this.lastModifiedDate = LocalDateTime.now();
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
