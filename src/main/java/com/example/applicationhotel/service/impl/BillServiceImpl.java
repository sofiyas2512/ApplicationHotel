package com.example.applicationhotel.service.impl;

import com.example.applicationhotel.model.Bill;
import com.example.applicationhotel.model.Guest;
import com.example.applicationhotel.repository.BillRepository;
import com.example.applicationhotel.service.BillService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillById(Integer billId) {
        return billRepository.findById(billId)
                .orElseThrow(() -> new EntityNotFoundException("Bill not found with id: " + billId));
    }

    @Override
    public Bill createBill(Integer billId) {
        Bill bill1 = new Bill(billId);
        return billRepository.save(bill1);
    }
    @Override
    public Bill updateBill(Integer billId,Float amount, Date date,  String payment_method, String name,  Guest guest) {
        Bill bill = this.billRepository.findById(billId)
                .orElseThrow(() -> new EntityNotFoundException("Bill not found with id: " + billId));
        bill.setBill_id(billId);
        bill.setAmount(amount);
        bill.setPaymentdate(date);
        bill.setPayment_name(name);
        bill.setGuest(guest);
        bill.setPayment_method(payment_method);

        return billRepository.save(bill);
    }
    @Override
    public void deleteBill(Integer billId) {
        billRepository.deleteById(billId);
    }
}
