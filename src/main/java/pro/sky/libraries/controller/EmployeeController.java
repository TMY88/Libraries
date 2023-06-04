package pro.sky.libraries.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.libraries.Employee;
import pro.sky.libraries.service.EmployeeService;
import pro.sky.libraries.validator.EmployeeValidator;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public ResponseEntity<Employee> addEmployee(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        if (EmployeeValidator.validate(firstName, lastName)) {
            return ResponseEntity.ok(employeeService.addEmployee(firstName, lastName));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);

    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping
    public Map<String, Employee> getAllEmployee() {
        return employeeService.getAllEmployees();

    }
}
