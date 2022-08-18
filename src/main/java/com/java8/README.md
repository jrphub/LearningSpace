## Java8 Features



### Functional Interface

A **functional interface** is an interface that contains only one abstract method.

- It can have any number of default and static methods.

- Example : 

    - Runnable : run()
    - ActionListener: actionPerformed()
    - Comparable: compareTo()
    - Callable: call()

- Also called as Single Abstract Method (SAM) Interface.

- Lambda Expression and Method Reference are the instance of Functional Interface.

- Before Java8, we had to create anonymous inner class objects or implement these interfaces

    ```java
    //before Java8, we had to create anonymous inner class
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Thread Started!");
        }
    }).start();
    
    //lambda expression
    new Thread(() -> System.out.println("Thread Started!")).start();
    ```

- @FunctionalInterface annotation is used to ensure that the functional interface can’t have more than one abstract method. Not mandatory to use it.

    ```java
    @FunctionalInterface
    public interface BSquare {
        int calculate(int x);
    }
    
    class calculator {
        public static void main(String[] args) {
            int a = 5;
            //lambda expression : instance of Functional Interface
            BSquare s = (int x) -> x * x;
            System.out.println(s.calculate(a));
        }
    }
    ```

- Java8 includes 4 main kind of Functional Interfaces

    - Consumer -> BiConsumer : accept()
    - Predicate -> BiPredicate : test()
    - Function -> BiFunction, Unary Operator, Binary Operator : apply()
    - Supplier : get()

#### Consumer

```java
Consumer<Integer> consumer = (value) -> System.out.println(value);

consumer.accept(5);
```

#### Predicate

```java
Predicate predicate = (value) -> value != null;

predicate.test(5);
```

#### Function

A function is a type of functional interface in Java that receives only a single argument and returns a value after the required processing.

##### 	Bi-Function

```java
@FunctionalInterface
public interface BiFunction<T, U, R> 
{
 
   R apply(T t, U u);
    .......
 
}
```

​		T & U are inputs and there is only one output R

##### 			Unary Operator

```java
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, U> 
{
    ……...	
}
```

​		It accepts only one argument and returns a single argument. Both input and output values must be identical and of the same type.		

##### 			Binary Operator

```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, U, R> 
{
    ……...
}
```

​		It takes two values and returns one value, but input and output value type must be identical and of the same type.

#### 	Supplier

​	The Supplier functional interface is also a type of functional interface that does not take any input or argument and yet returns a single output.  

```java
@FunctionalInterface
public interface Supplier<T>{
 
// gets a result
………….
 
// returns the specific result
…………
 
T.get();
 
}
```

### Lambda Expression

Lambda expressions basically express instances of functional interfaces.

- lambda expressions provide below functionalities.
  - Enable to treat functionality as a method argument, or code as data.
  - A function that can be created without belonging to any class.
  - A lambda expression can be passed around as if it was an object and executed on demand.

```java
public class CLambdaExpressionTwoArgs {

    @FunctionalInterface
    interface FunctInterface1 {
        int operation(int a, int b);
    }

    @FunctionalInterface
    interface FuncInterface2 {
        void sayMessage(String msg);
    }

    private int operate(int a, int b, FunctInterface1 obj1) {
        return obj1.operation(a, b);
    }

    public static void main(String[] args) {
        FunctInterface1 add = (x, y) -> x + y; //Integer::sum
        FunctInterface1 multiply = (x, y) -> x * y;

        CLambdaExpressionTwoArgs test = new CLambdaExpressionTwoArgs();
        System.out.println("Addition : " + test.operate(5, 2, add));
        System.out.println("Multiplication : " + test.operate(5, 2, multiply));

        FuncInterface2 fobj = m -> System.out.println(m); //System.out::println
        fobj.sayMessage("calculation completed");
    }

}
```

**Creating Thread using Lambda Expression**

```java
public class DThreadLambda {
    public static void main(String[] args) {
        // Creating Lambda expression for run() method in
        // functional interface "Runnable"
        Runnable runnable = () -> {
            Thread.currentThread().setName("Test Thread");
            System.out.println(Thread.currentThread().getName() + " is running");
        };

        // Instantiating Thread class by passing Runnable
        // reference to Thread constructor
        Thread thread = new Thread(runnable);

        //Starting the thread
        thread.start();
    }
}
```

**Checking if String contains only Alphabet**

```java
public class ECheckAllString {

    static Predicate<String> p = ECheckAllString::test;

    //sol2 : static Predicate<String> p = s -> s.matches("^[a-zA-Z]*$");

    public static boolean isAllString(String str) {
        //sol1 : return (str != null) && (str != "") && str.chars().allMatch(Character::isLetter);
        return (str != null) && (str != "") && p.test(str);
    }

    public static void main(String[] args) {
        System.out.println("For XYZ :" + ECheckAllString.isAllString("XYZ")); //true
        System.out.println("For XYZ12 :" + ECheckAllString.isAllString("XYZ12")); //false
        System.out.println("For null :" + ECheckAllString.isAllString(null)); //false
        System.out.println("For empty :" + ECheckAllString.isAllString("")); //false
    }

    private static boolean test(String s) {
        return s.matches("^[a-zA-Z]*$");
    }
}
```

