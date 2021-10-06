package com.te.hibernatePractice;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentManagement {
	public Scanner sc;

	public StudentManagement(Scanner sc) {
		this.sc = sc;
	}

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	public void insert() {
		System.out.println("Enter the roll_no");
		int id = sc.nextInt();
		System.out.println("Enter the name");
		String name = sc.next();
		System.out.println("Enter the phn_no");
		long phn_no = sc.nextLong();
		System.out.println("Enter the standard");
		String standard = sc.next();

		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			StudentJpql student = new StudentJpql();
			 student.setRoll_no(id);
			student.setName(name);
			student.setPhn_no(phn_no);
			student.setStandard(standard);
			manager.persist(student);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (factory != null || manager != null) {
				factory.close();
				manager.close();
			}
		}

	}

	public void display() {
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			String query = "from StudentJpql";
			Query query2 = manager.createQuery(query);
			List<StudentJpql> list = query2.getResultList();
			for (StudentJpql studentJpql : list) {
				System.out.println(studentJpql);

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (factory != null || manager != null) {
				factory.close();
				manager.close();
			}
		}

	}

	public void displayParticular() {
		System.out.println("Enter the id");
		int id = sc.nextInt();

		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String query = "from StudentJpql where id = :id";
			Query query2 = manager.createQuery(query);
			query2.setParameter("id", id);
			StudentJpql std = (StudentJpql) query2.getSingleResult();
			System.out.println(std);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null || manager != null) {
				factory.close();
				manager.close();
			}
		}

	}

	public void update() {
		factory = Persistence.createEntityManagerFactory("emp");

		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		System.out.println("Enter the id");
		int id = sc.nextInt();
		StudentJpql find = manager.find(StudentJpql.class, id);
		String name = null;
		String std = null;
		try {
			
			System.out.println("Do you want to update your name y/n");
			String str = sc.next();
			if (str.equalsIgnoreCase("y")) {
				System.out.println("Enter the name");
				name = sc.next();
			} else {
				name = find.getName();
			}
			System.out.println("Do you want to update your std y/n");
			String str1 = sc.next();
			if (str1.equalsIgnoreCase("y")) {
				System.out.println("Enter the STD");
				std = sc.next();
			} else {
				std = find.getName();
			}
			String update = "update StudentJpql set name=:name , standard = :std where id =:id";
			Query query = manager.createQuery(update);
			query.setParameter("name", name);
			query.setParameter("std", std);
			query.setParameter("id", id);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				System.out.println("updated");

			} else {
				System.out.println("not updated");
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (factory != null || manager != null) {
				factory.close();
				manager.close();
			}
		}

	}

	public void delete() {
		System.out.println("Enter the id");
		int id = sc.nextInt();

		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String delete = "delete from StudentJpql where id = :id";
			Query query = manager.createQuery(delete);
			query.setParameter("id", id);
			int result = query.executeUpdate();
			if (result > 0) {
				System.out.println("deleted");

			} else {
				System.out.println("not deleted");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (factory != null || manager != null) {
				factory.close();
				manager.close();
			}
		}

	}

}