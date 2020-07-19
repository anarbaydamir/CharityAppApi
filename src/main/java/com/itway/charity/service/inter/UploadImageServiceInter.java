package com.itway.charity.service.inter;

import com.itway.charity.dto.ImageDirDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadImageServiceInter {
    boolean uploadImage(MultipartFile image,String dir);
    Resource loadImageasResource(String imageName,String dir, Integer id);
    List<ImageDirDto> getImageDirList (String goodsType,String dir,Integer id);
}
