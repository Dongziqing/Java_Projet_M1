package com.gvv.entity;

import lombok.Data;

@Data
public class Customer {
    private int customerId;
    private int countryId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
