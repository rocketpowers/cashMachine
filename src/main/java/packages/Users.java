package packages;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String cpf;
	private String email;
	private String phone;
	
	public Users() {
		
	}

	public Users(String name, String cpf, String email, String phone) {

		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.phone = phone;
	}

}
