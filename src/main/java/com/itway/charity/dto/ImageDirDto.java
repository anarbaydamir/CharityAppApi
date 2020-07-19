package com.itway.charity.dto;

public class ImageDirDto {
    private String imagePath;

    public ImageDirDto() {
    }

    public ImageDirDto(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
