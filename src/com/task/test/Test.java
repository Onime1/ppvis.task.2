package com.company.test;

import com.manager.controller.IAdministratorController;
import com.manager.controller.AdministratorController;
import com.manager.model.ICatalogModel;
import com.manager.controller.ISecretaryController;
import com.manager.controller.IWriterController;
import com.manager.model.CatalogModel;
import com.manager.controller.SecretaryController;
import com.manager.controller.WriterController;
import com.manager.model.IDocumentModel;

public class Test {
    private ICatalogModel catalog;
    private IWriterController writerController;
    private ISecretaryController secretaryController;
    private IAdministratorController administratorController;

    public void start() {
        catalog = new CatalogModel("Catalog1");
        writerController = new WriterController("Author");

        try {
            secretaryController = new SecretaryController(catalog);
            administratorController = new AdministratorController(catalog);

            generateTenDocuments();
            moveDocument();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void generateTenDocuments() {
        for (int it = 0; it < 10; it++) {
            try {
                secretaryController.addDocument(writerController.createDocument(it + "", "text" + it));
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }

        try {
            secretaryController.addDocument(writerController.createDocument(1 + "", "text" + 1));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("After add:");
        catalog.getDocumentList().forEach(System.out::println);
    }

    private void moveDocument() {
        IDocumentModel document = null;
        try {
            document = secretaryController.getDocumentByCaption("1");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        ICatalogModel catalog = new CatalogModel("Catalog2");
        try {
            administratorController.moveDocument(document, this.catalog, catalog);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("After moving:");
        this.catalog.getDocumentList().forEach(System.out::println);
    }
}
