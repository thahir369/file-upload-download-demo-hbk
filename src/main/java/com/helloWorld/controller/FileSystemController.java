package com.helloWorld.controller;

import com.helloWorld.service.FileSystemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Validated
@RestController
@RequiredArgsConstructor
public class FileSystemController {

  private final FileSystemService fileSystemService;

  @GetMapping("/home")
  public String homepage() {
    return "Hai! welcome to our website. Here you can upload and download files from h2 database";
  }

  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file)
      throws IOException {
    String uploadImage = fileSystemService.uploadFile(file);
    return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
  }

  @GetMapping("/download/{fileName}")
  public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
    byte[] imageData = fileSystemService.downloadFile(fileName);
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.valueOf("image/png"))
        .body(imageData);
  }
}
