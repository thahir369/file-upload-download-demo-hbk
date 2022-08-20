package com.helloWorld.service;

import com.helloWorld.entity.ImageData;
import com.helloWorld.repository.FileSystemRepository;
import com.helloWorld.util.FileSystemUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileSystemService {

  private final FileSystemRepository fileSystemRepository;

  public String uploadFile(MultipartFile file) throws IOException {
    ImageData imageData =
        fileSystemRepository.save(
            ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(FileSystemUtils.compressImage(file.getBytes()))
                .build());
    if (imageData != null) {
      return "image uploaded successfully " + file.getOriginalFilename();
    }
    return null;
  }

  public byte[] downloadFile(String fileName) {
    Optional<ImageData> dbImageData = fileSystemRepository.findByName(fileName);
    byte[] images = FileSystemUtils.decompressImage(dbImageData.get().getImageData());
    return images;
  }
}
