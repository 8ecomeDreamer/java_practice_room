package org.example.java_practice_room.javaGuide.code;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {


    /**
     *  jdk中的反射源码
     */
    public static class DebugInvocationHandler implements InvocationHandler {

        private final Object target;

        public DebugInvocationHandler(Object target) {
            this.target = target;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
            System.out.println("调用方法前" + method.getName());
            Object result = method.invoke(target, args);
            System.out.println("调用方法后" + method.getName());
            return result;
        }
    }

    public static class customReflectedClass {

        private final String target;

        public customReflectedClass() {
            target = "customReflectedClass";
        }

        public void publicMethod(String s) {
            System.out.println("public method:" + s);
        }
        public void privateMethod() {
            System.out.println("private method:" + target);
        }
    }

    public static void callCustomReflectedClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        System.out.println("\033[1m关于反射的方法\033[0m");

        // 1.通过Class.forName()获取Class对象，替代的方法还有其他三种：对象实例的getClass()方法、xxxClassLoader的loadClass()方法、知道具体类名的.class属性
        Class<?> targetClass = Class.forName("org.example.java_practice_room.javaGuide.code.Reflect$customReflectedClass");
        customReflectedClass targetObject = (customReflectedClass) targetClass.newInstance();

        // 2.在得到类之后通过getDeclaredMethods()获取所有的方法
        Method[] methods = targetClass.getDeclaredMethods();
        System.out.println("这个类中的方法有：");
        for(Method method: methods) {
            System.out.printf("\t" + method.getName());
        }
        System.out.println();

        // 3.调用方法并获取指定参数
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        System.out.println(publicMethod);
        publicMethod.invoke(targetObject, "Jim");
        Field field = targetClass.getDeclaredField("target");
        // 取消获取参数时的安全性检查
        field.setAccessible(true);
        field.set(targetObject, "Jim");

        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.invoke(targetObject);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        System.out.println("\033[1m反射\033[0m");
        System.out.println("反射：java中的灵魂，通过反射你可以获取到一个类中的方法和属性，且可以调用这些方法和属性。");
        System.out.println("反射常用场景：注解、springboot等框架等。");
        System.out.println("反射的优缺点。优点：通过反射可以更加灵活的调用其他框架的代码。缺点：灵活调用带来的是安全性的隐患，且反射的性能稍微差点，但对于框架来说是影响不大的。" + "\n");
        System.out.println("反射的实战：");
//        System.out.println("1.反射之前需要获取类名。java提供了4个获取类名的方式，Class类的forName方法、对象实例的getClass方法、知道具体类名的.class方法、xxxClassLoader.loadClass等方法");
        callCustomReflectedClass();
        System.out.println();
        System.out.println("总结：");
        System.out.println("1.在反射操作之前需要获取需要反射的类名，而类名有4种获取方式，分别是：在知道具体类名之后的.class属性、xxxClassLoader的loadClass()、Class类的classForName()、实例的getClass()");
        System.out.println("2.在获取具体类之后，可以使用newInstance()创建实例。后续反射基于这个对象实例进行。");
        System.out.println("3.在反射中可以获取具体的属性、方法。其中，getDeclaredMethod()获取所有方法，其类型是Method[]（也可以使用getDeclareMethod获取单个方法）。getDeclaredField()可以获取所有属性，其类型是Field。");
        System.out.println("4.invoke(Object, args)是反射的关键,它接受两个参数，被反射的对象以及需要传递的参数");
        System.out.println("5.使用反射的话，要了解伴随着它使用的异常，如ClassNotFoundException等");
        System.out.println("6.由于我是封装了一个方法进行反射，然后在main()里调用，这就出现了异常传播概念的概念，即需要一直沿着这个链抛出异常。（当然也可以直接用try...catch操作）");
        System.out.println("7.异常传播概念：异常需要通过逐级传播或者try..catch处理");
        System.out.println("8.解释一下这里出现的各种异常：ClassNotFoundException(找不到具体的类)、InstantiationException(创建实例报错、可能是构造函数或抽象类报错)、IllegalAccessException(类中有私有对象，而没有设置setAccessible(true)导致)、NoSuchFieldException(没有这个字段)、NoSuchMethodException(没有这个方法)、InvocationTargetException(反射异常)");
    }
}
