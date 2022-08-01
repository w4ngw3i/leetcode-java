package com.wangwei.test.entity;

/**
 * @author wangwei
 * @version 1.0
 * @date 2021-11-06 22:21
 */
public class DiffValue {

    private Object oldValue;

    private Object newValue;

    public Object getOldValue() {
        return oldValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    @Override
    public String toString() {
        return "DiffValue{" +
                "oldValue=" + oldValue +
                ", newValue=" + newValue +
                '}';
    }
}
