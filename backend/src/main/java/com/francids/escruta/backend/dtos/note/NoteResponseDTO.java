package com.francids.escruta.backend.dtos.note;

import com.francids.escruta.backend.entities.Note;

import java.sql.Timestamp;
import java.util.UUID;

public record NoteResponseDTO(
        UUID id,
        UUID notebookId,
        UUID sourceId,
        String icon,
        String title,
        Timestamp createdAt,
        Timestamp updatedAt
) {
    public NoteResponseDTO(Note note) {
        this(
                note.getId(),
                note.getNotebook().getId(),
                note.getSource() != null ? note.getSource().getId() : null,
                note.getIcon(),
                note.getTitle(),
                note.getCreatedAt(),
                note.getUpdatedAt()
        );
    }
}
