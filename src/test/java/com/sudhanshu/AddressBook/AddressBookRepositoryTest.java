package com.sudhanshu.AddressBook;


import com.sudhanshu.AddressBook.entity.AddressBook;
import com.sudhanshu.AddressBook.repository.AddressBookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddressBookRepositoryTest {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveAddressBookTest(){

        AddressBook addressBook = AddressBook.builder()
                .firstName("sudhanshu")
                .lastName("semwal")
                .emailId("sudhanshu@example.com")
                .contactNumber("7795041021")
                .pinCode("201308")
                .build();

        addressBookRepository.save(addressBook);

        Assertions.assertThat(addressBook.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getAddressBookTest(){

        AddressBook addressBook = addressBookRepository.findById(1L).get();

        Assertions.assertThat(addressBook.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfAddressBookTest(){

        List<AddressBook> addressBook = addressBookRepository.findAll();

        Assertions.assertThat(addressBook.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateAddressBookTest(){

        AddressBook addressBook = addressBookRepository.findById(1L).get();

        addressBook.setEmailId("sudhanshu@gmail.com");

        AddressBook addressBookUpdated =  addressBookRepository.save(addressBook);

        Assertions.assertThat(addressBookUpdated.getEmailId()).isEqualTo("sudhanshu@gmail.com");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteAddressBookTest(){

        AddressBook addressBook = addressBookRepository.findById(1L).get();

        addressBookRepository.delete(addressBook);

        AddressBook addressBook1 = null;

        Optional<AddressBook> optionalAddressBook = addressBookRepository.findById(1L);

        if(optionalAddressBook.isPresent()){
            addressBook1 = optionalAddressBook.get();
        }

        Assertions.assertThat(addressBook1).isNull();
    }
}
