package com.rental.controllers;

import com.rental.entities.House;
import com.rental.entities.Image;
import com.rental.service.impl.ImageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    private final ImageServiceImpl imageService;

    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Image>> getAllImages(){
        return new ResponseEntity<>(imageService.getAllImages(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id){
        return imageService.getImageById(id)
                .map(image -> new ResponseEntity<>(image, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/")
    public ResponseEntity<Image> createImage(@RequestBody Image image){
        return new ResponseEntity<>(imageService.createImage(image), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Long id, @RequestBody Image image){
        return imageService.updateImage(id, image)
                .map(image1 -> new ResponseEntity<>(image1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImageById(@PathVariable Long id){
        return (imageService.deleteImage(id)) ? ResponseEntity.ok("Image deleted.") : new ResponseEntity<>("Image not found", HttpStatus.NOT_FOUND);
    }
}
