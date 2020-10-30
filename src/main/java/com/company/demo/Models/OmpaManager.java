package com.company.demo.Models;

import javax.persistence.*;

@Entity
public class OmpaManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private String ompaname;
    @Column (nullable = false)
    private String dateofbirth;
    @Column
    private String address;

    @OneToOne(mappedBy = "ompaManager")
    private Factory factory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOmpaname() {
        return ompaname;
    }

    public void setOmpaname(String ompaname) {
        this.ompaname = ompaname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}



