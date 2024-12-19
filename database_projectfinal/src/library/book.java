package library;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class book { // Renamed to 'Book' for proper class naming
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String author;
    private Boolean isAvailable; // Renamed to camelCase

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false) // Correct foreign key column name
    private Employee employee; // Renamed to 'employee' for consistency

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL) // Changed to ManyToMany
    private List<user> users = new ArrayList<>(); // Proper initialization

    // Default constructor
    public book() {
    }

    // Parameterized constructor
    public book(String title, String author, Boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<user> getUsers() {
        return users;
    }

  

    // Helper Methods for Managing Users
    public void addUser(user user) {
        if (user != null && !users.contains(user)) {
            users.add(user);
            user.getBooks().add(this); // Maintain bidirectional relationship
        }
    }

    public void removeUser(user user) {
        if (user != null && users.contains(user)) {
            users.remove(user);
            user.getBooks().remove(this); // Break bidirectional relationship
        }
    }

	public void setUsers(user user) {
		this.users = users;
		
	}
}

