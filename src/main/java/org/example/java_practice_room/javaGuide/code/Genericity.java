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
        System.out.println("泛型中还有\033[1m类型擦除\033[0m的概念，简单来说就是，泛型是编译器为了减少开发阶段的错误提供给开发者使用的，而在编译过程中虚拟机对此一无所知。" + "\n");
        System.out.println("泛型中存在一种通配符（？），也叫无界通配符");
        System.out.println("泛型和无界通配符的区别：");
        System.out.println("1.T可以用在变量或者常量上，而？不行。");
        System.out.println("2.T一般用于泛型类或方法中，而？一般是用在泛型方法中。");
        System.out.println("3.T在编译期会被擦除为限定类型或Object，而通配符只用于捕获具体类型。" + "\n");
        System.out.println("泛型中的通配符有：上界通配符（extends）和下界通配符（super）");
        System.out.println("上界通配符：传入类型受到继承的类型限制，即传入的类型必须是继承类型的子类型。");
        System.out.println("下界通配符：传入类型受到继承的类型限制，即传入的类型必须是继承类型的父类型。");
    }
}
