package controller;

import connection.Product;
import connection.ProductDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ProductController {
    private final ProductDao productDao = new ProductDao();

    public ObservableList<Product> loadProducts(){
        List<Product> productList = productDao.getAll();
        ObservableList<Product> products = FXCollections.observableList(productList);
        return products;
    }

    public Product addProduct(Product product) {
        productDao.save(product);
        return product;
    }

    public void deleteSelectedProducts(List<Product> selectedProducts) {

    }
}
