package br.com.leroymerlin.test.event;

import br.com.leroymerlin.test.event.dto.FileDTO;
import br.com.leroymerlin.test.product.ProductService;
import br.com.leroymerlin.test.product.entity.Product;
import br.com.leroymerlin.test.util.UtilProduct;
import br.com.leroymerlin.test.util.exception.ConverterException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelProcessingListener {


    private final ProductService productService;

    private Double category;

    public ExcelProcessingListener(ProductService productService) {
        this.productService = productService;
    }

    @EventListener
    public void lister(FileDTO dto) throws IOException {
        Path temp = saveTempFile(dto);
        List<Product> products = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(temp.toFile())) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheetAt = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheetAt.iterator();
            rowIterator.forEachRemaining(row -> {
                if (validateIfItIsTheCategoryInitialLine(row)) {
                    category = row.getCell(1).getNumericCellValue();
                } else if (validateIfItIsAProductLine(row)) {
                    Product product = createProductByLine(row);
                    products.add(product);
                }
            });
            productService.saveAll(products);

        }
    }

    private boolean validateIfItIsAProductLine(Row row) {
        return row.getRowNum() > 2;
    }

    private boolean validateIfItIsTheCategoryInitialLine(Row row) {
        return row.getRowNum() == 0;
    }


    private Product createProductByLine(Row row) {
        Product product = new Product();
        try {
            product = Product.builder()
                    .withLm(row.getCell(0).getNumericCellValue())
                    .withName(row.getCell(1).getStringCellValue())
                    .withFreeShipping(UtilProduct.convertNumberToBoolean(row.getCell(2).getNumericCellValue()))
                    .withDescription(row.getCell(3).getStringCellValue())
                    .withPrice(new BigDecimal(row.getCell(4).getStringCellValue()))
                    .withCategory(category)
                    .build();
        } catch (ConverterException e) {
            e.printStackTrace();
        }
        return product;
    }

    private Path saveTempFile(FileDTO file) throws IOException {
        Path temp = Files.createTempFile("info", ".xlsx");
        var is = file.getFile().getInputStream();
        Files.copy(is, temp, StandardCopyOption.REPLACE_EXISTING);
        return temp;
    }


}
