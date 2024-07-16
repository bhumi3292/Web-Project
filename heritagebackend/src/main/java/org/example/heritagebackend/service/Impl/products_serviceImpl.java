package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.products;
import org.example.heritagebackend.pojo.Products_pojo;
import org.example.heritagebackend.repository.Products_repo;
import org.example.heritagebackend.service.products_service;
import org.example.heritagebackend.util.ImageToBase64;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class products_serviceImpl implements products_service {

    private final Products_repo products_repo;
    private final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/files";

    @Override
    public List<products> getProducts() {
        ImageToBase64 imageToBase64 = new ImageToBase64();
        List<products> products = products_repo.findAll();

        return products.stream().map(product -> {
            String base64Image = imageToBase64.getImageToBase64(product.getProfile());
            if (base64Image != null) {
                JSONObject json = new JSONObject();
                json.put("image", base64Image);
                saveJsonToFile(json, product.getProfile() + ".json");
            }
            product.setProfile(base64Image);
            return product;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<products> getProductsById(Long id) {
        ImageToBase64 imageToBase64 = new ImageToBase64();
        Optional<products> product = products_repo.findById(id);

        product.ifPresent(value -> {
            String base64Image = imageToBase64.getImageToBase64(value.getProfile());
            if (base64Image != null) {
                JSONObject json = new JSONObject();
                json.put("image", base64Image);
                saveJsonToFile(json, value.getProfile() + ".json");
            }
            value.setProfile(base64Image);
        });

        return product;
    }

    @Override
    public products addProducts(Products_pojo productsPojo) throws IOException {
        products product = new products();
        product.setName(productsPojo.getName());
        product.setDescription(productsPojo.getDescription());
        product.setPrice(productsPojo.getPrice());
        product.setStockQuantity(productsPojo.getStockQuantity());
        product.setProfile(productsPojo.getProfile().getOriginalFilename());
        product.setAvailability(productsPojo.isAvailability());

        // Image upload logic
        if (productsPojo.getProfile() != null && !productsPojo.getProfile().isEmpty()) {
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productsPojo.getProfile().getOriginalFilename());
            Files.write(fileNameAndPath, productsPojo.getProfile().getBytes());
            product.setProfile(productsPojo.getProfile().getOriginalFilename());

            // Convert image to Base64 and save as JSON
            ImageToBase64 imageToBase64 = new ImageToBase64();
            String base64Image = imageToBase64.getImageToBase64(fileNameAndPath.toString());
            if (base64Image != null) {
                JSONObject json = new JSONObject();
                json.put("image", base64Image);
                saveJsonToFile(json, productsPojo.getProfile().getOriginalFilename() + ".json");
            }
        }

        return products_repo.save(product);
    }

    @Override
    public products updateProducts(Products_pojo productsPojo, Long id) throws IOException {
        Optional<products> productsOptional = products_repo.findById(id);

        if (productsOptional.isPresent()) {
            products product = productsOptional.get();
            product.setName(productsPojo.getName());
            product.setDescription(productsPojo.getDescription());
            product.setPrice(productsPojo.getPrice());
            product.setStockQuantity(productsPojo.getStockQuantity());
            product.setAvailability(productsPojo.isAvailability());

            // Image upload logic
            if (productsPojo.getProfile() != null && !productsPojo.getProfile().isEmpty()) {
                Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productsPojo.getProfile().getOriginalFilename());
                Files.write(fileNameAndPath, productsPojo.getProfile().getBytes());
                product.setProfile(productsPojo.getProfile().getOriginalFilename());

                // Convert image to Base64 and save as JSON
                ImageToBase64 imageToBase64 = new ImageToBase64();
                String base64Image = imageToBase64.getImageToBase64(fileNameAndPath.toString());
                if (base64Image != null) {
                    JSONObject json = new JSONObject();
                    json.put("image", base64Image);
                    saveJsonToFile(json, productsPojo.getProfile().getOriginalFilename() + ".json");
                }
            }

            return products_repo.save(product);
        }

        return null;
    }

    @Override
    public void deleteProducts(Long id) {
        products_repo.deleteById(id);
    }

    private void saveJsonToFile(JSONObject json, String filename) {
        try (FileWriter file = new FileWriter(UPLOAD_DIRECTORY + "/" + filename)) {
            file.write(json.toString());
            System.out.println("Successfully saved image as Base64 in JSON format.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
