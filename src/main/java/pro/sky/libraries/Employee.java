package pro.sky.libraries;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private String firsName;
    private String lastName;

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee(String firsName, String lastName) {
        this.firsName = StringUtils.capitalize(firsName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firsName, employee.firsName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firsName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
