## Builder Pattern

The builder design pattern helps separating the construction of complex objects from the context where they are needed.

*Use the builder pattern when you have several variations of the same object, which needs to be created repeatedly.*

When talking about the builder design pattern, it is important to understand the concept of the **Director** and the **Builder**.

The director’s job is to invoke the building process of the builder. The builder’s job is to manage the different building procedures associated with each of the different variations of objects, 

The builder pattern consists of two classes, a sub- and super class.

### UML

![](https://i.imgur.com/9wGu2lY.png)

### Code

#### Object

```java
public class Burger {
    private String bun = "No Bun";
    private String meat = "No Meat";
    private String salad = "No Salad";
    private String cheese = "No Cheese";
    private String sauce = "No Sauce";
    public void setBun(String bun) {
        this.bun = bun;
    }
    public void setMeat(String meat) {
        this.meat = meat;
    }
    public void setSalad(String salad) {
        this.salad = salad;
    }
    public void setCheese(String cheese) {
        this.cheese = cheese;
    }
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
    public void print() {
        System.out.println(
                "Burger is finished! " + "n" +
                "Bun: " + bun +
                " - Meat: " + meat +
                " - Cheese: " + cheese +
                " - Salad: " + salad +
                " - Sauce: " + sauce);
    }
}
```

#### Builder

```java
public abstract class BurgerBuilder {
    Burger burger = new Burger();
    abstract void buildBun();
    abstract void buildMeat();
    abstract void buildSalad();
    abstract void buildCheese();
    abstract void buildSauce();
    Burger build(){
        return burger;
    };
}
```

```java
public class CheeseBurgerBuilder extends BurgerBuilder {
    @Override
    public void buildBun() {
        burger.setBun("White Bread");
    }
    @Override
    public void buildMeat() {
        burger.setMeat("Beef");
    }
    @Override
    public void buildSalad() {
        burger.setSalad("Iceberg");
    }
    @Override
    public void buildCheese() {
        burger.setCheese("American Cheese");
    }
    @Override
    public void buildSauce() {
        burger.setSauce("Secret Sauce");
    }
}
```

Similarly, there can be other sub classes of Builder class.

#### Director

```java
public class BurgerResuturant {
    private BurgerBuilder burgerBuilder;
    public void setBuilder(BurgerBuilder burgerBuilder) {
        this.burgerBuilder = burgerBuilder;
    }
    public Burger buildBurger(){
        burgerBuilder.buildBun();
        burgerBuilder.buildMeat();
        burgerBuilder.buildSalad();
        burgerBuilder.buildCheese();
        burgerBuilder.buildSauce();
        return burgerBuilder.build();
    }
}
```

#### How To Use The Builder Pattern

```java
public class Main {
    public static void main(String[] args) {
        BurgerResuturant burgerRestaurant = new BurgerRestaurant();
        burgerRestaurant.setBuilder(new CheeseBurgerBuidler());
        buildBurger(burgerRestaurant);
        burgerRestaurant.setBuilder(new VeganBurgerBuidler());
        buildBurger(burgerRestaurant);
    }
    private static void buildBurger(BurgerRestaurant burgerRestaurant) {
        Burger burger = burgerRestaurant.buildBurger();
        burger.print();
    }
}
```



### Reference

- http://integu.net/builder-pattern/