package com.mimie.ecommerceBackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity //make it table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

   // @JsonFormat(shape  = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date releaseDate;
    private boolean available;
    private Integer quantity;

    private String imageName;
    private String imageType;
    @Lob
    private byte[]imageDate;

}
