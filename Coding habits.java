

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
 
