package com.wangwei.utils;
import com.wangwei.test.entity.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

import com.wangwei.test.entity.BankAccount;
import com.wangwei.test.entity.DiffValue;

import java.lang.reflect.Field;
import java.util.stream.Collectors;

/**
 * @author wangwei
 * @version 1.0
 * @date 2021-11-06 22:20
 */
public class ObjectUtils {

    /**
     * 比较两个对象属性变化
     * @param oldObj 变化前
     * @param newObj 变化后
     * @return 比较结果
     */
    public static Map<String, DiffValue> diffObj(Object oldObj, Object newObj) throws IllegalAccessException {
        Map<String, DiffValue> diffValueMap = new HashMap<>();
        Class<?> oldObjClass = oldObj.getClass();
        Class<?> newObjClass = newObj.getClass();
        if (Objects.equals(oldObjClass, newObjClass)) {
            Field[] fields = oldObjClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getGenericType() instanceof ParameterizedType) {
                    continue;
                }
                Object oldValue = field.get(oldObj);
                Object newValue = field.get(newObj);
                if ((oldValue == null && newValue != null) || (oldValue != null && !oldValue.equals(newValue))) {
                    DiffValue diffValue = new DiffValue();
                    diffValue.setOldValue(oldValue);
                    diffValue.setNewValue(newValue);
                    diffValueMap.put(field.getName(), diffValue);
                }
            }
        }
        return diffValueMap;
    }

    public static void getAllSetMethod() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        Set<Method> methodSet = Arrays.stream(beanInfo.getPropertyDescriptors())
                .map(PropertyDescriptor::getWriteMethod)
                .collect(Collectors.toSet());
        for (Method method : methodSet) {
            String name = method.getName();
            System.out.println(name);
        }
    }

    public static void main(String[] args) throws IllegalAccessException, IntrospectionException {
        getAllSetMethod();
        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.setId(1000L);
        bankAccount1.setBankName("工商银行");
        bankAccount1.setAddress("北京");
        User user1 = new User();
        user1.setName("wangwei");
        user1.setPassword("wangwei01");
        ArrayList<User> list1 = new ArrayList<>();
        list1.add(user1);
        bankAccount1.setUserList(list1);
        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.setId(1002L);
        bankAccount2.setBankName("建设银行");
        bankAccount2.setAddress("北京");
        User user2 = new User();
        user2.setName("wangwei");
        user2.setPassword("wangwei02");
        ArrayList<User> list2 = new ArrayList<>();
        list2.add(user2);
        bankAccount2.setUserList(list2);
        Map<String, DiffValue> diffValueMap = diffObj(bankAccount1, bankAccount2);
        diffValueMap.forEach((k, v) -> {
            System.out.println("field=" + k + ", value=" + v);
        });
        List<User> userList2 = bankAccount2.getUserList();
        List<User> userList1 = bankAccount1.getUserList();
        for (int i = 0; i < userList2.size(); i++) {
            Map<String, DiffValue> diffValueMap1 = diffObj(userList2.get(0), userList1.get(0));
            diffValueMap1.forEach((k, v) -> {
                System.out.println("field=" + k + ", value=" + v);
            });
        }

    }
}
