package rudolfoborges.rbpay.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rudolfoborges.rbpay.product.model.Product;

import java.util.List;

/**
 * @author rudolfoborges
 * @since 3/21/17 1:05 PM
 */
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("select stock from Product stock where active = true order by name")
    List<Product> findAllForSale();

}
