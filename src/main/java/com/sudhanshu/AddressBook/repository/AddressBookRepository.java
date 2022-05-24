package com.sudhanshu.AddressBook.repository;

import com.sudhanshu.AddressBook.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {

    AddressBook findCustomerById(Long id);
}
