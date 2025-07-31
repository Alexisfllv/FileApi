package sora.com.fileapi.dto.document;

public record DocumentRequestDTO(
        String title,
        String description,
        String content
) {}