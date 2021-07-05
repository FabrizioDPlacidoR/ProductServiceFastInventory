package pe.edu.upc.productservice.service;


import pe.edu.upc.productservice.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> listAllProduct();
    public List<Product> listLowStockProducts(int minStock);
    public Product getProduct(Long id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product updateStock(Long id, Double quantity);
}
