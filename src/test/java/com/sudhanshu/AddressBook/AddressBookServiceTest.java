package com.sudhanshu.AddressBook;


import com.sudhanshu.AddressBook.service.AddressBookService;
import com.sudhanshu.AddressBook.entity.Address;
import com.sudhanshu.AddressBook.entity.AddressBook;
import com.sudhanshu.AddressBook.entity.AddressType;
import com.sudhanshu.AddressBook.entity.Names;
import com.sudhanshu.AddressBook.repository.AddressBookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressBookServiceTest {

    @Autowired
    private AddressBookService service;

    @MockBean
    private AddressBookRepository repository;

    @Test
    public void getAddressBook() throws Exception {


        List<Names> nameList = new ArrayList<Names>();
        nameList.add(new Names(2l, "sudhanshu", "semwal"));
        List<Address> AddressList = new ArrayList<Address>();
        AddressList.add(new Address(1L, "102-street", "sector-16", "noida"));

        List<AddressType> AddressTypeList = new ArrayList<AddressType>();
        AddressTypeList.add(new AddressType(3L, "friends", nameList));

        when(repository.findAll()).thenReturn(Stream
                .of(new AddressBook(3, "Danile", "31",
                        "7795041021", "sudhanshu@example",
                        "201308", AddressTypeList, AddressList)).collect(Collectors.toList()));

        assertEquals(1, service.getAllCustomers().size());
    }

    @Test
    public void saveAddressBookTest() {

        List<Names> nameList = new ArrayList<Names>();
        nameList.add(new Names(2l, "sudhanshu", "semwal"));
        List<Address> AddressList = new ArrayList<Address>();
        AddressList.add(new Address(1L, "102-street", "sector-16", "noida"));

        List<AddressType> AddressTypeList = new ArrayList<AddressType>();
        AddressTypeList.add(new AddressType(3L, "friends", nameList));

        AddressBook addressBook = new AddressBook(3, "Danile", "31",
                "7795041021", "sudhanshu@example",
                "201308", AddressTypeList, AddressList);
        when(repository.save(addressBook)).thenReturn(addressBook);

        assertEquals(addressBook, service.saveOrUpdate(addressBook));
    }

    @Test
    public void deleteAddressBookTest() {
        List<Names> nameList = new ArrayList<Names>();
        nameList.add(new Names(2l, "sudhanshu", "semwal"));
        List<Address> AddressList = new ArrayList<Address>();
        AddressList.add(new Address(1L, "102-street", "sector-16", "noida"));

        List<AddressType> AddressTypeList = new ArrayList<AddressType>();
        AddressTypeList.add(new AddressType(3L, "friends", nameList));

        AddressBook addressBook = new AddressBook(1L, "Danile", "31",
                "7795041021", "sudhanshu@example",
                "201308", AddressTypeList, AddressList);
        service.deleteCustomerById(addressBook.getId());
        verify(repository, times(1)).deleteById(addressBook.getId());
    }


    @Test
    public void addressBookIdTest() {

        List<Names> nameList = new ArrayList<Names>();
        nameList.add(new Names(2l, "sudhanshu", "semwal"));
        List<Address> AddressList = new ArrayList<Address>();
        AddressList.add(new Address(1L, "102-street", "sector-16", "noida"));

        List<AddressType> AddressTypeList = new ArrayList<AddressType>();
        AddressTypeList.add(new AddressType(3L, "friends", nameList));

        Long id = 3L;

        AddressBook addressBook = new AddressBook(3, "Danile", "31",
                "7795041021", "sudhanshu@example",
                "201308", AddressTypeList, AddressList);

        when(repository.findCustomerById(id)).thenReturn(addressBook);

        assertEquals(addressBook, service.findCustomerById(id));
    }

    @Test
    public void updateAddressBookIdTest() {

        List<Names> nameList = new ArrayList<Names>();
        nameList.add(new Names(2l, "sudhanshu", "semwal"));
        List<Address> AddressList = new ArrayList<Address>();
        AddressList.add(new Address(1L, "102-street", "sector-16", "noida"));

        List<AddressType> AddressTypeList = new ArrayList<AddressType>();
        AddressTypeList.add(new AddressType(3L, "friends", nameList));

        AddressBook addressBook = new AddressBook(3, "Danile", "31",
                "7795041021", "sudhanshu@example",
                "201308", AddressTypeList, AddressList);


        when(repository.save(addressBook)).thenReturn(addressBook);

        assertEquals(addressBook, service.saveOrUpdate(addressBook));


    }
}