package com.rental.service.impl;

import com.rental.entities.Image;
import com.rental.repository.IImageRepository;
import com.rental.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements IImageService {

    @Autowired
    private IImageRepository imageRepository;

    @Override
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public Optional<Image> getImageByImagename(String image) {
        return Optional.empty();
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> updateImage(Long id, Image image) {
        if(imageRepository.existsById(id)){
            image.setId(id);
            return Optional.of(imageRepository.save(image));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteImage(Long id) {
        if(imageRepository.existsById(id)){
            imageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
