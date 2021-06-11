package com.manager.controller;

import com.manager.model.ICatalogModel;
import com.manager.model.IDocumentModel;

public interface IAdministratorController {
    void removeDocument(IDocumentModel document) throws Exception;
    ICatalogModel createCatalog(String catalogName);
    void moveDocument(IDocumentModel document, ICatalogModel sourceCatalog, ICatalogModel targetCatalog) throws Exception;
}
