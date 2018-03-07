

#### 1. Classic (Bad)
```java
public class Singleton {
    private static Singleton instance = null;
    ~~public~~ protected Singleton() {  //In order to prevent access from other classes out of package.
        instance = new Singleton();   
    }
    public Singleton getInstance() {
        return instance;
    }
}
```
Problem of this version:
1. If we have another class `SingletonInstantiator` in the same package:
```java
public class SingletonInstantiator {
    public SingletonInstantiator() {
        Singleton instance = new Singleton();
        Singleton anotherInstance = new Singleton();
    }
}
```
We are still able to create multiple instances.
Two possible solutions:  
..1. make Singleton constructor private and make Singleton class final.   
..2. put singleton class in explicit package, so classes in other packages cannot initiate such instances.  









