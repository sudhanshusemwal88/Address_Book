package com.sudhanshu.AddressBook.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "address_type")
public class AddressType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type")
    private String type;

    @OneToMany(targetEntity = Names.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "names_fk", nullable = false)
    private List<Names> names = new ArrayList<>();
}