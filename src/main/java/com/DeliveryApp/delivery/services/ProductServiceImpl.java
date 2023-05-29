package com.DeliveryApp.delivery.services;

import com.DeliveryApp.delivery.entities.Product;
import com.DeliveryApp.delivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    //MultipartFile file//
    @Override
    public Product saveProduct(Product product) {


        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Product product) {
productRepository.delete(product);
    }

    @Override
    public void deleteProductById(Long id) {
productRepository.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {
productRepository.deleteAll();
    }

    @Override
    public Page<Product> getAllProductByPage(int page, int size) {
        return productRepository.findAll(PageRequest.of(page,size));
    }
}
