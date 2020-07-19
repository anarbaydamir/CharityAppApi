package com.itway.charity.service.impl;

import com.itway.charity.customexception.MyFileNotFoundException;
import com.itway.charity.dto.ImageDirDto;
import com.itway.charity.service.inter.UploadImageServiceInter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadImageServiceImpl implements UploadImageServiceInter {
    @Override
    public boolean uploadImage(MultipartFile image,String dir) {
        try{
            Path folderPath = Paths.get(dir)
                    .toAbsolutePath().normalize();
            if (!Files.exists(folderPath))
                Files.createDirectories(folderPath);

            String imagePath = String.format(dir + "/%s", image.getOriginalFilename());
            File convertImage = new File(imagePath);
            convertImage.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(convertImage);
            fileOutputStream.write(image.getBytes());
            fileOutputStream.close();
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public Resource loadImageasResource(String imageName, String dir ,Integer id) {
        Path folderPath = Paths.get(dir)
                .toAbsolutePath().normalize();
        try {
            Path filePath = folderPath.resolve(imageName).normalize();
            org.springframework.core.io.Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + imageName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + imageName, ex);
        }
    }

    @Override
    public List<ImageDirDto> getImageDirList(String goodsType,String dir, Integer id) {
        List<ImageDirDto> imageDirDtoList = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/" + goodsType + "/")
                            .path("/getImage/")
                            .path(id.toString()+"/")
                            .path(path.getFileName().toString())
                            .toUriString();
                    imageDirDtoList.add(new ImageDirDto(imageUrl));
                }
            }
            return imageDirDtoList;
        }
        catch (Exception ex){
            return null;
        }
    }
}
