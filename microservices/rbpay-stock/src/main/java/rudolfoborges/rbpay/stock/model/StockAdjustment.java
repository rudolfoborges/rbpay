package rudolfoborges.rbpay.stock.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * Created by rudolfoborges on 22/03/17.
 */
@Builder
@Getter
public class StockAdjustment {

    private String product;

    private BigDecimal amount;

}
