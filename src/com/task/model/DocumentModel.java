package com.manager.model;

import java.time.LocalDate;
import java.util.Objects;

public class DocumentModel implements IDocumentModel {
    private String caption;
    private final LocalDate date;
    private final String authorName;
    private String text;

    public DocumentModel(String caption, LocalDate date, String authorName, String text) {
        this.caption = caption;
        this.date = date;
        this.authorName = authorName;
        this.text = text;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        DocumentModel document = (DocumentModel) object;
        return Objects.equals(caption, document.caption)
                && Objects.equals(date, document.date)
                && Objects.equals(authorName, document.authorName)
                && Objects.equals(text, document.text);
    }

    @Override
    public String toString() {
        return caption + " "
                + date + " "
                + authorName + " "
                + text + " ";
    }
}
