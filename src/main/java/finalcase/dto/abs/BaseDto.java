package finalcase.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseDto {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
