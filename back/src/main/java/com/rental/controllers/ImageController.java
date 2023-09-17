package com.rental.controllers;

import com.rental.entities.Image;
import com.rental.service.impl.ImageServiceImpl;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/img/{id}")
    public ResponseEntity<MultiValueMap<String, Object>> getImageByIdd(@PathVariable Long id) throws IOException {
        // Lógica para obtener la imagen y otras propiedades
        Optional<Image> imagee = imageService.getImageById(id);

        if (imagee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Image image = null;
        if (imagee.isPresent()) {
            image = imagee.get();
        }

        // Cargar la imagen desde el sistema de archivos
        Path imagePath = Paths.get(image.getFilepath());
        Resource resource = new FileSystemResource(imagePath.toFile());

        if (!resource.exists()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Preparar la respuesta
        MultiValueMap<String, Object> response = new LinkedMultiValueMap<>();
        response.add("filename", image.getFilename());
        response.add("filepath", image.getFilepath());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Cambiar según el tipo de imagen
        headers.setContentDispositionFormData("attachment", image.getFilename());
        headers.setContentLength(resource.contentLength());

        response.add("image", new HttpEntity<>(resource, headers));

        return new ResponseEntity<>(response, HttpStatus.OK);
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
