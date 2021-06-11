package com.manager.controller;

import com.manager.model.CatalogModel;
import com.manager.model.ICatalogModel;
import com.manager.model.IDocumentModel;


public class AdministratorController implements IAdministratorController {
    private final ICatalogModel catalog;

    public AdministratorController(ICatalogModel catalog) {
        this.catalog = catalog;
    }

    @Override
    public void removeDocument(IDocumentModel document) throws Exception {
        if (document == null) {
            throw new NullPointerException("Document is null");
        }

        Thread thread = new Thread(() -> catalog.getDocumentList().remove(document));
        thread.start();
        thread.join();
    }

    @Override
    public ICatalogModel createCatalog(String catalogName) {
        if (catalogName == null || catalogName.isEmpty()) {
            throw new NullPointerException("Incorrect catalog name");
        }

        return new CatalogModel(catalogName);
    }

    @Override
    public void moveDocument(IDocumentModel document, ICatalogModel sourceCatalog,
                             ICatalogModel targetCatalog) throws Exception {
        if (sourceCatalog == null || targetCatalog == null) {
            throw new NullPointerException("Incorrect move path");
        }
        if (targetCatalog.getDocumentList().contains(document)) {
            throw new Exception("Such document exists in this catalog");
        }

        Thread thread = new Thread(() -> sourceCatalog.getDocumentList().remove(document));
        thread.start();
        thread.join();
        thread = new Thread(() -> targetCatalog.getDocumentList().add(document));
        thread.start();
        thread.join();
    }
}
