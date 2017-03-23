package rudolfoborges.rbpay.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rudolfoborges.rbpay.messages.MediaType;
import rudolfoborges.rbpay.messages.ProductProtocolBuffer.ProductMessage;
import rudolfoborges.rbpay.product.converter.ProductToProductMessageConverter;
import rudolfoborges.rbpay.product.model.Product;
import rudolfoborges.rbpay.product.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rudolfoborges
 * @since 3/21/17 1:07 PM
 */
@RestController
@RequestMapping(value = "v1/products",
        produces = {MediaType.PROTOBUF})
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductMessage> getAll() {
        final List<Product> products = productRepository.findAllForSale();
        return products
                .parallelStream()
                .map(ProductToProductMessageConverter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ProductMessage getOne(@PathVariable final String id) {
        final Product product = productRepository.findOne(id);
        return ProductToProductMessageConverter.convert(product);
    }

}
