# Java8 Useful methods summary:

#### Comparator 
Lambda Expression
```java
Collections.sort(list, (a, b) -> a - b);
```

#### Print List<List<>>
stream API
```java
list.stream().forEach(a -> System.out.println(a));
```
Better:
```java
list.stream().forEach(System.out::println);
```

#### Output as list
```java
list.stream().collect(Collectors.toList());
```

#### Filter
```java
Stream<Integer> number = Stream.of(1, 2, 3, 4, 5);  
List<Integer> result = number.filter(a -> a!= 2).collect(Collectors.toList());  
result.forEach(a -> System.out.println(a));
```