**Serializing Lambda Expression**

```java
public class GLambdaSerialization {

    interface SerializableRunnable extends Runnable, Serializable {
    }

    public static Object getLambdaObject() {
        //Runnable r = (Serializable & Runnable )() -> System.out.println("Serialize the message");
        SerializableRunnable r = () -> System.out.println("Serialize the message");
        return r;
    }

    public static void main(String[] args) {
        System.out.println(GLambdaSerialization.getLambdaObject());
    }
}
```

**Difference between inner class and Lambda Expression**

| Anonymous Inner Class                                        | Lambda Expression                                            |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| It can extend abstract and concrete class.                   | It can’t extend abstract and concrete class.                 |
| It can implement an interface that contains any number of abstract methods. | It can implement an interface which contains a single abstract methods. |
| Inside this we can declare instance variables.               | It does not allow declaration of instance variables, whether the variables declared simply act as local variables. |
| Inside Anonymous inner class, “this” always refers to current anonymous inner class object but not to outer object. | Inside Lambda Expression, “this” always refers to current outer class object that is, enclosing class object. |
| It is the best choice if we want to handle multiple methods. | It is the best choice if we want to handle interface.        |
| At the time of compilation, a separate .class file will be generated. | At the time of compilation, no separate .class file will be generated. It simply convert it into private method outer class. |
| Memory allocation is on demand, whenever we are creating an object. | It resides in a permanent memory of JVM.                     |

### forEach() Method in Iterable Interface

The Iterable interface has a default method called “forEach.” Collection classes use it to iterate items, which extends the Iterable interface.

You may send Lambda Expression as an argument to the “forEach” method, which accepts the Functional Interface as a single parameter.

```java
public class HForEach {

    public static void main(String[] args) {
        List<String> vegList = Arrays.asList(
                "potato",
                "carrot",
                "cauliflower",
                "tomato"
        );
        System.out.println("===========Vegetables==========");
        //vegList.forEach(s -> System.out.println(s));
        vegList.forEach(System.out::println);
    }
}
```

### Optional Class

The “java.util” package included an optional class. The public final class “Optional” is used to handle NullPointerException in a Java program. Optional reduces the number of null checks required to avoid a nullPointerException.

```java
public class IOptionalJava {

    public static void main(String[] args) {
        String[] arr = new String[3];
        Optional<String> checkNull = Optional.ofNullable(arr[1]);
        if (checkNull.isPresent()) {
            System.out.println(arr[1].toLowerCase());
        } else {
            System.out.println("String is null");
        }
    }
}
```

### Default And Static Methods In Interfaces

You may add non-abstract methods to interfaces, allowing you to create interfaces with method implementation. This ensures that the code created for previous versions is compatible with the newer interfaces (binary compatibility). If a class wishes to alter the default method, it may override it and give its own implementation.

### Java Date Time API

Under the package java.time, Java 8 offers a new date-time API. The following are the most prominent classes among them:

- Local: Simplified date-time API with no timezone management complexity.
- Zoned: specialized date-time API that can handle several time zones.

| Class             | Description                                                  |
| ----------------- | ------------------------------------------------------------ |
| LocalDate         | Represents a date (year, month, day (yyyy-MM-dd))            |
| LocalTime         | Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns)) |
| LocalDateTime     | Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)   |
| DateTimeFormatter | Formatter for displaying and parsing date-time objects       |

In Java 8, the Date class has been deprecated

### Collection API Improvements

- forEachRemaining (Consumer action): This is a default method for the Iterator. It repeats the “action” for the remaining items until all of them have been processed, or the “action” throws an exception.
- The default technique for removing items from a collection is removed (Predicate filter). This removes all objects from the collection that satisfy the supplied “filter.”
- Spliterator () This collection method returns a spliterator object that may be used to traverse the items sequentially or in parallel.
- ReplaceAll (), calculate(), and merge() are methods in the Map collection.
- The performance of the HashMap class with Key collisions has been enhanced etc.

### Java IO Improvements

- Files.list (Path dir): Returns a lazily filled stream, each element of which represents a directory entry.
- Files.lines (Path path): Reads all the lines from a stream.
- Files.find (): Returns a stream filled by a path after searching for files in the file tree rooted at a provided beginning file and many more. 
- BufferedReader.lines (): Returns a stream containing all of the elements of BufferedReader’s lines and much more

### Miscellaneous Core API Improvements

- The default and static methods for natural ordering, reverse order, and other operations have been added to the “Comparator” interface.
- The min (), max (), and sum () methods are available in the Integer, Long, and Double wrapper classes.
- The logicalAnd (), logicalOr (), and logicalXor () methods have been added to the Boolean class.
- The JDBC-ODBC Bridge has been deactivated.
- The memory space used by PermGen is no longer available.