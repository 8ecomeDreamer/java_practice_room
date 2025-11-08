package org.example.java_practice_room.javaGuide.code;

public class Genericity {

    public static class CustomGenerator<T> {
        private T key;

        public CustomGenerator(T key) {
            this.key = key;
        }

        public T getKey() {
            return this.key;
        }
    }

    public static class CustomHobbies {
        public String hobbyName;
    }

    public static class CustomClass {
        public String name;
        public int age;

        public CustomHobbies hobbies;
    }

    public static interface CustomGeneratorInterface<T> {
        public T customMethod();
    }

    public static class CustomGeneratorMethod<T> implements  CustomGeneratorInterface<T> {

        @Override
        public T customMethod() {
            return null;
        }
    }

    public static class CustomGeneratorMethod2<string> implements  CustomGeneratorInterface<String> {

        @Override
        public String customMethod() {
            return "这个是指定返回类型的泛型方法";
        }
    }

//    public static void CustomMethod<T>() {
//        public T getKey();
//    }

    public static <E> void printArray( E[] inputArray ) {
        for (E el : inputArray) {
            System.out.printf("%s ",el);
        }
    }

    public static void main(String[] args) {
        System.out.println("\033[1m泛型\033[0m");
        System.out.println("java中泛型分为方法泛型、接口泛型、类泛型" + "\n");
        System.out.println("这个泛型类由于没有指定具体的类型，因此可以传任何类型");
        CustomGenerator<String> stringCustomGenerator = new CustomGenerator<>("hello genericity");
        System.out.println("stringCustomGenerator.getKey() = " + stringCustomGenerator.getKey());
        CustomGenerator<Integer> intCustomGenerator = new CustomGenerator<>(15);
        System.out.println("intCustomGenerator.getKey() = " + intCustomGenerator.getKey());
        CustomGenerator<CustomClass> classCustomGenerator = new CustomGenerator<>(new CustomClass());
        System.out.println("classCustomGenerator.getKey() = " + classCustomGenerator.getKey());
        CustomGenerator<String[]> CustomStringArray = new CustomGenerator<>(new String[]{"hello", "genericity"});
        System.out.println("CustomStringArray.getKey() = " + CustomStringArray.getKey() + "\n");
        System.out.println("这个泛型接口既可以指定类型，也可以不指定类型" );
        System.out.println("指定类型:" + new CustomGeneratorMethod2().customMethod());
        System.out.println("不指定类型:" + new CustomGeneratorMethod().customMethod() + "\n");
        System.out.println("泛型方法结果如下：" );
        String[] stringArray = { "Hello", "World" };
        printArray(stringArray);


    }
}
