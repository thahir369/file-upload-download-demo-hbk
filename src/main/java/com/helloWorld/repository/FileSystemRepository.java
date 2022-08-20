package com.helloWorld.repository;

import com.helloWorld.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileSystemRepository extends JpaRepository<ImageData, Integer> {


  Optional<ImageData> findByName(String name);

}
