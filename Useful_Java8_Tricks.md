# Java8 Useful methods summary:

#### Comparator
`Collections.sort(list, (a, b) -> a - b);`

#### Print List<List<>>
`list.stream().forEach(a -> System.out.println(a));`

#### Output as list
`collect(Collectors.toList());`

#### Filter
`Stream<Integer> number = Stream.of(1, 2, 3, 4, 5);  
List<Integer> result2 = number.filter(x -> x!= 3).collect(Collectors.toList());  
result2.forEach(x -> System.out.println(x));`
