package br.com.leroymerlin.test.sheetProcessing;

import br.com.leroymerlin.test.sheetProcessing.entity.SheetProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class SheetProcessingServiceImpl implements SheetProcessingService {
    @Autowired
    private SheetProcessingRepository repository;

    @Override
    public SheetProcessing save(SheetProcessing sheetProcessing) {
        return repository.save(sheetProcessing);
    }

    public List<SheetProcessing> listAll(){
        return (List<SheetProcessing>) repository.findAll();
    }

}
