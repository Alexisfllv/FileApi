package sora.com.fileapi.dto.document;

import java.time.LocalDateTime;

public record DocumentResponseDTO(
        Long documentId,
        String title,
        String description,
        String content,
        LocalDateTime createdAt
) {}