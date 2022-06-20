package com.innteam.epicmarket.seller.api.repository;

import com.innteam.epicmarket.seller.api.dto.Lot;

public interface QueueManager {
    void send(Lot lot) throws Exception;
}
