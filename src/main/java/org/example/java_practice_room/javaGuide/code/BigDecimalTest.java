package org.example.java_practice_room.javaGuide.code;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    public static void main(String[] args) {
        System.out.println("\033[1mBigDecimal\033[0m");
        System.out.println("BigDecimal类用于处理计算机中精度丢失的问题。");
        System.out.println("BigDecimal类加减乘除分别为：add、subtract、multiply、divide。");
        BigDecimal num1 = new BigDecimal("1.01");
        BigDecimal num2 = new BigDecimal("0.09");
        BigDecimal sum = num1.add(num2);
        BigDecimal sub = num1.subtract(num2);
        BigDecimal mul = num1.multiply(num2);
        BigDecimal div = num1.divide(num2, 2, RoundingMode.HALF_UP);
        System.out.println("相加：" +  sum + "相减：" + sub + "相乘：" + mul + "相除：" + div + "\n");
        System.out.println("值得注意的是divide方法中第三个参数，这个参数规定了数值的取舍方式，我们可以使用java中的枚举类RoundingMode。");
        System.out.println("roundingMode有五种取舍方法, half_up（四舍五入）、up（往远离0的方式取）、down（往接近0的方式取）、ceiling（往正无穷方向取）、floor（往负无穷方向取）");
        System.out.println("大数字的比较方法是compareTo，输出1表示大于，输出-1表示小于" + num1.compareTo(num2) + " " + num2.compareTo(num1));
        System.out.println("也可以用equals方法比较，equals跟compareTo的区别是equals除了比较值的大小还会比较精度。" );
    }
}
