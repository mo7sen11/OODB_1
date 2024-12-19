package library;
import javax.persistence.*;
import java.util.*;

public class database {
	// add
		public static void adduser(user u) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
		public static void addbook(book b) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
		public static void addEmployee(Employee e) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
		public static user getuserbyid(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			user u = em.find(user.class, id);
			em.close();
			emf.close();
			return u;
		}
		public static Employee getEmployeebyid(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			Employee e= em.find(Employee.class, id);
			em.close();
			emf.close();
			return  e;
		}
		public static book getbookbyid(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			book b= em.find(book.class, id);
			em.close();
			emf.close();
			return b;
		}
		public static void deleteUser(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			user u = em.find(user.class, id);
			if (u != null) {
				em.getTransaction().begin();
				em.remove(u);
				System.out.printf("SUCCESS: user with id: \"%d\" deleted successfully.", id);
				em.getTransaction().commit();
			} else {

				System.out.printf("ERROR: There's no user with id : \"%d\" in the database.", id);
			}
			em.close();
			emf.close();
		}
		public static void deletebook(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			book b = em.find(book.class, id);
			if (b!= null) {
				em.getTransaction().begin();
				em.remove(b);
				System.out.printf("SUCCESS: book with id: \"%d\" deleted successfully.", id);
				em.getTransaction().commit();
			} else {

				System.out.printf("ERROR: There's no book with id : \"%d\" in the database.", id);
			}
			em.close();
			emf.close();

		}
		public static void deleteEmployee(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			Employee e= em.find(Employee.class, id);
			if (e!= null) {
				em.getTransaction().begin();
				em.remove(e);
				System.out.printf("SUCCESS: Employee with id: \"%d\" deleted successfully.", id);
				em.getTransaction().commit();
			} else {

				System.out.printf("ERROR: There's no Employee with id : \"%d\" in the database.", id);
			}
			em.close();
			emf.close();

		}
		public static void updateUser(int id, String newName, String newphone) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			user u = em.find(user.class, id);

			try {
				if (u != null) {
					if (newName != null) {
						em.getTransaction().begin();
						u.setName(newName);
						em.getTransaction().commit();
						if (newphone != null) {
							em.getTransaction().begin();
							u.setPhone(newphone);
							em.getTransaction().commit();
						}
					}
				}
			} catch (Exception e) {

				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();

				}
				e.printStackTrace();
	} finally {
				em.close();
				emf.close();

			}

		}

		public static void updatebook(int id, String newtitle ,String newauthor,Boolean newisavailable ) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			book b = em.find(book.class, id);

			try {
				if (b != null) {
					if (newtitle != null) {
						em.getTransaction().begin();
						b.setTitle(newtitle);
						em.getTransaction().commit();

					}
					if (newauthor != null) {
						em.getTransaction().begin();
						b.setAuthor(newauthor);
						em.getTransaction().commit();

					}
					if (newisavailable != null) {
						em.getTransaction().begin();
						b.setIsAvailable(newisavailable);
						em.getTransaction().commit();

					}


				}
			} catch (Exception e) {

	if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();

				}
				e.printStackTrace();

			} finally {
				em.close();
				emf.close();

			}

		}

		public static void updateemployee(int id, String newname ,String newphone,String newsalary ) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
			EntityManager em = emf.createEntityManager();
			Employee E = em.find(Employee.class, id);

			try {
				if (E != null) {
					if (newname != null) {
						em.getTransaction().begin();
						E.setName(newname);
						em.getTransaction().commit();

					}
					if (newphone != null) {
						em.getTransaction().begin();
						E.setPhone(newphone);
						em.getTransaction().commit();

					}
					if (newsalary != null) {
						em.getTransaction().begin();
						E.setSalary(newsalary);
						em.getTransaction().commit();

					}


				}
			} catch (Exception e) {

	if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();

				}
				e.printStackTrace();

			} finally {
				em.close();
				emf.close();

			}

		}
}

