package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Entity
@Table(name="User_Admin")
public class AdminEntity {
	@Id
	private String  emailId;
	private String fullname;
	private String password;
	
	
	public AdminEntity(String emailId, String fullname, String password) {
		super();
		this.emailId = emailId;
		this.fullname = fullname;
		this.password = password;
	}


	public AdminEntity() {
		super();
	}
	
	
	
}
