import java.util.*;

/**
 * 
 */
class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

// Actual Service
class EmployeeDetailsService {
    List<Employee> employees;

    EmployeeDetailsService() {
        employees = new ArrayList<>();
        employees.add(new Employee("employee1", 100));
        employees.add(new Employee("employee2", 20));
        employees.add(new Employee("employee3", 500));
        employees.add(new Employee("employee4", 10));
    }

    Employee getEmployeeDetails(String employeeName) {
        for (Employee e : employees) {
            if (e.name == employeeName) {
                return e;
            }
        }
        return null;
    }
}

// Proxy 1 - cache proxy
class EmployeeDetailsCacheProxy {
    Map<String, Employee> employeeCache;

    EmployeeDetailsCacheProxy() {
        employeeCache = new HashMap<>();
    }

    Employee getEmployeeDetails(String employeeName) {
        if (employeeCache.containsKey(employeeName)) {
            System.out.println("retreived from cache...");
            return employeeCache.get(employeeName);
        }
        EmployeeDetailsService employeeDetailsService = new EmployeeDetailsService();
        Employee employeeDetails = employeeDetailsService.getEmployeeDetails(employeeName);
        addToCache(employeeDetails);
        return employeeDetails;
    }

    void addToCache(Employee e) {
        employeeCache.put(e.name, e);
    }
}

// Proxy 2 - access control proxy
class AuthProxy {
    EmployeeDetailsCacheProxy employeeDetailsCacheProxy = new EmployeeDetailsCacheProxy();

    public Employee getEmployeeDetails(String authPasscode, String employeeName) {
        if (authPasscode == "PASS") {
            return employeeDetailsCacheProxy.getEmployeeDetails(employeeName);
        }
        return null;
    }
}

// start of client code
public class ProxyExample {
    public static void main(String[] args) throws java.lang.Exception {
        AuthProxy authProxy = new AuthProxy();
        Employee e = authProxy.getEmployeeDetails("PASS", "employee1");
        System.out.println("name: " + e.name + " salary: " + e.salary);
        Employee e1 = authProxy.getEmployeeDetails("PASS", "employee1");
        System.out.println("name: " + e1.name + " salary: " + e1.salary);
    }
}
// end of client code

// OUTPUT
// name: employee1 salary: 100
// retreived from cache...
// name: employee1 salary: 100