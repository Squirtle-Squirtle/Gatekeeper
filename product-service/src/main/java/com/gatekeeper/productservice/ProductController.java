package com.gatekeeper.productservice;

import com.gatekeeper.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping("/catalog")
    public List<Product> getCatalog(){
        Product product1 = new Product(1,"Apple",200);
        Product product2 = new Product(2,"Banana",300);
        return List.of(product1,product2);
    }
}
