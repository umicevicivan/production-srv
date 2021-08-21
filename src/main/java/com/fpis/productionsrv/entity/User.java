package com.fpis.productionsrv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User", schema = "fpis")
public class User {
    @Id
    private Long id;
    private String userName;
    private String password;
    private String email;
}
