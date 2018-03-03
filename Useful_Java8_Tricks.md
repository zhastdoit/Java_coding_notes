# Java8 Useful methods summary:

#### Comparator
```java
Collections.sort(list, (a, b) -> a - b);
```

#### Print List<List<>>
```java
list.stream().forEach(a -> System.out.println(a));
```

#### Output as list
```java
collect(Collectors.toList());
```

#### Filter
```java
Stream<Integer> number = Stream.of(1, 2, 3, 4, 5);  
List<Integer> result = number.filter(a -> a!= 2).collect(Collectors.toList());  
result.forEach(a -> System.out.println(a));
```
