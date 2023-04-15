package packages;

import java.util.ArrayList;
import java.util.Scanner;

public class Agency {

	static Scanner scan = new Scanner(System.in);

	static ArrayList<Account> accounts;

	public static void main(String[] args) {

		accounts = new ArrayList<Account>();
		operations();

	}

	public static void operations() {

		System.out.println("--------------------------------------");
		System.out.println("----------welcome sr.-----------------");
		System.out.println("--------------------------------------");
		System.out.println("----------select a option-------------");
		System.out.println("--------------------------------------");
		System.out.println(" | option 1 - open a account ");
		System.out.println(" | option 2 - deposit ");
		System.out.println(" | option 3 - withdraw ");
		System.out.println(" | option 4 - transfer ");
		System.out.println(" | option 5 - list ");
		System.out.println(" | option 6 - exit ");

		int operation = scan.nextInt();

		switch (operation) {
		case 1:
			openAccount();
			break;
		}

		switch (operation) {
		case 2:
			deposit();
			break;
		}

		switch (operation) {
		case 3:
			withdraw();
			break;
		}

		switch (operation) {
		case 4:
			transfer();
			break;
		}
		switch (operation) {
		case 5:
			ListAccounts();
			break;
		}

		switch (operation) {
		case 6:
			System.out.println("obg por usar nosso sistema");
			System.exit(0);

		default:
			System.out.println("invalid opetion");
			operations();
			break;

		}
	}

	public static void openAccount() {

		System.out.println("Name");
		String name = scan.next();

		System.out.println("Cpf");
		String cpf = scan.next();

		System.out.println("Email");
		String email = scan.next();

		System.out.println("Phone");
		String phone = scan.next();

		Users users = new Users(name, cpf, email, phone);

		Account account = new Account(users); // users

		accounts.add(account);

		System.out.println("account create sucessfull");

		operations();

	}

	private static Account findAccount(int numberAccount) {
		Account account = null;
		if (accounts.size() > 0) {
			for (Account c : accounts) {
				if (c.getNumberAccount() == numberAccount) {
					account = c;

			}
		  }
		}
		return account;
	}

	public static void deposit() {

		System.out.println("insert account number ");

		int accountNumber = scan.nextInt();

		Account account = findAccount(accountNumber);

		if (account != null) {
			System.out.println("what is the deposit amount");
			Double depositValue = scan.nextDouble();
			account.deposity(depositValue);
			System.out.println("deposit sucessfull");
		} else {
			System.out.println("account not found");
		}
		operations();
	}

	public static void withdraw() {
		System.out.println("insert account number ");
		int accountNumber = scan.nextInt();
		Account account = findAccount(accountNumber);

		if (account != null) {
			System.out.println("what is the withdraw amount");
			Double withdrawValue = scan.nextDouble();
			account.withdraw(withdrawValue);
			System.out.println("withdraw sucessfull");
		} else {
			System.out.println("account not found");
		}
		operations();
	}

	public static void transfer() {
		System.out.println("insert account number remetente ");
		int numberAccountRemetente = scan.nextInt();
		Account accountRemetente = findAccount(numberAccountRemetente);

		if (accountRemetente != null) {
			System.out.println("insert the number account destinatario");
			int numberAccountDestinatario = scan.nextInt();
			Account accountDestinatario = findAccount(numberAccountDestinatario);
			if (accountDestinatario != null) {
				System.out.println("insert  the value transfer");
				Double value = scan.nextDouble();

				accountRemetente.transfer(accountDestinatario, value);
			} else {
				System.out.println("account not found");
			}
		} else {
			System.out.println("account for transfer not found");

		}
		operations();
	}

	public static void ListAccounts() {

		if (accounts.size() > 0) {
			for (Account account : accounts) {
				System.out.println(account);
			}
		} else {
			System.out.println("not register");

		}
		operations();
	}
}
