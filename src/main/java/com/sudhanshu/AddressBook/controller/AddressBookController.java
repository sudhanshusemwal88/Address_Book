package com.sudhanshu.AddressBook.controller;

import com.sudhanshu.AddressBook.service.AddressBookService;
import com.sudhanshu.AddressBook.service.NamesService;
import com.sudhanshu.AddressBook.entity.AddressBook;
import com.sudhanshu.AddressBook.entity.Names;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @Autowired
    private NamesService namesService;


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
    public AddressBook update(@RequestBody AddressBook addressBook)
    {
        addressBookService.saveOrUpdate(addressBook);
        return addressBook;
    }

    @DeleteMapping("/addressBook/id/{id}")
    public void deleteCustomerById(@PathVariable("id") Long id) {

         addressBookService.deleteCustomerById(id);
    }

    @PatchMapping("/addressBook")
    public void updateResource( @RequestBody AddressBook addressBook)
    {
        addressBookService.updateResource(addressBook);

    }

    @GetMapping("/addressBook/addresstype/name")
    public List<Names> findAddressByName() {

        return namesService.findAddressByName();
    }
}
