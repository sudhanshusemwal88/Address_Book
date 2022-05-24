package com.sudhanshu.AddressBook.Service;


import com.sudhanshu.AddressBook.entity.AddressBook;
import com.sudhanshu.AddressBook.exceptions.ResourceNotFoundException;
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

    public void updateResource(AddressBook addressBook)
    {
        AddressBook newAddressBook = addressBookRepository.findCustomerById(addressBook.getId());

        if(addressBook.getLastName() != null) {
            newAddressBook.setLastName(addressBook.getLastName());
        }
        if(addressBook.getContactNumber() != null) {
            newAddressBook.setContactNumber(addressBook.getContactNumber());
        }
        if(addressBook.getFirstName() != null) {
            newAddressBook.setFirstName(addressBook.getFirstName());
        }

        if(addressBook.getEmailId() != null) {
            newAddressBook.setEmailId(addressBook.getEmailId());
        }
        if(addressBook.getPinCode() != null) {
            newAddressBook.setPinCode(addressBook.getPinCode());
        }
        if(addressBook.getAddress() != null) {
            newAddressBook.setAddress(addressBook.getAddress());
        }
        if(addressBook.getAddressType() != null) {
            newAddressBook.setAddressType(addressBook.getAddressType());
        }

        addressBookRepository.save(newAddressBook);
    }
}
