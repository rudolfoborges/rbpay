package rudolfoborges.rbpay.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rudolfoborges.rbpay.stock.model.Stock;

import java.math.BigDecimal;

/**
 * @author rudolfoborges
 * @since 3/21/17 7:55 PM
 */
public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("select stock.amount from Stock stock where stock.product = :product")
    BigDecimal findAmount(@Param("product") final String product);

    Stock findByProduct(final String product);

}
