package rudolfoborges.rbpay.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rudolfoborges.rbpay.stock.model.StockAdjustment;
import rudolfoborges.rbpay.stock.service.StockControlService;

import java.math.BigDecimal;

/**
 * @author rudolfoborges
 * @since 3/21/17 7:57 PM
 */
@RestController
@RequestMapping(value = "v1/stock",
        consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class StockController {

    @Autowired
    private StockControlService stockControlService;

    @GetMapping("/amount/{product}")
    public void getAmount(@PathVariable final String product){
        final BigDecimal amount = stockControlService.getAmount(product);
    }

    public void adjustment(){

    }

}
