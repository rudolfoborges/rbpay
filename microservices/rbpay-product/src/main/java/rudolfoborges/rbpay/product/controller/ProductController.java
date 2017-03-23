package rudolfoborges.rbpay.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rudolfoborges.rbpay.messages.MediaType;
import rudolfoborges.rbpay.messages.ProductProtos;
import rudolfoborges.rbpay.product.converter.ProductModelToProductProtoConverter;
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
    public List<ProductProtos.Product> getAll() {
        final List<Product> products = productRepository.findAllForSale();

        final List<ProductProtos.Product> productsProto = products
                .parallelStream()
                .map(ProductModelToProductProtoConverter::convert)
                .collect(Collectors.toList());

        return productsProto;
    }

    @GetMapping("{id}")
    public ProductProtos.Product getOne(@PathVariable final String id) {
        final Product product = productRepository.findOne(id);
        return ProductModelToProductProtoConverter.convert(product);
    }

}
