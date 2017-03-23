package rudolfoborges.rbpay.product.converter;

import rudolfoborges.rbpay.messages.ProductProtocolBuffer.ProductMessage;
import rudolfoborges.rbpay.product.model.Product;

/**
 * Created by rudolfoborges on 22/03/17.
 */
public class ProductToProductMessageConverter {

    public static ProductMessage convert(Product product) {
        return ProductMessage
                .newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setImageUrl(product.getImageUrl())
                .setPrice(product.getPrice().doubleValue())
                .build();
    }


}
