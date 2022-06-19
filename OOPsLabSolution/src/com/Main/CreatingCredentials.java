package com.Main;

import java.util.Scanner;

import com.Model.Employee;
import com.Service.CredentialService;

public class CreatingCredentials {
	public static void main(String[] args) {

		String tempFirstName;
		String tempLastName;
		int temp;
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Hello, Please enter required details to create credentials for new hires");
		System.out.print("Enter First Name of Candidate : ");
		tempFirstName = sc.next();
		System.out.print("Enter Last Name of Candidate : ");
		tempLastName = sc.next();
		Employee emp = new Employee(tempFirstName, tempLastName);
		emp.setCompany("Amazon");
		System.out.println();
		System.out.println(
				"Please enter the department form the following\n1. Technical\n2. Admin\n3. Human Resource\n4. Legal");

		System.out.println();
		do {
			temp = sc.nextInt();
			switch (temp) {
			case 1:
				emp.setDepartment("Technical");
				flag = true;
				break;
			case 2:
				emp.setDepartment("Admin");
				flag = true;
				break;
			case 3:
				emp.setDepartment("Human Resource");
				flag = true;
				break;
			case 4:
				emp.setDepartment("Legal");
				flag = true;
				break;
			default:
				System.out.println("please select right option");
				break;
			}
		} while (!flag);
		CredentialService.generateEmailAddress(emp);
		CredentialService.generatePassword(emp);
		System.out.println("\n");
		CredentialService.showCredentials(emp);
	}

}
