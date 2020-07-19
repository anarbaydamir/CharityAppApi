package com.itway.charity.controller;

import com.itway.charity.dto.ResponseDto;
import com.itway.charity.service.inter.UploadImageServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/placedGoods")
public class PlacedGoodsPhotosRestController {

    @Autowired
    UploadImageServiceInter uploadImageServiceInter;

    @PostMapping("/uploadImage")
    public ResponseEntity uploadImage(@RequestParam("image") MultipartFile image,
                                @RequestParam("id") Integer id) throws IOException {
        String dir = dirCreator(id);
        boolean result = uploadImageServiceInter.uploadImage(image,dir);
        if (result)
            return ResponseEntity.ok().body(new ResponseDto("ok",uploadImageServiceInter.getImageDirList("placedGoods",dir,id)));
        else
            return ResponseEntity.badRequest().body(new ResponseDto(404,"error",null));
    }

    @PostMapping("/uploadMultipleImages")
    public List<ResponseEntity> uploadMultipleImages(@RequestParam("images") MultipartFile[] images,
                                                        @RequestParam("id") Integer id) {
        return Arrays.asList(images)
                .stream()
                .map(image -> {
                    try {
                        return uploadImage(image, id);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return ResponseEntity.badRequest().body(new ResponseDto(404, "error", null));
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/getImage/{id}/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable Integer id,
                                   @PathVariable String imageName,
                                   HttpServletRequest request){
        String dir = dirCreator(id);
        Resource resource = uploadImageServiceInter.loadImageasResource(imageName,dir,id);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/getImages/{id}")
    public ResponseEntity getImages(@PathVariable(value = "id") Integer id) throws IOException{
        String dir = dirCreator(id);
        return ResponseEntity.ok().body(new ResponseDto("ok",uploadImageServiceInter.getImageDirList("placedGoods",dir,id)));
    }

    private String dirCreator(Integer id){
        return String.format("/Users/anarbaydamirov/Desktop/ITway/PROD/charity/files/placedgoods/%s",id);
    }
}
