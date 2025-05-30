package cl.duoc.daibarram.ecomarketstoreservice.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEntity {
    private int id;
    private int orderId;
    private LocalDate date;
    private double amount;
}
