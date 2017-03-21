package rudolfoborges.rbpay.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rudolfoborges.rbpay.product.entity.ProductEntity;

import java.util.List;

/**
 * @author rudolfoborges
 * @since 3/21/17 1:05 PM
 */
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    @Query("select product from ProductEntity product where active = true order by name")
    List<ProductEntity> findAllForSale();

}
