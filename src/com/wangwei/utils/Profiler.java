package com.wangwei.utils;

/**
 * @author wangwei
 * @version 1.0
 * @date 2021-09-15 14:15
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREAD_LOCAL = ThreadLocal.withInitial(System::currentTimeMillis);

    public static void begin() {
        TIME_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    public static Long end() {
        return System.currentTimeMillis() - TIME_THREAD_LOCAL.get();
    }
}
