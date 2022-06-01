package com.sudhanshu.AddressBook;


import com.sudhanshu.AddressBook.service.NamesService;
import com.sudhanshu.AddressBook.entity.Names;
import com.sudhanshu.AddressBook.repository.NamesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NamesServiceTest {

    @Autowired
    private NamesService namesService;

    @MockBean
    private NamesRepository namesRepository;

    @Test
    public void getAddressByNames() throws Exception {
        when(namesRepository.findAll()).thenReturn(Stream.of(new Names(3L,"sudhanshu","semwal")).
                collect(Collectors.toList()));

        assertEquals(1, namesService.findAddressByName().size());
    }
}
