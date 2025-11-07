package org.example.java_practice_room.javaGuide.code;

public class value_passing_way {


    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a + ", b = " + b);
    }
    public static void printJavaBasicValueDelivery() {
        int num1 = 10;
        int num2 = 20;
        swap(10, 20);
        System.out.println("num1= " + num1 + ", num2 = " + num2);
        System.out.println("由于这里的形参是实参复制的副本，属于值传递，因此修改副本并不会影响原来的内容。");
        System.out.println();
    }

    public static void change(int[] args1) {
        args1[0] = 100;
    }

    public static void printJavaQuoteValueDelivery1() {
        int [] args1 = {1, 2, 3};

        System.out.println("args1第一个元素是：" + args1[0] + " 地址是：" + args1.toString());
        change(args1);
        System.out.println("经过了change函数之后，args1第一个元素是：" + args1[0] + " 地址是：" + args1.toString());
        System.out.println("这里虽然值变更了，但是其实因为值存的是引用地址，引用地址变更了之后，所以值就会跟着变。");
        System.out.println();
    }


    public static void printJavaQuoteValueDelivery2(Person person1, Person person2) {
        System.out.println("交换前" + "person1:" + person1.getName() + "， person2:" + person2.getName());
        Person temp = person1;
        person1 = person2;
        person2 = temp;
        System.out.println("交换后" + "person1:" + person1.getName() + "， person2:" + person2.getName());
    }

    public static void main(String[] args) {
        System.out.println("\033[1mjava值传递\033[0m");
        System.out.println("首先我们需要明白什么是值传递，值传递是通过接受实参的拷贝，创建副本。引用传递则是接受实参的地址，对形参的任何修改都会反应到实参，包括赋值。");
        System.out.println();
        System.out.println("情景1：传递基本类型参数");
        printJavaBasicValueDelivery();
        System.out.println("情景2：传递引用类型参数1");
        printJavaQuoteValueDelivery1();
        System.out.println("情景3：传递引用类型参数2");
        Person xiaoZhang = new Person("小张");
        Person xiaoLi = new Person("小李");
        printJavaQuoteValueDelivery2(xiaoZhang, xiaoLi);
        System.out.println("交换后" + "xiaoZhang:" + xiaoZhang.getName() + "， xiaoLi:" + xiaoLi.getName());
        System.out.println("总结：值传递分为值传递和引用地址传递，但java只有值传递的方式");
    }
}

