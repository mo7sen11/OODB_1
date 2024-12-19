package library;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String password;
    public String name;
    public String email;
    private LocalDate birthdate;
    private String phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<book> books = new ArrayList<>(); // Initialize the list

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false) // Use a descriptive name for the foreign key column
    private Employee employee; // Variable name changed to match standard naming conventions

    // Default Constructor
    public user() {
    }

    // Parameterized Constructor
    public user(String password, String name, String email, LocalDate birthdate, String phone) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.phone = phone;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<book> getBooks() {
        return books;
    }

    public void setBooks(List<book> books) {
        this.books = books;
    }

    // Helper Methods for Managing Relationships
    public void addBook(book book) {
        if (book != null) {
            books.add(book);
            book.setUsers(this); // Maintain bidirectional relationship
        }
    }

    public void removeBook(book book) {
        if (books != null && book != null) {
            books.remove(book);
            book.setUsers(null); // Break bidirectional relationship
        }
    }
}
