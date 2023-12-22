package com.xworkz.jobify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class JobifyDTO {
	
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String confirmPass;
	private String account;

}
