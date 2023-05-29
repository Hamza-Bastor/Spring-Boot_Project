package com.DeliveryApp.delivery.services;


import com.DeliveryApp.delivery.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
@Autowired
   Product saveProduct(Product product);

Product updateProduct(Product product);
Product getProduct(Long id);
List<Product> getAllProducts();
void deleteProduct(Product product);
void deleteProductById(Long id);
void deleteAllProducts();
Page<Product> getAllProductByPage(int page,int size);
}
