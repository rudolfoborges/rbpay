package rudolfoborges.rbpay.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rudolfoborges.rbpay.product.model.Product;
import rudolfoborges.rbpay.product.repository.ProductRepository;

import java.util.List;

/**
 * @author rudolfoborges
 * @since 3/21/17 1:07 PM
 */
@RestController
@RequestMapping(value = "v1/products",
        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(method = {RequestMethod.GET})
    public List<Product> getAll() {
        return productRepository.findAllForSale();
    }

    @RequestMapping(path = "{id}", method = {RequestMethod.GET})
    public Product getOne(@PathVariable final String id) {
        return productRepository.findOne(id);
    }

}
