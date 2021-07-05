package pe.edu.upc.productservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upc.productservice.entity.Product;
import pe.edu.upc.productservice.repository.ProductRepository;
import pe.edu.upc.productservice.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> listAllProduct(){ return productRepository.findAll(); }
    @Override
    public List<Product> listLowStockProducts(int minStock){ return productRepository.findByStockIsLessThanEqual(minStock); }
    @Override
    public Product getProduct(Long id){ return productRepository.findById(id).orElse(null); }
    public Product createProduct(Product product){ return productRepository.save(product); }
    public Product updateProduct(Product product){
        Product productDB = getProduct(product.getId());
        if(productDB==null){
            return null;
        }
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setStock(product.getStock());
        productDB.setPrice(product.getPrice());
        return productRepository.save(productDB);
    }
    public Product updateStock(Long id, Double quantity){
        Product productDB = getProduct(id);
        if(productDB==null){
            return null;
        }
        productDB.setStock(quantity);
        return productRepository.save(productDB);
    }
}
