package com.te.hibernatePractice;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentManagement sm = new StudentManagement(sc);
		for(;;) {
			System.out.println("1.insert\n2.display\n3.displayparticular\n4.update\n5.delete\n6.exit");
			System.out.println("Enter the choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				sm.insert();
				
				break;
			case 2: 
				sm.display();
				break;
			case 3:
				sm.displayParticular();
				break;
			case 4:
			sm.update();
			break;
			case 5:
				sm.delete();
				break;
			case 6: 
             System.exit(0);
             break;
			default:
				try {
					throw new Exception1("INVALID INPUT");
					
				} catch (Exception1 e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			
		}
	}

}