package com.manager.controller;

import com.manager.model.IDocumentModel;
import com.manager.model.DocumentModel;

import java.time.LocalDate;

public class WriterController implements IWriterController {
    private final String authorName;

    public WriterController(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public IDocumentModel createDocument(String caption, String text) {
        return new DocumentModel(caption, LocalDate.now(), authorName, text);
    }

    @Override
    public void refreshDocument(IDocumentModel document, String caption, String text) throws Exception {
        if (document == null) {
            throw new NullPointerException("Document is null");
        }

        Thread thread = new Thread(() -> {
            DocumentModel doc = (DocumentModel) document;
            doc.setCaption(caption);
            doc.setText(text);
        });
        thread.start();
        thread.join();
    }
}
