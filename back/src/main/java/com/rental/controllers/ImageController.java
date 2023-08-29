package com.rental.controllers;

import com.rental.entities.Image;
import com.rental.service.impl.ImageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
