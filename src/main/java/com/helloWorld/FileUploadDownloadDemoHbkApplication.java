package com.helloWorld;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class FileUploadDownloadDemoHbkApplication {

  public static void main(String[] args) {
    SpringApplication.run(FileUploadDownloadDemoHbkApplication.class, args);
  }
}
