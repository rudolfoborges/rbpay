package rudolfoborges.rbpay.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rudolfoborges.rbpay.stock.model.Stock;

/**
 * @author rudolfoborges
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/21/17 7:55 PM
 */
public interface StockRepository extends JpaRepository<Stock, Long> {
}
