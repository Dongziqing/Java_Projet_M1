package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class CustomerDTO {
    private int customerId;
    private int customerTypeId;
    private int countryId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

    private String customerTypeName;
}
