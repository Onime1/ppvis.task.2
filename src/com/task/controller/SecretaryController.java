package com.manager.controller;

import com.manager.model.IDocumentModel;
import com.manager.model.ICatalogModel;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class SecretaryController implements ISecretaryController {
    private final ICatalogModel catalog;

    public SecretaryController(ICatalogModel catalog) {
        if (catalog == null) {
            throw new NullPointerException("Catalog is null");
        }
        this.catalog = catalog;
    }

    @Override
    public void addDocument(IDocumentModel document) throws Exception {
        if (document == null) {
            throw new NullPointerException("Document is null");
        }
        if (catalog.getDocumentList().contains(document)) {
            throw new Exception("Such document exists in this catalog");
        }

        Thread thread = new Thread(() -> catalog.getDocumentList().add(document));
        thread.start();
        thread.join();
    }

    @Override
    public IDocumentModel getDocumentByAuthorName(String authorName) throws Exception {
        return getDocument((some) -> some.getAuthorName().equals(authorName));
    }

    @Override
    public IDocumentModel getDocumentByCaption(String caption) throws Exception {
        return getDocument((some) -> some.getCaption().equals(caption));
    }

    private IDocumentModel getDocument(Predicate<IDocumentModel> predicate) throws Exception {
        AtomicReference<IDocumentModel> document = new AtomicReference<>();
        Thread thread = new Thread(() -> document.set(catalog.getDocumentList()
                .stream().filter(predicate)
                .findAny().orElseGet(() -> null)));
        thread.start();
        thread.join();

        return document.get();
    }
}
