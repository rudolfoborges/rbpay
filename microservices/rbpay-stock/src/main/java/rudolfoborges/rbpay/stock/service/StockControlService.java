package rudolfoborges.rbpay.stock.service;

import org.springframework.stereotype.Service;
import rudolfoborges.rbpay.stock.model.StockAdjustment;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by rudolfoborges on 21/03/17.
 */
public interface StockControlService {

    BigDecimal getAmount(final String product);

    void adjustment(final List<StockAdjustment> stockAdjustments);

    void adjustment(final StockAdjustment stockAdjustment);

}
