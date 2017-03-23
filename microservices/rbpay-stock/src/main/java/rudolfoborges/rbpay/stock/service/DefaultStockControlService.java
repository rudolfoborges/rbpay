package rudolfoborges.rbpay.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import rudolfoborges.rbpay.stock.model.Stock;
import rudolfoborges.rbpay.stock.model.StockAdjustment;
import rudolfoborges.rbpay.stock.repository.StockRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by rudolfoborges on 21/03/17.
 */
@Service
public class DefaultStockControlService implements StockControlService {

    @Autowired
    private StockRepository stockRepository;

    public BigDecimal getAmount(final String product) {
        return stockRepository.findAmount(product);
    }


    @Transactional
    public void adjustment(List<StockAdjustment> stockAdjustments) {
        stockAdjustments.parallelStream().forEach(stockAdjustment -> {
            this.adjustment(stockAdjustment);
        });
    }

    @Transactional
    public void adjustment(final StockAdjustment stockAdjustment) {
        final  String product = stockAdjustment.getProduct();
        final Stock stock = stockRepository.findByProduct(product);

        Assert.notNull(stock, String.format("The product %s not exists in stock", product));

        final BigDecimal newAmount = calculateNewAmount(stock.getAmount(), stockAdjustment.getAmount());

        Assert.isTrue(amountShouldBePositive(newAmount), "New amount should be positive");

        stock.setAmount(newAmount);
        stock.setUpdatedAt(new Date());

        stockRepository.save(stock);

    }

    private BigDecimal calculateNewAmount(final BigDecimal stockAmount, final BigDecimal saleAmount){
        return stockAmount.add(saleAmount);
    }

    private boolean amountShouldBePositive(final BigDecimal newAmount){
        return newAmount.compareTo(new BigDecimal(0)) > 0;
    }

}
