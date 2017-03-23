package rudolfoborges.rbpay.product.converter;

import rudolfoborges.rbpay.messages.ProductProtos;
import rudolfoborges.rbpay.product.model.Product;

/**
 * Created by rudolfoborges on 22/03/17.
 */
public interface ProductModelToProductProtoConverter {

    default ProductProtos.Product convert(Product product) {
        return ProductProtos.Product
                .newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setImageUrl(product.getImageUrl())
                .setPrice(product.getPrice().doubleValue())
                .build();
    }


}
