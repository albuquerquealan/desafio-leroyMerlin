package br.com.leroymerlin.test.sheetProcessing;

import br.com.leroymerlin.test.sheetProcessing.entity.SheetProcessing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SheetProcessingService {

    SheetProcessing save(SheetProcessing sheetProcessing);

    List<SheetProcessing> listAll();

}
