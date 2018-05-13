package com.getItFree.service.impl;

import com.getItFree.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StorageServiceImpl implements StorageService {
    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Value("${images.folder}")
    private Path imagesFolderLocation;

    @Override
    public void store(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.imagesFolderLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL During Store File!");
        }
    }

    @Override
    public Resource loadFile(String filename) {
        try {
            Path file = imagesFolderLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL During load File!");
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(imagesFolderLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(imagesFolderLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}
