package com.wangwei.test.entity;

import java.io.Serializable;

/**
 * @author wangwei
 * @version 1.0
 * @date 2021-09-15 14:07
 */
public class User implements Serializable {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
