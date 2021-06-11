package com.manager.controller;

import com.manager.model.IDocumentModel;

public interface IWriterController {
    IDocumentModel createDocument(String caption, String text);
    void refreshDocument(IDocumentModel document, String caption, String text) throws Exception;
}
