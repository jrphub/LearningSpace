## Builder Pattern

The builder design pattern helps separating the construction of complex objects from the context where they are needed.

*Use the builder pattern when you have several variations of the same object, which needs to be created repeatedly.*

When talking about the builder design pattern, it is important to understand the concept of the **Director** and the **Builder**.

The director’s job is to invoke the building process of the builder. The builder’s job is to manage the different building procedures associated with each of the different variations of objects, 

The builder pattern consists of two classes, a sub- and super class.

### UML

![](https://i.imgur.com/9wGu2lY.png)

### Code

Please refer ```com/designpattern/creational/builder/ex2```

### Reference

- http://integu.net/builder-pattern/