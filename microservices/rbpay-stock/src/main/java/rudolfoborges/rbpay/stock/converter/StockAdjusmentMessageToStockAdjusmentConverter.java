package rudolfoborges.rbpay.stock.converter;

import rudolfoborges.rbpay.messages.StockProtocolBuffer.StockAdjustmentMessage;
import rudolfoborges.rbpay.stock.model.StockAdjustment;

import java.math.BigDecimal;

/**
 * Created by rudolfoborges on 23/03/17.
 */
public class StockAdjusmentMessageToStockAdjusmentConverter {

    public static StockAdjustment convert(final StockAdjustmentMessage message) {
        return StockAdjustment
                .builder()
                .amount(new BigDecimal(message.getAmount()))
                .product(message.getProduct()).build();
    }

}
