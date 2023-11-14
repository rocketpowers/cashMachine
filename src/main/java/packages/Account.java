package packages;

import javax.swing.JOptionPane;

import lombok.Data;
import packages.models.Users;
import utilitarios.Utils;

@Data
public class Account { 

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	private static int id = 1;

	private int numberAccount;
	private Users users;
	private Double balance = 0.0;

	public Account(Users users) {
		this.numberAccount = id;
		this.users = users;
		id += 1;

	}

	public String toString() {
		return "\nNumberAccount: " + this.getNumberAccount() + "\nName: " + this.users.getName() + "\nCpf: "
				+ this.users.getCpf() + "\nEmail: " + this.users.getEmail() + "\nPhone" + this.users.getPhone()
				+ "\nBalance: " + Utils.doubleToString(this.getBalance());

	}

	public void deposity(Double value) {
		if (value > 0) {
			setBalance(getBalance() + value);
			// JOptionPane.showInputDialog("successful deposit");
			System.out.println("successful deposit");
		} else {
			// JOptionPane.showInputDialog("unable to make deposit");
			System.out.println("unable to make deposit");
		}
	}

	public void withdraw(Double value) {
		if (value > 0 && this.getBalance() >= value) {
			setBalance(getBalance() - value);
			//JOptionPane.showInputDialog("successful withdraw");
			 System.out.println("successful withdraw");
		} else {
			//JOptionPane.showInputDialog("unable to make withdraw");
			 System.out.println("unable to make withdraw");

		}
	}

	public void transfer(Account accountDeposit, Double value) {
		if (value > 0 && this.getBalance() >= value) {
			setBalance(getBalance() - value);
			accountDeposit.balance = accountDeposit.getBalance() + value;

			JOptionPane.showInputDialog("successful trasfer");
			// System.out.println("successful trasfer");
		} else {
			JOptionPane.showInputDialog("unable to make transfer");
			// System.out.println("unable to make transfer");

		}
	}

}
