package com.manager.model;

import java.time.LocalDate;

public interface IDocumentModel {
    String getCaption();
    LocalDate getDate();
    String getAuthorName();
    String getText();
}
