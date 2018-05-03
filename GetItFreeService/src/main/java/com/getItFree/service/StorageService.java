package com.getItFree.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    /**
     * Method for saving file.
     * @param file
     */
    void store(MultipartFile file);

    /**
     * Method for load file.
     * @param filename
     * @return
     */
    Resource loadFile(String filename);

    /**
     * Method for deleting all uploaded files.
     */
    void deleteAll();

    /**
     * Method for creating upload directory on disk.
     */
    void init();
}
