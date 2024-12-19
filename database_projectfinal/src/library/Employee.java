package library;

import java.util.*;
import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    public String salary;
    public String phone;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<user> users = new ArrayList<>(); // Initialize the list

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<book> books = new ArrayList<>(); // Initialize the list

    // Default constructor
    public Employee() {}

    // Parameterized constructor
    public Employee(String name, String salary, String phone) {
        this.name = name;
        this.salary = salary;
        this.phone = phone;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public List<user> getUsers() {
        return users;
    }

    public void setUsers(List<user> users) {
        this.users = users;
    }

    public void addUser(user user) {
        users.add(user);
        user.setEmployee(this); // Corrected field name
    }

    public void removeUser(user user) {
        users.remove(user);
        user.setEmployee(null); // Corrected field name
    }

    public List<book> getBooks() {
        return books;
    }

    public void setBooks(List<book> books) {
        this.books = books;
    }

    public void addBook(book book) {
        books.add(book);
        book.setEmployee(this);
    }

    public void removeBook(book book) {
        books.remove(book);
        book.setEmployee(null);
    }
}
