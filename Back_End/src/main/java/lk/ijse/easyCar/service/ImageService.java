package lk.ijse.easyCar.service;

import lk.ijse.easyCar.dto.ImageDTO;

import java.util.ArrayList;

public interface ImageService {

    void saveImage(ImageDTO dto);

    void deleteImage(String id);

    ArrayList<ImageDTO> getAllImages();

    ImageDTO findImageById(String imageId);
}
