package com.helloWorld.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "image_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {

  @Id
  @Column(name = "id", updatable = false, nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  @Lob
  @Column(name = "image_data", length = 1024)
  private byte[] imageData;
}
