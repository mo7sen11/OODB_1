package library;

import java.time.LocalDate;
import javax.persistence.*;
import java.util.*;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();

        try {
            // Correct query
        	TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        	List<Employee> Employees = query.getResultList();

            if (Employees == null || Employees.isEmpty()) {
                System.out.println("No users found.");
                return;
            }

            for (Employee e: Employees) {
                if (e == null) {
                    System.out.println("Encountered a null employee entry. Skipping...");
                    continue;
                }

                System.out.println("Employee: " + e.getName());
                System.out.println("salary: " + e.getSalary());
                System.out.println("PHONE:" + e.getPhone());

                for (book b : e.getBooks()) {
                    System.out.println("  book: " + b.getTitle());
                  
                    
                    for (user u: e.getUsers()) {
                        System.out.println("  User: " + u.getName());
                        System.out.println("    phone: " + u.getPhone());
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        em.close();
        emf.close();
        }
    }
}
