package rudolfoborges.rbpay.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rudolfoborges.rbpay.messages.MediaType;
import rudolfoborges.rbpay.messages.StockProtocolBuffer.AvailableAmountMessage;
import rudolfoborges.rbpay.messages.StockProtocolBuffer.StockAdjustmentMessage;
import rudolfoborges.rbpay.stock.converter.StockAdjusmentMessageToStockAdjusmentConverter;
import rudolfoborges.rbpay.stock.model.StockAdjustment;
import rudolfoborges.rbpay.stock.service.StockControlService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rudolfoborges
 * @since 3/21/17 7:57 PM
 */
@RestController
@RequestMapping(value = "v1/stock",
        consumes = {MediaType.PROTOBUF},
        produces = {MediaType.PROTOBUF})
public class StockController {

    @Autowired
    private StockControlService stockControlService;

    @GetMapping("/available/{product}")
    public AvailableAmountMessage getAvailableAmount(@PathVariable final String product) {
        final BigDecimal amount = stockControlService.getAvailableAmount(product);

        return AvailableAmountMessage
                .newBuilder()
                .setAmount(amount.doubleValue())
                .build();
    }

    @PutMapping("/adjustment")
    public void adjustment(@RequestBody final List<StockAdjustmentMessage> stockAdjustmentsProtos) {
        final List<StockAdjustment> stockAdjustments = stockAdjustmentsProtos
                .parallelStream()
                .map(StockAdjusmentMessageToStockAdjusmentConverter::convert)
                .collect(Collectors.toList());

        stockControlService.adjust(stockAdjustments);
    }

}
