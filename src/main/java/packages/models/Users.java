package packages.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "the name field cannot be empty")
	private String name;

	private String cpf;

	@Email(message = "the email field cannot be empty")
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
