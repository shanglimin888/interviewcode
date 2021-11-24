package com.scl.juc;

public class ThreadLocaDemo {
 
    private static ThreadLocal<User> localVar = new ThreadLocal<User>();
 
    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get().toString());
        //清除本地内存中的本地变量
        localVar.remove();
    }
    public static void main(String[] args) throws InterruptedException {

        User user = new User();


        new Thread(new Runnable() {
            public void run() {
                user.setAge("aage");
                user.setName("aname");
                ThreadLocaDemo.localVar.set(user);
                print("A");
                Thread thread = Thread.currentThread();
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
               
            }
        },"A").start();
 
        Thread.sleep(1000);
 
        new Thread(new Runnable() {
            public void run() {
                ThreadLocaDemo.localVar.set(user);
                print("B");
                System.out.println("after remove : " + localVar.get());
              
            }
        },"B").start();
    }

    static class User{
        String name;
        String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}

 
