

//Main Function arguments
public class fall {
  public static void main(String[] args){
    if((args==null) || (args.length!=1)){
      throw new IllegalArgumentException("Argument are required");
    }
    if("Foo".quals(args[0]){
      //TODO
    }
  }

 //Check class type
  private void returnADog(Animal animal){
       if(animal instanceOf Dog){  
         Dog dog = animal;
       }
 }
       

 //Always use protected for abstract class' constructor
 public abstract class Employee {
  private final String name;
  private final double salary;
//   protected Employee(){
//     this("".0d);
//   }  Use this or use the super in Manager class
  protected Employee(String name, double salary){
    this.name = name;
    this.salary = salary;
  }
 }
       
       
 //Use this in abstract class, or use super when extends an abstract class
 private final Manager extends Employee{
  public Manager(String name, double salatry, Employee[] directReports){
    super(name, salary);
    this.directReports = directReports;
  }
 }
       
 //Avoid duplication lines by end up things in one constructor -> in this way, we just need to check things in one place.
 public Manager(String name, Employee[] directReports){
    this(name, DEFAULT_SALARY, direct);
 }

 //Always add @override when overrides. Because if @Override, the compiler knows, and the method name and params must override from the extended method.
 
       
// 
@override public boolean equals(object obj){
  if (this == obj) {
    return true;
  } 
  if((obj == null) || (getclass() != obj.getClass()){
    return false;
  }
  // name is from super
  // Cast it
  Manager manager = (Manager) obj;
  // Do the check
  return(getName() == null ? manager.getName() == null : getName().equals(manager.getName() && (getSalary() == manager.getSalary()));
}
 
         
 @Override public int hashCode(){
   int prime =31;
   int result = (getName() == null ? O : getName().hashCode());
   result = prime * hash + (Double.valueOf(getSalary()).hashCode()); //in (): If primitive, depend on primitive. Cannot hash double to an int. For int to double, we can just "add" it
 }
         
         
 private void boxingExample(){
   int value = 1;
   //Integer valueAsObject = value;
   
   int foo = valueAsObject.intValue();  // works for all other types.
   double bar =1d;
   Double barValue = null; //Can be null... SO can be problematic as the following:
   
   add(1d, 2d);//fine
   add(null, 2d);//Trouble!  "No pointer Exception."
 }
 private double add(Double foo, Double bar){
    return(foo + bar);
 }
         

/// Oct 4
//Use @override to get rid of typo in method names and params 
        
public class Foo extends Bar implements BookReader{
  @Override public void read(Book book){
  
  }
  @Override public void read(String test){
    super.read(text);
    System.out.println("Howdy:" + test);
  }
}
//Override is override and implement. 
         
public class Bar   {
   public static void main(){
    //Foo reader = new Foo();
     //Reader reader = new Foo(); x
     //Bar reader = new Foo(); y 2 line output
     //Bar reader = new bar(); y 1 line output
     reader.read("Prof!");  //List<> l = new LinkedList<>();
   }
   public void read(String test){
      System.out.println("Hello" + test);
   }
}
         
 //List<String> l = new ArrayList<>()
 //When compile, it consider l as List. when run, it consider l as ArrayList
          
         
         
         
         
         
