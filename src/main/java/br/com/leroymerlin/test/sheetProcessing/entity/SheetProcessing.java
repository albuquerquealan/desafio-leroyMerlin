package br.com.leroymerlin.test.sheetProcessing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class SheetProcessing {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Boolean processed;

    private LocalDateTime processingDate;

    public SheetProcessing() {
        //to serilize
    }

    public SheetProcessing(Boolean processed, LocalDateTime processingDate) {
        this.processed = processed;
        this.processingDate = processingDate;
    }

    public Long getId() {
        return id;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public LocalDateTime getProcessingDate() {
        return processingDate;
    }
}
