package com.innteam.epicmarket.seller.api.controller;

import com.innteam.epicmarket.seller.api.dto.Lot;
import com.innteam.epicmarket.seller.api.service.LotsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/lot", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SellerApiRest {

    private final LotsService productService;

    @GetMapping
    public Lot getLot(@RequestParam Long id) {
        return productService.getLot(id);
    }

    @PostMapping
    public void createLot(@RequestBody Lot lot) {
        productService.createLot(lot);
    }

    @GetMapping("/all")
    public List<Lot> getLots() {
        return productService.getLots();
    }

}
