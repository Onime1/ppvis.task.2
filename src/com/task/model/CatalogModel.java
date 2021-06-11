package com.manager.model;

import java.util.ArrayList;
import java.util.List;

public class CatalogModel implements ICatalogModel {
    private final String name;
    private final List<IDocumentModel> documentList;
    private final List<ICatalogModel> catalogList;

    public CatalogModel(String name) {
        this.name = name;
        this.documentList = new ArrayList<>();
        this.catalogList = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<IDocumentModel> getDocumentList() {
        return documentList;
    }

    @Override
    public List<ICatalogModel> getCatalogList() {
        return catalogList;
    }
}
