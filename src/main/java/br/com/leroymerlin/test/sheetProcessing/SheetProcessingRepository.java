package br.com.leroymerlin.test.sheetProcessing;

import br.com.leroymerlin.test.sheetProcessing.entity.SheetProcessing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SheetProcessingRepository extends CrudRepository<SheetProcessing, Long> {
}
