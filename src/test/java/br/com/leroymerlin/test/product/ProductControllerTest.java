package br.com.leroymerlin.test.product;

import br.com.leroymerlin.test.JsonUtil;
import br.com.leroymerlin.test.product.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @MockBean
    private ProductService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getProducts() throws Exception {
        Product product = CreateProductEnvironment.correctForm();
        when(service.listAllProducts())
                .thenReturn(List.of(product));
        mockMvc.perform(get("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getProductsByLm() throws Exception {
        Product product = CreateProductEnvironment.correctForm();
        when(service.findProductByLm(anyDouble()))
                .thenReturn(List.of(product));
        mockMvc.perform(get("/products/" + 123)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteProduct() throws Exception {
        doNothing().when(service).deleteProduct(anyDouble());
        mockMvc.perform(delete("/products/" + 123)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateProduct() throws Exception {
        Product productUpdated = CreateProductEnvironment.updatedForm();

        when(service.editProduct(anyDouble(), any())).thenReturn(productUpdated);

        mockMvc.perform(put("/products/" + 123)
                .contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(productUpdated)))
                .andDo(print())
                .andExpect(status().isOk());

    }
}