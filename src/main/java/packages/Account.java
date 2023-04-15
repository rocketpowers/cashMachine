package packages;

import lombok.Data;
import utilitarios.Utils;


@Data
public class Account {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private static int id =1;

	private int numberAccount;
	private Users users;
	private Double balance = 0.0;
	
	public Account(Users users) {
		this.numberAccount =id;
		this.users=users;
		id +=1;
	
}

	public String toString() {
		return "\nNumberAccount: " + this.getNumberAccount() +
				"\nName: " + this.users.getName() +
				"\nCpf: " + this.users.getCpf() + 
				"\nEmail: " +this.users.getEmail() + 
				"\nPhone" + this.users.getPhone()+
				"\nBalance: " + Utils.doubleToString(this.getBalance());

	}
	
	

	
	public void deposity(Double value) {
		if (value > 0) {
			setBalance(getBalance() + value);
			System.out.println("successful deposit");
		} else {
			System.out.println("unable to make deposit");
		}
	}

	public void withdraw(Double value) {
		if (value > 0 && this.getBalance() >= value) {
			setBalance(getBalance() - value);
			System.out.println("successful withdraw");
		} else {
			System.out.println("unable to make withdraw");

		}
	}

	public void transfer(Account accountDeposit, Double value) {
		if (value > 0 && this.getBalance() >= value) {
			setBalance(getBalance() - value);
			accountDeposit.balance = accountDeposit.getBalance() + value;
			System.out.println("successful trasfer");
		} else {
			System.out.println("unable to make transfer");

		}
	}


	

}
