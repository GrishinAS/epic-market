package com.innteam.epicmarket.seller.api.repository;

import com.innteam.epicmarket.seller.api.dto.LotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStorageRepository extends JpaRepository<LotEntity, Long> {
}
