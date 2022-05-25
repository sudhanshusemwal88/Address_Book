package com.sudhanshu.AddressBook.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Entity
@Table(name = "customer")
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "pin_code")
    private String pinCode;


    @OneToMany(targetEntity = AddressType.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "address_type_fk", nullable = false)
    private List<AddressType> addressType = new ArrayList<>();

    @OneToMany(targetEntity = Address.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name ="ca_fk",referencedColumnName = "id")
        private List<Address> address = new ArrayList<>();
}
