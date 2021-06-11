package com.manager.controller;

import com.manager.model.ICatalogModel;
import com.manager.model.IDocumentModel;

public interface ISecretaryController {
    void addDocument(IDocumentModel document) throws Exception;
    IDocumentModel getDocumentByAuthorName(String authorName) throws Exception;
    IDocumentModel getDocumentByCaption(String caption) throws Exception;
}
