package pe.edu.upc.productservice.productController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.productservice.entity.Product;
import pe.edu.upc.productservice.service.ProductService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService  productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        List<Product>products = new ArrayList<>();
        products = productService.listAllProduct();
        if(products.isEmpty()) {
            products.add(new Product(0,"Bellotas","Bellotas",60.0,2.50));
            products.add(new Product(1,"Galletas","Galletas",120.0,1.00));
            products.add(new Product(2,"Gaseosa","Gaseosa",50.0,3.00));
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.ok(products);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product =  productService.getProduct(id);
        if (null==product){
            product = new Product(5,"Pan","Pan",20.0,6.00);
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.ok(product);
    }
}


