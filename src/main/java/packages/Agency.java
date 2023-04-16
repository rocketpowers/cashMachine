package packages;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Agency {

	//static Scanner scan = new Scanner(System.in);
	 

	static ArrayList<Account> accounts;

	public static void main(String[] args) {

		accounts = new ArrayList<Account>();
		operations();

	}

	public static void operations() {
		
		int operation = Integer.parseInt(JOptionPane.showInputDialog("--- select operation ---"+
		
		" option 1 - open a account "+
		" option 2 - deposit "+
	    " option 3 - withdraw "+
		" option 4 - transfer "+
	    " option 5 - list " +
		" option 6 - exit "));

		//System.out.println("--------------------------------------");
		//System.out.println("----------welcome sr.-----------------");
		//System.out.println("--------------------------------------");
		//System.out.println("----------select a option-------------"); 
		//System.out.println("--------------------------------------");
		//System.out.println(" | option 1 - open a account ");
		//System.out.println(" | option 2 - deposit ");
    	//System.out.println(" | option 3 - withdraw ");
		//System.out.println(" | option 4 - transfer ");
		//System.out.println(" | option 5 - list ");
		//System.out.println(" | option 6 - exit ");

		//int operation = scan.nextInt();

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
			JOptionPane.showMessageDialog(null, "thanks for use your system sr.");
		//	System.out.println("obg por usar nosso sistema");
			System.exit(0);

		default:
			JOptionPane.showMessageDialog(null, "invalid option");
			//System.out.println("invalid opetion");
			operations();
			break;

		}
	}

	public static void openAccount() {
		
		Users users = new Users();
		
		users.setName(JOptionPane.showInputDialog("Name"));
		users.setCpf(JOptionPane.showInputDialog("cpf"));
		users.setEmail(JOptionPane.showInputDialog("email"));
		users.setPhone(JOptionPane.showInputDialog("phone"));
		
		//String name = scan.next();

		//System.out.println("Cpf");
		//String cpf = scan.next();

	//	System.out.println("Email");
		//String email = scan.next();

		//System.out.println("Phone");
	//	String phone = scan.next();

		//Users users = new Users(name, cpf, email, phone);

		Account account = new Account(users); // users

		accounts.add(account);
		JOptionPane.showInputDialog("account create sucessfull");
		//System.out.println("account create sucessfull");

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
		
		
		int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("insert account number for deposit"));

		//System.out.println("insert account number ");
		//int accountNumber = scan.nextInt();

		Account account = findAccount(accountNumber);

		if (account != null) {
			//System.out.println("what is the deposit amount");
		//	Double depositValue = scan.nextDouble();
			Double depositValue = Double.parseDouble(JOptionPane.showInputDialog("insert account number for deposit"));
			account.deposity(depositValue);
			System.out.println("deposit sucessfull");
		} else {
			JOptionPane.showInputDialog(null, "account not found");
			//System.out.println("account not found");
		}
		operations();
	}
//achei q fiquei meio estranho a logoca do metodo, evolui para opcao valida pos login apenas
	public static void withdraw() {
		int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("insert number account for withdraw"));
		//System.out.println("insert account number ");
		//int accountNumber = scan.nextInt();
		Account account = findAccount(accountNumber);

		if (account != null) {
			Double withDrawValue = Double.parseDouble(JOptionPane.showInputDialog("insert the value withdraw"));
			//System.out.println("what is the withdraw amount");
			//Double withdrawValue = scan.nextDouble();
			account.withdraw(withDrawValue);
			
			//System.out.println("withdraw sucessfull");
		} else {
			JOptionPane.showInputDialog(null, "account not found");
			//System.out.println("account not found");
		}
		operations();
	}

	public static void transfer() {
		
		int numberAccountRemetente=Integer.parseInt(JOptionPane.showInputDialog("insert account number remetente"));
	//	System.out.println("insert account number remetente ");
		//int numberAccountRemetente = scan.nextInt();
		Account accountRemetente = findAccount(numberAccountRemetente);

		if (accountRemetente != null) {
			
			int numberAccountDestinatario=Integer.parseInt(JOptionPane.showInputDialog("insert the number account destinatario"));
		//	System.out.println("insert the number account destinatario");
			//int numberAccountDestinatario = scan.nextInt();
			
			Account accountDestinatario = findAccount(numberAccountDestinatario);
			if (accountDestinatario != null) {
				
				Double value = Double.parseDouble(JOptionPane.showInputDialog("insert  the value transfer"));
			//	System.out.println("insert  the value transfer");
			//	Double value = scan.nextDouble();

				accountRemetente.transfer(accountDestinatario, value);
			} else {
				JOptionPane.showInputDialog(null, "account not found");
				//System.out.println("account not found");
			}
		} else {
			JOptionPane.showInputDialog(null, "account not found");
			//System.out.println("account for transfer not found");

		}
		operations();
	}

	public static void ListAccounts() {

		if (accounts.size() > 0) {
			for (Account account : accounts) {
				JOptionPane.showInputDialog(null, account);
				//System.out.println(account);
			}
		} else {
			JOptionPane.showInputDialog(null, "not register");
			//System.out.println("not register");

		}
		operations();
	}
}
