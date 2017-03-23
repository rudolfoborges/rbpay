package rudolfoborges.rbpay.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rudolfoborges
 * @since 3/21/17 1:00 PM
 */
@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Size(max = 50)
    private String id;

    @NotNull
    @Size(max = 150)
    private String name;

    @NotNull
    private BigDecimal price;

    @NotNull
    private String aboutIt;

    @NotNull
    @Size(max = 150)
    private String imageUrl;

    @NotNull
    private Boolean active;

    @NotNull
    private Date createdAt;

}
