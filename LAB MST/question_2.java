import java.util.HashMap;
import java.util.Map;

class IdNotFoundException extends Exception {
    public IdNotFoundException(String message) {
        super(message);
    }
}
class Employee {
    private HashMap<Integer, String> employees = new HashMap<>();

    public void addEmployee(Integer id, String name) {
        employees.put(id, name);
    }
    public void retrieveEmployee(Integer id) throws IdNotFoundException {
        if (employees.containsKey(id)) {
            System.out.println("Name for ID " + id + ": " + employees.get(id));
        } else {
            throw new IdNotFoundException("Employee ID not found!");
        }
    }
    public void display() {
        System.out.print("Employee Map: ");
        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println();
    }
}

public class question_2 {
    public static void main(String[] args) {
        Employee emp = new Employee();

        System.out.println("Adding employees...");
        emp.addEmployee(101, "John");
        emp.addEmployee(102, "Jane");
        emp.addEmployee(103, "Mike");
        emp.display();
        try {
            emp.retrieveEmployee(102);
            emp.retrieveEmployee(999);
        } catch (IdNotFoundException e) {
            System.out.println("Name for ID 999: Error: " + e.getMessage());
        }
    }
}
