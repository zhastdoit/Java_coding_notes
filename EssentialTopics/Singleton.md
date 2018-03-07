
Singleton is a widely discussed and used Design Pattern. It's core idea is to "make the class itself responsible to control its instantiation that is intantiated only once".

## Why we need Singleton?  

> Sometimes it's appropriate to have exactly one instance of a class: window managers, print spoolers, and filesystems are prototypical examples. Typically, those types of objects—known as singletons—are accessed by disparate objects throughout a software system, and therefore require a global point of access. Of course, just when you're certain you will never need more than one instance, it's a good bet you'll change your mind. [JavaWorld](https://www.javaworld.com/article/2073352/core-java/simply-singleton.html)

## The evolution

#### v0.1 Classic Singleton with Factory Method

```java
public class Singleton {
    private static Singleton instance = null;
    protected Singleton() {  //In order to prevent access from other classes out of package, use protected instead of public
        instance = new Singleton();   
    }
    public Singleton getInstance() {
        return instance;
    }
}
```
Cons:
If we have another class `SingletonInstantiator` in the same package:
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
  * make Singleton constructor private and make Singleton class final. -> The constructor will not be accessed by the outer classes so we will need to use a static method to help it init the instance (because oinly itself can access its constructor).   
  * put singleton class in explicit package, so classes in other packages cannot initiate such instances.  

#### V1.0 Singleton with private constructor and static method

Continue the first solution above by making the Singleton constructor private: 
```java
public class Singleton {
    private static Singleton singleton = null;
    private Singleton() {//Empty}
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton= new Singleton();
        }
        return singleton;
    }
```
Cons: Static methods and functions are global. In the Multi-Thread circumstances, all the global sharing will be dangerous: When multiple threads are calling getInstance() simultaneously, there could be race conditions (multiple processes pass the `singleton == null` check) and result in creating multiple Singleton instances and it would be very likely to cause memory leak.

#### v1.5 Singleton with synchronized

```java
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}
    public static Singleton getInstance() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                instance = new singleton;
            }
        }
    }
}
```
Cons: The processes that pass the null check will serially init new instances. Does not solve the problem.

#### v1.8 Singleton with synchronized for all calls

```java
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}
    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if(singleton == null) {
                instance = new singleton;
            }
        }
        return instance;
    }
}
```
Cons: Although only one initialization could happen, but to reach this purpose, all the other threads that calling getInstance() at this time will also go through the synchronization, which is quite unnecessary.  

#### v1.9 Singleton With Lazy Initialization (with double-checked locking)

```java
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}
    public static Singleton getInstance() {
        if(instance == null) { 
            synchronized (Singleton.class) {
                if(instance == null) { 
                    instance = new Singleton();
                } 
            }
        }
        return instance;
    }
}
```
Pros: Sync the threads only when the instance is not initiallized. And only one instance wil be created.
Cons: For `singleton = new Singleton()`, this operation is not atomic - In JVM, it:
a) allocate memory for singleton,  
b) call constructor to init singleton and create instance,  
c) pointing the singleton object to the memory space that allocated  
Only when (c) is done we will get `instance == null` as false. When a, b, c are done in order, it is fine; However, JVM could do (c) first then do (b). Hence if there is a process called getInstance() just after (c) is finished, it will get null since (b) is not done yet. 

#### v2.0  Singleton With Lazy Initialization and Volatile variable [with double check] (Good to use after JDK 1.5)

```java
public class Singleton {
    private volatile static Singleton instance = null; //Add volatile. Available to use after JDK 1.5
    private Singleton() {}
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                } 
            }
        }
        return instance;
    }
}
```
Pros:
1. Using `volatile` will prohibit the JVM command reordering, 
2. This instance variable will only exist on memory - it does not have copies in threads.

## Better & easier Singleton

#### Get rid of the synchronized, using volatile only

```java
public class Singleton {
    private volatile static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}
```
Cons: New Singleton() will be loaded once the class is loaded - even before getInstance() is called. This could be a issue when we want this Singleton be initialize using some other resources, and control when it actually init (init it by ourselves, not the class loader).

#### Inner Class - Simpler (recommendated) 

```java
public class Singleton {
    private static class SingletonHolder {
        priate static final Singleton INSTANCE = new Singleton();
    }
    private Singleton() {}
    public static final getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```
Pros: Singleton will only be created when getInstance() is called.

## The ideal Singleton

#### enum (highly recommendated)

```java
public enum Singleton {
    INSTANCE;
    private Singleton() {} // can ignore this line.
    public void method() {}
}
```
Pros: Enum is default to be thread-safe. Access through `Singleton.INSTANCE` (Will init when first calling it, similar to something like : 
```java
public final class Singleton {
    public final static Singleton INSTANCE = new Singleton(); 
}
```
)



#### References:  
[深入浅出单实例Singleton设计模式](http://blog.csdn.net/haoel/article/details/4028232)  
[JSR-133: JavaTM Memory Model and Thread Specification](http://www.cs.umd.edu/~pugh/java/memoryModel/jsr133.pdf)  
[Java并发：volatile内存可见性和指令重排](http://blog.csdn.net/jiyiqinlovexx/article/details/50989328)  
