package com.productmanagementsystem.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name="product")
public class Product {

    @Id
    private String productId;

    private String productName;

    private LocalDate manufacturingDate;

    private String expiringDetails;

}
