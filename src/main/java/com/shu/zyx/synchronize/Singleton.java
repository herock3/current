package com.shu.zyx.synchronize;

/**
 * Created by zyx on 2018/5/4.
 */
public class Singleton {
    //1 枚举法
    static enum Singleton1{
        INSTANCE;
    }

    //2 饿汉式
    static class Singleton2{
        private final static Singleton2 singleton=new Singleton2();
        public static Singleton2 getInstace(){
            return singleton;
        }
    }

    //3 内部类
    static class Singleton3{
        private  static Singleton3 singleton;
        static class Inner{
            private static Singleton3 singleton=new Singleton3();
        }
        public static Singleton3 getInstace(){
            return Inner.singleton;
        }
    }

    //4 双重锁机制
    static class Singleton4{
        private  volatile static Singleton4 singleton;
        private Singleton4 getInstace(){
            if(singleton==null){
                synchronized (Singleton.class){
                    if(singleton==null){
                        singleton=new Singleton4();
                    }
                }
            }
            return singleton;
        }
    }

}
