package com.DeliveryApp.delivery.controllers;

import com.DeliveryApp.delivery.entities.Product;
import com.DeliveryApp.delivery.repositories.ProductRepository;
import com.DeliveryApp.delivery.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;
    //pour lancer le jsp
    @RequestMapping("/createProduct")
    public String createProduct (){

        return "CreateProduct";
    }
  @RequestMapping("/saveProduct")

 public String saveProduct(@Valid Product product, BindingResult bindingResult)  {
        if(bindingResult.hasErrors()) return "CreateProduct";
      Product productController = productService.saveProduct(product);
 return "CreateProduct";
 }
@RequestMapping("/")
    public String productsList(ModelMap modelMap,
                               @RequestParam(name = "page",defaultValue = "0") int page,
                               @RequestParam(name = "size",defaultValue = "5") int size
                               ){
       Page<Product> productsController = productService.getAllProductByPage(page, size);
       modelMap.addAttribute("productsJsp", productsController);
       modelMap.addAttribute("pages", new int[productsController.getTotalPages()]);
       modelMap.addAttribute("currentPage", page);
       return "ProductsList";
}
@RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Long id,ModelMap modelMap, @RequestParam(name = "page",defaultValue = "0") int page,
                                @RequestParam(name = "size",defaultValue = "2") int size){
        productService.deleteProductById(id);
    Page<Product> productsController = productService.getAllProductByPage(page, size);
    modelMap.addAttribute("productsJsp", productsController);
    modelMap.addAttribute("pages", new int[productsController.getTotalPages()]);
    modelMap.addAttribute("currentPage", page);
    return "ProductsList";
}
@RequestMapping("/showProduct")
    public String showProduct(@RequestParam("id") Long id,ModelMap modelMap){
        Product productController = productService.getProduct(id);
        modelMap.addAttribute("productJsp", productController);
        return "EditProduct";
}


    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product")Product product){
   productService.saveProduct(product);
        return "CreateProduct";
    }


    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    @GetMapping("/uploadimage") public String displayUploadForm() {
        return "imageupload/index";
    }

    @PostMapping("/upload") public String uploadImage(Model model, @RequestParam("image") MultipartFile file) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
        return "imageupload/index";
    }

}


