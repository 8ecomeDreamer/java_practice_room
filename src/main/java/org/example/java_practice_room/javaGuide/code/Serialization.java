package org.example.java_practice_room.javaGuide.code;

import java.io.Serializable;

public class Serialization implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;
    public static void main(String[] args) {
        System.out.println("\033[1mjava序列化\033[0m");
        System.out.println();
        System.out.println("1.概念解释：序列化：将原始数据转换成可以存储或者传输的形式，常见的格式有json、xml、二进制等。" + "反序列化：将序列化生成的格式转换成原始数据。");
        System.out.println();
        System.out.println("2.创建序列化的方式一般有：" + " 实现jdk自带的Serializable接口" + "， 和其他方式，但其他方式不常见可以暂时不用学习。");
        System.out.println();
        System.out.println("3.序列化中需要注意的是需要推荐手动生成序列号uid，即SerialVersionUID。这个变量不会被序列化，但是在反序列化时会进行版本检查测试其兼容性。若匹配不上，则系统会抛出invalidClassException错误。");
        System.out.println();
        System.out.println("4.如果类中有不想序列化的字段，则可以使用transient修饰符，至于其注意事项在使用的时候再看。");
    }
}
