package com.innteam.epicmarket.seller.api.service;

import com.innteam.epicmarket.seller.api.dto.Lot;

import java.util.List;

public interface LotsService {
    Lot getLot(Long id);

    List<Lot> getLots();

    void createLot(Lot lot);
}
