package com.manager.model;

import java.util.List;

public interface ICatalogModel {
    String getName();
    List<IDocumentModel> getDocumentList();
    List<ICatalogModel> getCatalogList();
}
