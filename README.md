//naitikta 2210997148
package first;
import java.util.Scanner;

public class linear {
    private String nameOfEmp;
    private int empId;
    private double basicSalary;
    private double grossSalary;

    // Constructor to initialize the object with user input
    public linear() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name of Employee: ");
        this.nameOfEmp = scanner.nextLine();

        System.out.print("Enter Employee ID: ");
        this.empId = scanner.nextInt();

        System.out.print("Enter Basic Salary: ");
        this.basicSalary = scanner.nextDouble();

        // Calculate HRA, DA, and GrossSalary
        double hra = 0.25 * basicSalary;
        double da = 0.40 * basicSalary;
        this.grossSalary = basicSalary + hra + da;
    }

    // Display the Name and GrossSalary of employees whose name starts with a consonant
    public void displayConsonantEmployees() {
        if (!nameOfEmp.isEmpty() && !isVowel(nameOfEmp.charAt(0))) {
            System.out.println("Name: " + nameOfEmp + ", Gross Salary: " + grossSalary);
        }
    }

    // Display the Emp-Id and GrossSalary of Employees whose Emp-Id is between 101 and 150
    public void displayEmployeesInIdRange() {
        if (empId >= 101 && empId <= 150) {
            System.out.println("Employee ID: " + empId + ", Gross Salary: " + grossSalary);
        }
    }

    // Count the total number of Employees whose GrossSalary is less than 35000/-
    public static int countEmployeesWithSalaryLessThan(double limit, linear[] employees) {
        int count = 0;
        for (linear employee : employees) {
            if (employee != null && employee.grossSalary < limit) {
                count++;
            }
        }
        return count;
    }

    // Helper method to check if a character is a vowel
    private boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        // Assuming you have an array of Employee objects
        linear[] employees = new linear[3];

        // Initialize each employee in the array
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new linear();
        }

        // a) Display the NameOfEmp and GrossSalary of employees whose name starts with a consonant
        System.out.println("Employees whose name starts with a consonant:");
        for (linear employee : employees) {
            if (employee != null) {
                employee.displayConsonantEmployees();
            }
        }

        // b) Display the Emp-Id and GrossSalary of Employees whose Emp-Id is between 101 and 150
        System.out.println("\nEmployees with Emp-Id between 101 and 150:");
        for (linear employee : employees) {
            if (employee != null) {
                employee.displayEmployeesInIdRange();
            }
        }

        // c) Count the total number of Employees whose GrossSalary is less than 35000/-
        double limit = 35000;
        int count = countEmployeesWithSalaryLessThan(limit, employees);
        System.out.println("\nTotal number of employees with Gross Salary less than " + limit + ": " + count);
    }
}
