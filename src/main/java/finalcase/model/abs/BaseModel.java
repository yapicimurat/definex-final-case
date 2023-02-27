package finalcase.model.abs;

import java.time.LocalDateTime;

public abstract class BaseEntity{
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    protected LocalDateTime getCreatedAt() {
        return createdAt;
    }

    protected void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    protected LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    protected void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    protected LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    protected void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    protected boolean isDeleted() {
        return isDeleted;
    }

    protected void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
