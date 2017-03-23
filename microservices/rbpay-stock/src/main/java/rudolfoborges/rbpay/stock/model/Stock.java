package rudolfoborges.rbpay.stock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rudolfoborges
 * @since 3/21/17 7:49 PM
 */
@Entity
@Table(name = "stocks"
        , uniqueConstraints = {@UniqueConstraint(name = "stock_product_uc", columnNames = {"product"})})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 50)
    private String product;

    @NotNull
    private BigDecimal amount;

    private Date updatedAt;

}
