# Java8 Useful methods summary:

#### Comparator
Collections.sort(list, (a, b) -> a - b);

#### Print List<List<>>
`list.stream().forEach(a -> System.out.println(a));`

#### Output as list
`collect(Collectors.toList());`
