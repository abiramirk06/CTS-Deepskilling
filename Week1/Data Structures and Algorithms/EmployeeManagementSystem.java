class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId +
                ", Name: " + name +
                ", Position: " + position +
                ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {

    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Add Employee
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
            System.out.println("Employee Added");
        } else {
            System.out.println("Array Full");
        }
    }

    // Search Employee
    public Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse Employees
    public void displayEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }

            employees[count - 1] = null;
            count--;

            System.out.println("Employee Deleted");
        } else {
            System.out.println("Employee Not Found");
        }
    }

    public static void main(String[] args) {

        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        ems.addEmployee(new Employee(101, "Abirami", "Developer", 50000));
        ems.addEmployee(new Employee(102, "Priya", "Tester", 45000));
        ems.addEmployee(new Employee(103, "Kumar", "Manager", 70000));

        System.out.println("\nEmployee List:");
        ems.displayEmployees();

        System.out.println("\nSearch Result:");
        System.out.println(ems.searchEmployee(102));

        ems.deleteEmployee(102);

        System.out.println("\nAfter Deletion:");
        ems.displayEmployees();
    }
}