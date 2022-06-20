package com.innteam.epicmarket.seller.api.service;

import com.innteam.epicmarket.seller.api.dto.Lot;
import com.innteam.epicmarket.seller.api.dto.LotEntity;
import com.innteam.epicmarket.seller.api.gateway.FileStorageGateway;
import com.innteam.epicmarket.seller.api.repository.FileStorageRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LotsServiceImpl implements LotsService {

    private final FileStorageRepository fileStorageRepository;
    private final FileStorageGateway fileStorageGateway;

    @Override
    public Lot getLot(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public List<Lot> getLots() {
        throw new NotImplementedException();
    }

    @Override
    public void createLot(Lot lot) {
        try {
            MetaInfo metaInfo = fileStorageGateway.uploadFile(lot.image());
            LotEntity entity = new LotEntity();
            fileStorageRepository.save(entity)
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
