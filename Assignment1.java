import java.util.Scanner;

class EMPLOYEE {
    private String NameOfEmp;
    private int EmpId;
    private double BasicSalary;
    private double GrossSalary;

    // Constructor to initialize data members
    public EMPLOYEE(String nameOfEmp, int empId, double basicSalary) {
        NameOfEmp = nameOfEmp;
        EmpId = empId;
        BasicSalary = basicSalary;
        calculateGrossSalary();
    }

    // Method to calculate GrossSalary
    private void calculateGrossSalary() {
        double HRA = 0.25 * BasicSalary;
        double DA = 0.40 * BasicSalary;
        GrossSalary = BasicSalary + HRA + DA;
    }

    // Getter method for GrossSalary
    public double getGrossSalary() {
        return GrossSalary;
    }

    // Getter method for NameOfEmp
    public String getNameOfEmp() {
        return NameOfEmp;
    }

    // Getter method for EmpId
    public int getEmpId() {
        return EmpId;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EMPLOYEE[] employees = new EMPLOYEE[5]; // Assuming 5 employees for demonstration

        // Input employee details
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Employee ID: ");
            int id = scanner.nextInt();
            System.out.print("Basic Salary: ");
            double basicSalary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            employees[i] = new EMPLOYEE(name, id, basicSalary);
        }

        // Query (a)
        System.out.println("\nEmployees whose name starts with a consonant:");
        for (EMPLOYEE emp : employees) {
            if (!isVowel(emp.getNameOfEmp().charAt(0))) {
                System.out.println("Name: " + emp.getNameOfEmp() + ", Gross Salary: " + emp.getGrossSalary());
            }
        }

        // Query (b)
        System.out.println("\nEmployees whose EmpId is between 101 and 150:");
        for (EMPLOYEE emp : employees) {
            if (emp.getEmpId() >= 101 && emp.getEmpId() <= 150) {
                System.out.println("Emp ID: " + emp.getEmpId() + ", Gross Salary: " + emp.getGrossSalary());
            }
        }

        // Query (c)
        int count = 0;
        for (EMPLOYEE emp : employees) {
            if (emp.getGrossSalary() < 35000) {
                count++;
            }
        }
        System.out.println("\nTotal number of employees whose Gross Salary is less than 35000: " + count);
    }

    // Utility method to check if a character is a vowel
    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}