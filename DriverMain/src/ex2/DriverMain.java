package ex2;

import java.util.Scanner;

//Interface Taxable with defined tax rates and abstract method
interface Taxable {
 double SALES_TAX = 0.07; // 7% sales tax
 double INCOME_TAX = 0.105; // 10.5% income tax

 void calcTax();
}

//Employee class implementing Taxable
class Employee implements Taxable {
 private int empId;
 private String name;
 private double salary;
 private double incomeTax;

 public Employee(int empId, String name, double salary) {
     this.empId = empId;
     this.name = name;
     this.salary = salary;
 }

 @Override
 public void calcTax() {
     this.incomeTax = salary * INCOME_TAX; // Calculate income tax
 }

 public double getIncomeTax() {
     return incomeTax;
 }

 @Override
 public String toString() {
     return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
 }
}

//Product class implementing Taxable
class Product implements Taxable {
 private int pid;
 private double price;
 private int quantity;
 private double salesTax;

 public Product(int pid, double price, int quantity) {
     this.pid = pid;
     this.price = price;
     this.quantity = quantity;
 }

 @Override
 public void calcTax() {
     this.salesTax = price * SALES_TAX * quantity; // Calculate sales tax
 }

 public double getSalesTax() {
     return salesTax;
 }

 @Override
 public String toString() {
     return "Product [pid=" + pid + ", price=" + price + ", quantity=" + quantity + "]";
 }
}

//Main class to drive the program
public class DriverMain {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Input for Employee
     System.out.println("Enter Employee ID: ");
     int empId = scanner.nextInt();
     System.out.println("Enter Employee Name: ");
     String name = scanner.next();
     System.out.println("Enter Employee Salary: ");
     double salary = scanner.nextDouble();

     // Create Employee object and calculate tax
     Employee employee = new Employee(empId, name, salary);
     employee.calcTax();
     System.out.println(employee);
     System.out.printf("Income Tax for %s: %.2f\n", name, employee.getIncomeTax());

     // Input for Product
     System.out.println("\nEnter Product ID: ");
     int pid = scanner.nextInt();
     System.out.println("Enter Product Price: ");
     double price = scanner.nextDouble();
     System.out.println("Enter Product Quantity: ");
     int quantity = scanner.nextInt();

     // Create Product object and calculate tax
     Product product = new Product(pid, price, quantity);
     product.calcTax();
     System.out.println(product);
     System.out.printf("Sales Tax for Product ID %d: %.2f\n", pid, product.getSalesTax());

     scanner.close();
 }
}