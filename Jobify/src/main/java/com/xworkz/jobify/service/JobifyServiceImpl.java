package com.xworkz.jobify.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.xworkz.jobify.util.OutlookEmail;
import com.xworkz.jobify.util.PasswordEncryption;

import com.xworkz.jobify.dto.JobifyDTO;
import com.xworkz.jobify.dto.JobifyEntity;
import com.xworkz.jobify.repo.JobifyRepository;

@Service
public class JobifyServiceImpl implements JobifyService {

	@Autowired
	private JobifyRepository repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean ValidateAndSave(JobifyDTO dto, Model model) {
//		if (dto.getName() != null && !dto.getName().isEmpty()) {
//			if (dto.getEmail() != null && !dto.getEmail().isEmpty()) {
//				if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
//					if (dto.getConfirmPass() != null && !dto.getConfirmPass().isEmpty()) {
//						
//						JobifyEntity entity = new JobifyEntity();
//						
//						entity.setCreatedBy(dto.getEmail());
//						entity.setCreatedOn(LocalDate.now());
//						
//						BeanUtils.copyProperties(dto, entity);
//						
//						boolean exist = isExists(entity.getEmail());
//						if (!exist) {
//							
////							JobifyEntity entity = new JobifyEntity();
////							entity.setCreatedBy(dto.getEmail());
////							entity.setCreatedOn(LocalDate.now());
////							BeanUtils.copyProperties(dto, entity);
////							
//							System.out.println("Email doesnt exist");
//							return repo.save(entity);
//						} else {
//							System.out.println("Account already exists");
//							model.addAttribute("accExists",
//									"Account already exists with this email, use sign in instead.");
//							return false;
//						}
//
//					}
//				}
//			}
//		}
//
//		return true;

		boolean isValid = true;
		if (dto != null) {
			if (dto.getName() == null || dto.getName().isEmpty() || dto.getName().length() <= 2) {
				model.addAttribute("nameInvalid", "Please fill this field");
				isValid = false;
			}
			if (dto.getEmail() == null || dto.getEmail().isEmpty()
					|| dto.getEmail().matches("/^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$/")) {
				model.addAttribute("emailInvalid", "Please Enter Correct Email");
				isValid = false;
			}
			if (!dto.getMobile().matches("(0|91)?[6-9][0-9]{9}")) {
				model.addAttribute("mobileInvalid", "Please enter a valid Mobile Number");
				isValid = false;
			}
			if (!dto.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$")) {
				model.addAttribute("passwordInvalid",
						"Enter a password with min. 8 characters, one uppercase and one symbol");
				isValid = false;
			}
			if (!dto.getConfirmPass().equals(dto.getPassword())) {
				model.addAttribute("confirmPasswordInvalid", "Password doesnot match");
				isValid = false;
			}
			if (isExists(dto, model)) {
				isValid = false;
			}
			if (isValid == true) {

				String hashedPassword = passwordEncoder.encode(dto.getPassword());
				dto.setPassword(hashedPassword);
				JobifyEntity entity = new JobifyEntity();
				entity.setCreatedBy(dto.getEmail());
				entity.setCreatedOn(LocalDate.now());
				BeanUtils.copyProperties(dto, entity);
				OutlookEmail email = new OutlookEmail();
				email.newEmail(dto.getEmail(), dto.getName());
				return repo.save(entity);
			}else {
				model.addAttribute("notReg", "Registration not Successful");
			}

		}
		return isValid;

	}

	@Override
	public boolean isExists(JobifyDTO dto, Model model) {
		List<JobifyEntity> list = repo.readAll();
		for (JobifyEntity jobifyEntity : list) {
			if(jobifyEntity.getEmail().equals(dto.getEmail())) {
				model.addAttribute("emailExists","Email already exists");
				return true;
			}
			
		}
		return false;
	}

	
//	public boolean isExists(String email) {
//		JobifyEntity entity = repo.findByEmail(email);
//		if (entity != null) {
//			System.out.println("Email exists");
//			return true;
//		}
//		return false;
//	}

	@Override
	public JobifyEntity findByEmail(String email, Model model) {
		if(email!=null && !email.isEmpty()) {
			return repo.findByEmail(email);
		}
		return null;
	}

	@Override
	public List<JobifyEntity> readAll() {
		// TODO Auto-generated method stub
		return repo.readAll();
	}
}
