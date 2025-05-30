package cl.duoc.daibarram.ecomarketstoreservice.repository;

import cl.duoc.daibarram.ecomarketstoreservice.repository.entity.InvoiceEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Repository
public class InvoiceRepository {

    List<InvoiceEntity> invoices;

    public InvoiceRepository() {
        invoices = new ArrayList<>();
        invoices.add(new InvoiceEntity(1, 1, LocalDate.now(), 4500.0));
        invoices.add(new InvoiceEntity(2, 2, LocalDate.now(), 1800.0));
    }

    public List<InvoiceEntity> getAll() {
        return invoices;
    }

    public void save(InvoiceEntity invoice) {
        invoice.setId(invoices.size() + 1);
        invoices.add(invoice);
    }

    public void replace(InvoiceEntity found, InvoiceEntity replacement) {
        int index = invoices.indexOf(found);
        replacement.setId(found.getId());
        invoices.set(index, replacement);
    }

    public void delete(InvoiceEntity found) {
        invoices.remove(found);
    }

    public InvoiceEntity getById(int id) {
        for (InvoiceEntity invoice : invoices) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }
}
