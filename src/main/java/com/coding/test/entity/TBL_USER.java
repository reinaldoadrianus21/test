package com.coding.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "tbl_user", schema = "codingtest")

public class TBL_USER {
    @Id
    @Column(name = "userid")
    private Integer userid;

    @Column(name = "namalengkap")
    private String namalengkap;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private Character status;
}
