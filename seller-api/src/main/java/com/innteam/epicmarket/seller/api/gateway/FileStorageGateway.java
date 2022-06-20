package com.innteam.epicmarket.seller.api.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "fileStorageGateway",
        url = "${com.epicmarket.file.storage.url}")
public interface FileStorageGateway {
    @PostMapping(path = "${com.epicmarket.file.storage.endpoint}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    MetaInfo uploadFile(@RequestBody MultipartFile file);
}
