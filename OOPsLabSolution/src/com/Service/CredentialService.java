package com.Service;

import java.util.Random;

import com.Model.Employee;

public class CredentialService {

	public static void generatePassword(Employee temp) {
		String cLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialChar = "!@#$";
		String number = "1234567890";
		String cChars = cLetters + lLetters + specialChar + number;

		Random random = new Random();
		char[] password = new char[8];

		password[0] = cLetters.charAt(random.nextInt(26));
		password[1] = lLetters.charAt(random.nextInt(26));
		password[2] = specialChar.charAt(random.nextInt(4));
		password[3] = number.charAt(random.nextInt(10));
		for (int i = 4; i < 8; i++) {
			password[i] = cChars.charAt(random.nextInt(cChars.length()));
		}
		String newPass = new String(password);
		temp.setPassword(newPass);

	}

	public static void generateEmailAddress(Employee temp) {
		String depart = temp.getDepartment();
		if (depart.equals("Technical")) {
			depart = "tech";
		} else if (depart.equals("Admin")) {
			depart = "admin";
		} else if (depart.equals("Human Resource")) {
			depart = "hr";
		} else {
			depart = "Legal";
		}
		String email = temp.getFirstName() + temp.getLastName() + "@";
		email = email + depart + "." + temp.getCompany() + ".com";
		temp.setEmailAdress(email.toLowerCase());
	}

	public static void showCredentials(Employee temp) {
		System.out.println("Dear " + temp.getFirstName() + ", your generated credentials are as follows");
		System.out.println("Email ---> " + temp.getEmailAdress());
		System.out.println("Password ---> " + temp.getPassword());

	}
}
