package com.sudhanshu.AddressBook.service;

import com.sudhanshu.AddressBook.entity.Names;
import com.sudhanshu.AddressBook.repository.NamesRepository;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NamesService {

    @Autowired
    private NamesRepository namesRepository;

    public List<Names> findAddressByName()
    {
        List<Names> namesList = namesRepository.findAll();

        namesList = StreamEx.of(namesList)
                .distinct(Names::getFirstName)
                .distinct(Names::getLastName)
                .toList();

               return namesList;
    }
}
