package com.rental.controllers;

import com.rental.entities.Image;
import com.rental.service.impl.ImageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/image")
public class ImageController {

    private final ImageServiceImpl imageService;

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);


    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/subir")
    public Long subirImage(@RequestParam("archivo") MultipartFile archivo) throws IOException {
        Image imagen = new Image();
        imagen.setName(archivo.getOriginalFilename());
        imagen.setImgdata(archivo.getBytes());
        Image newImage = imageService.createImage(imagen);
        logger.info("new image: " + newImage.getId());
        return newImage.getId();
    }

    @PostMapping("/many")
    public ResponseEntity<String> uploadAllImages(@RequestParam("archivo") List<MultipartFile> archivos) throws IOException {
        archivos.forEach(archivo -> {
            Image imagen = new Image();
            imagen.setName(archivo.getOriginalFilename());
            try {
                imagen.setImgdata(archivo.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            imageService.createImage(imagen);
        });
        return new ResponseEntity<>("Imagenes cargadas correctamente!", HttpStatus.CREATED);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<byte[]> obtenerImage(@PathVariable Long id) {
        Optional<Image> imagenOptional = imageService.getImageById(id);
        if (imagenOptional.isPresent()) {
            Image imagen = imagenOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Ajusta el tipo de contenido según tu imagen
            return new ResponseEntity<>(imagen.getImgdata(), headers, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/imgdata")
    public ResponseEntity<List<byte[]>> obtenerImage() {
        List<Image> imagesList = imageService.getAllImages();

//        logger.info("img para response: " + imagesList);

        List<byte[]> data = new ArrayList<>();

        imagesList.forEach(item -> {
            data.add(item.getImgdata());
        });

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        return new ResponseEntity<>(imageService.getAllImages(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Long id) {
        if (imageService.deleteImage(id)) {
            return new ResponseEntity<>("Deleted successfully.", HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.notFound().build();
    }


}
