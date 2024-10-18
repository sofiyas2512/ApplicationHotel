package com.example.applicationhotel.service;

import com.example.applicationhotel.model.Bill;
import com.example.applicationhotel.model.Guest;

import java.util.Date;
import java.util.List;

public interface BillService {
    List<Bill> getAllBills();

    Bill getBillById(Integer billId);

    Bill createBill(Integer billId);

    Bill updateBill(Integer billId, Float amount, Date date, String payment_method, String name, Guest guest);

    void deleteBill(Integer billId);
}
