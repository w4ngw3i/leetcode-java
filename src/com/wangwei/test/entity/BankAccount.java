package com.wangwei.test.entity;

import java.util.List;

/**
 * @author wangwei
 * @version 1.0
 * @date 2021-11-06 22:31
 */
public class BankAccount {
    private Long id;
    private String bankName;
    private String address;
    private List<User> userList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
