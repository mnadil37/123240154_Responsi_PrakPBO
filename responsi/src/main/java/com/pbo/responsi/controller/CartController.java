/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.responsi.controller;

import com.pbo.responsi.model.CartItem;
import com.pbo.responsi.service.CartDiscount;
import com.pbo.responsi.view.CartView;

/**
 *
 * @author Lab Informatika
 */
public class CartController {
    private final CartView view;
    private final CartDiscount discount;
    
    public CartController(
            CartView view,
            CartDiscount discount) {
        
        this.view = view;
        this.discount = discount;
        init();
    }
    
    private void init() {
        refreshTable();
        view.onAdd(e -> addCart());
        view.onUpdate(e -> updateCart());
        view.onDelete(e -> deleteCart());
        view.onTableSelect(e -> selectCart());
    }
    
    private void refreshTable() {
        view.showCarts(
        discount.getAllCarts()
        );
    }
    
    private void addCart() {
        String name = 
                view.getNameInput();
        String price = 
                view.getPriceInput();
        String qty =
                view.getQtyInput();
        if(name.isEmpty()) {
            view.showMessage(
            "nama tidak boleh kosong"
            );
            return;
        }
        if(price.isEmpty()) {
            view.showMessage(
            "harga tidak boleh kosong"
            );
            return;
        }
        if(qty.isEmpty()) {
            view.showMessage(
            "Kuantitas tidak boleh kosong"
            );
            return;
        }
        
        discount.addCart(
            new InsertCartItemDTO(
                name,
                price,
                qty
            )
        );
        refreshTable();
        view.clearForm();                
    }
    
    private void updateCart() {
        view.getSelectedRowItemName();
        
        if (selectedId == -1) {
            view.showMessage(
            "Pilih data terlebih dahulu");
            return;
        }
        CartItem item = new ChartItem(
            selectedId,
        view.getNameInput(),
        view.getPriceInput(),
        view.getQtyInput()
        );
        discount.updateCart(item);
        
        refreshTable();
        view.clearForm();                
    }
    
    private void deleteCart() {
        int selectedId =
                view.getSelectedRowItemName();
        if ()
    }
}
