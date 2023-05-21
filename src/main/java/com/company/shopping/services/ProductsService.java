package com.company.shopping.services;

import com.company.shopping.entity.Products;
import com.company.shopping.repository.ProductsRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public String createProduct(String input) throws Exception {
        JsonObject jsonObject = new Gson().fromJson(input, JsonObject.class);
        String name = jsonObject.get("name").getAsString();
        String type = jsonObject.get("class").getAsString();
        String description = jsonObject.get("description").getAsString();
        int quantity = jsonObject.get("quantity").getAsInt();
        double price = jsonObject.get("price").getAsDouble();

        try{
            Optional<Products> productsPresent = productsRepository.getProductByName(name);
            String message = "";

            if(productsPresent.isEmpty())
            {
                Products products = new Products();
                products.setName(name);
                products.setType(type);
                products.setDescription(description);
                products.setQuantity(quantity);
                products.setPrice(price);

                productsRepository.save(products);
                message = "Product created successfully";
                return message;
            }
            else{
                throw new Exception(String.format("Product: %s already exists",name));
            }
        }
        catch(Exception e){
            throw e;
        }
    }
}
