package cl.duoc.daibarram.ecomarketstoreservice.service;

import cl.duoc.daibarram.ecomarketstoreservice.repository.InvoiceRepository;
import cl.duoc.daibarram.ecomarketstoreservice.repository.entity.InvoiceEntity;
import cl.duoc.daibarram.ecomarketstoreservice.service.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getInvoices() {
        List<InvoiceEntity> invoices = invoiceRepository.getAll();
        List<Invoice> invoiceList = new ArrayList<>();
        for (InvoiceEntity invoiceEntity : invoices) {
            invoiceList.add(
                    new Invoice(
                        invoiceEntity.getId(),
                        invoiceEntity.getOrderId(),
                        invoiceEntity.getDate(),
                        invoiceEntity.getAmount()
                    ));
        }
        return invoiceList;
    }

    public Invoice getInvoiceById(int id) {
        List<Invoice> invoices = getInvoices();
        for (Invoice invoice : invoices) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }

    public boolean saveInvoice(Invoice invoice) {
        InvoiceEntity invoiceEntity = invoiceRepository.getById(invoice.getId());
        if (invoiceEntity == null) {
            invoiceRepository.save(
                    new InvoiceEntity(
                        invoice.getId(),
                        invoice.getOrderId(),
                        invoice.getDate(),
                        invoice.getAmount()
                    ));
        }
        return false;
    }

    public boolean replaceInvoice(int id, Invoice newInvoice) {
        InvoiceEntity found = null;
        List<InvoiceEntity> invoices = invoiceRepository.getAll();
        for (InvoiceEntity invoice : invoices) {
            if (invoice.getId() == id) {
                found = invoice;
            }
        }
        if (found != null) {
            invoiceRepository.replace(
                    found,
                    new InvoiceEntity(
                        newInvoice.getId(),
                        newInvoice.getOrderId(),
                        newInvoice.getDate(),
                        newInvoice.getAmount()
                    ));
        }
        return false;
    }

    public boolean deleteInvoice(int id) {
        InvoiceEntity found = null;
        List<InvoiceEntity> invoices = invoiceRepository.getAll();
        for (InvoiceEntity invoice : invoices) {
            if (invoice.getId() == id) {
                found = invoice;
            }
        }
        if (found != null) {
            invoiceRepository.delete(found);
            return true;
        }
        return false;
    }
}
