package rudolfoborges.rbpay.stock.converter;

import rudolfoborges.rbpay.messages.StockProtos;
import rudolfoborges.rbpay.stock.model.StockAdjustment;

import java.math.BigDecimal;

/**
 * Created by rudolfoborges on 23/03/17.
 */
public interface StockAdjusmentProtoToStockAdjusmentModelConverter {

    default StockAdjustment convert(final StockProtos.StockAdjustment proto) {
        return StockAdjustment
                .builder()
                .amount(new BigDecimal(proto.getAmount()))
                .product(proto.getProduct()).build();
    }

}
