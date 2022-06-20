package com.innteam.epicmarket.seller.api.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public record Lot(
        @NotBlank String title,
        @NotNull BigDecimal price,
        @NotNull MultipartFile image) {
}
