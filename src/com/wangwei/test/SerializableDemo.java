package com.wangwei.test;

import com.wangwei.test.entity.User;
import com.wangwei.utils.Profiler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * @author wangwei
 * @version 1.0
 * @date 2021-09-15 14:06
 */
public class SerializableDemo {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setName("test");
        user.setPassword("test");
        objectOutPutStreamDemo(user);
        byteBufferDemo(user);
    }

    /**
     * java序列化
     * @param user
     * @throws IOException
     */
    private static void objectOutPutStreamDemo(User user) throws IOException {
        Profiler.begin();
        for (int i = 0; i < 10000; i++) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(user);
            oos.flush();
            oos.close();
            byte[] testByte = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        }
        System.out.println("ObjectOutputStream 序列化时间: " + Profiler.end());
    }

    /**
     * byteBuffer序列化
     * @param user
     * @throws IOException
     */
    private static void byteBufferDemo(User user) throws IOException {
        Profiler.begin();
        for (int i = 0; i < 10000; i++) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
            byte[] nameByte = user.getName().getBytes();
            byte[] passwordByte = user.getPassword().getBytes();
            byteBuffer.putInt(nameByte.length);
            byteBuffer.put(nameByte);
            byteBuffer.putInt(passwordByte.length);
            byteBuffer.put(passwordByte);
            byteBuffer.flip();
            byte[] bytes = new byte[byteBuffer.remaining()];
        }
        System.out.println("ByteBuffer 序列化时间: " + Profiler.end());
    }
}
