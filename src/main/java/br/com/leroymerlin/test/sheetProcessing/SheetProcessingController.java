package br.com.leroymerlin.test.sheetProcessing;

import br.com.leroymerlin.test.sheetProcessing.entity.SheetProcessing;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/processing")
public class SheetProcessingController {
    @Autowired
    private SheetProcessingService sheetProcessingService;

    @ApiOperation(value = "List all operations to insert product by excel")
    @GetMapping()
    public List<SheetProcessing> listAll(){
        return  sheetProcessingService.listAll();
    }
}
