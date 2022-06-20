package com.innteam.epicmarket.seller.api.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
public class LotEntity {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String title;
    @NotNull
    private BigDecimal price;
    @NotNull
    private String image;
}
