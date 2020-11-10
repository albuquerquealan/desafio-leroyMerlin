package br.com.leroymerlin.test.product;

import br.com.leroymerlin.test.event.dto.FileDTO;
import br.com.leroymerlin.test.product.entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/products")
@Api(value = "Products")
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @ApiOperation(value = "List all products loaded via excel ")
    @GetMapping()
    public List<Product> getProducts() {
        return service.listAllProducts();
    }

    @ApiOperation(value = "Filter products by id (lm)")
    @GetMapping("/{lm}")
    public List<Product> getProductsByLm(@PathVariable Double lm) {
        return service.findProductByLm(lm);
    }

    @ApiOperation(value = "Delete products by id (lm)")
    @DeleteMapping("/{lm}")
    public void deleteProduct(@PathVariable Double lm) {
        service.deleteProduct(lm);
    }

    @ApiOperation(value = "Update products by id (lm)")
    @PutMapping("/{lm}")
    public Product updateProduct(@PathVariable Double lm, @RequestBody Product product) {
        return service.editProduct(lm, product);
    }

    @ApiOperation(value = "Saves products to the database, needs a file in xlsx or xls format to work.")
    @PostMapping()
    public void saveProduct(@RequestParam("file") MultipartFile file) {
        FileDTO dto = new FileDTO(file);
        applicationEventPublisher.publishEvent(dto);
    }
}
