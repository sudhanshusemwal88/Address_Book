package com.sudhanshu.AddressBook.controller;

import com.sudhanshu.AddressBook.Service.AddressBookService;
import com.sudhanshu.AddressBook.entity.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;


    @GetMapping("/addressBook")
    public List<AddressBook> getAllCustomers() {

        return addressBookService.getAllCustomers();
    }

    @PostMapping("/addressBook")
    public Long createAddressBook(@RequestBody AddressBook addressBook) {
         addressBookService.save(addressBook);

        return addressBook.getId();
    }

    @GetMapping("/addressBook/id/{id}")
    public AddressBook findCustomerById(@PathVariable("id") Long id) {

        return addressBookService.findCustomerById(id);
    }

   @GetMapping("/addressBook/name")
    public List<AddressBook> findCustomerByName() {

       return addressBookService.findCustomerByName();

    }

    @PutMapping("/addressBook")
    private AddressBook update(@RequestBody AddressBook addressBook)
    {
        addressBookService.saveOrUpdate(addressBook);
        return addressBook;
    }

    @DeleteMapping("/addressBook/id/{id}")
    public void deleteCustomerById(@PathVariable("id") Long id) {

         addressBookService.deleteCustomerById(id);
    }
}
