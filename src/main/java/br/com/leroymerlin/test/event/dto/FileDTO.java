package br.com.leroymerlin.test.event.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {
    private MultipartFile file;

    public FileDTO() {
        //to serialize
    }

    public FileDTO(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
