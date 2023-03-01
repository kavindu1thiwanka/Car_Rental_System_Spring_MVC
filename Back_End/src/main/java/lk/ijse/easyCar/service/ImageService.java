package lk.ijse.easyCar.service;

import lk.ijse.easyCar.dto.ImageDTO;

import java.util.ArrayList;

public interface ImageService {

    public void saveImage(ImageDTO dto);

    public void deleteImage(String id);

    public ArrayList<ImageDTO> getAllImages();

    public ImageDTO findImageById(String imageId);
}
