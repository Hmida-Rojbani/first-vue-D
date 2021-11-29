package de.tekup.vue.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
	
	private int id;
	
	private String name;
	
	private String password;
	
	private LocalDate dateOfBirth;
	
	private String email;
	
	public void setDateOfBirth(String date) {
		dateOfBirth = LocalDate.parse(date);
	}

}
