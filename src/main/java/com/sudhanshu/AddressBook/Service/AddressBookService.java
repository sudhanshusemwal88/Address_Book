package com.sudhanshu.AddressBook.Service;


import com.sudhanshu.AddressBook.entity.AddressBook;
import com.sudhanshu.AddressBook.repository.AddressBookRepository;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;


    public List<AddressBook> getAllCustomers()
    {
        List<AddressBook> addressBook = new ArrayList<AddressBook>();
        addressBookRepository.findAll().forEach(addressBook1 -> addressBook.add(addressBook1));
        return addressBook;
    }

    public void save(AddressBook addressBook)
    {
        addressBookRepository.save(addressBook);
    }

    public AddressBook findCustomerById(Long id) {

        return addressBookRepository.findCustomerById(id);
    }

    public List<AddressBook> findCustomerByName()
    {
        List<AddressBook> addressBook = addressBookRepository.findAll();

        addressBook = StreamEx.of(addressBook)
                .distinct(AddressBook::getFirstName)
                .toList();

        addressBook = StreamEx.of(addressBook)
                .distinct(AddressBook::getLastName)
                .toList();

         return addressBook;
    }

    public void saveOrUpdate(AddressBook addressBook)
    {
        addressBookRepository.save(addressBook);
    }

    public void deleteCustomerById(Long id)
    {
        addressBookRepository.deleteById(id);
    }
}
