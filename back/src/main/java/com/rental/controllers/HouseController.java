package com.rental.controllers;

import com.rental.entities.House;
import com.rental.entities.Image;
import com.rental.security.rest.SecurityRest;
import com.rental.service.impl.HouseServiceImpl;
import com.rental.service.impl.ImageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/api/v1/houses")
public class HouseController {

    private final HouseServiceImpl houseService;
    private final ImageServiceImpl imageService;
    private static final Logger logger = LoggerFactory.getLogger(SecurityRest.class);



    public HouseController(HouseServiceImpl houseService, ImageServiceImpl imageService) {
        this.houseService = houseService;
        this.imageService = imageService;
    }

    @GetMapping("/")
    public ResponseEntity<List<House>> getAllHouses() throws IOException {

        return new ResponseEntity<>(houseService.getAllHouses(), HttpStatus.OK);
    }

    @GetMapping("/wImg/")
    public MultiValueMap<String, Object> getImageByIdd(House house) throws IOException {
        // Lógica para obtener la imagen y otras propiedades
        Optional<Image> imagee = imageService.getImageById(house.getImage().getId());

        if (imagee == null) {
            return null;
        }

        Image image = null;
        if (imagee.isPresent()) {
            image = imagee.get();
        }

        // Cargar la imagen desde el sistema de archivos
        Path imagePath = Paths.get(image.getFilepath());
        Resource resource = new FileSystemResource(imagePath.toFile());

        if (!resource.exists()) {
            return null;
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

        logger.info("img para response: " + response);

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<House> getHouseById(@PathVariable Long id){
        return houseService.getHouseById(id)
                .map(house -> new ResponseEntity<>(house, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/")
    public ResponseEntity<House> createHouse(@RequestBody House house){
        return new ResponseEntity<>(houseService.createHouse(house), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<House> updateHouse(@PathVariable Long id, @RequestBody House house){
        return houseService.updateHouse(id, house)
                .map(house1 -> new ResponseEntity<>(house1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHouseById(@PathVariable Long id){
        return (houseService.deleteHouse(id)) ? ResponseEntity.ok("House deleted.") : new ResponseEntity<>("House not found", HttpStatus.NOT_FOUND);
    }


}
