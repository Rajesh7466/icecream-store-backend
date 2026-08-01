package org.example.service;

import java.util.List;
import java.util.Optional;

import org.example.dto.AdminDto;
import org.example.dto.UserLogin_Response;
import org.example.dto.User_Login_Info;
import org.example.entity.AdminEntity;
import org.example.entity.UserInformation;
import org.example.repository.UserAdminRepository;
import org.example.repository.UserRepository;
import org.hibernate.cache.spi.support.CollectionNonStrictReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	UserAdminRepository userAdminRepository;
	
	@Autowired
	UserRepository userRepository;
	public List<UserInformation> findAllUser() {
		 
		return userRepository.findAll();
	}
	
	public AdminDto createUserAdmin(AdminDto dto) {
		 Optional<AdminEntity> optional=userAdminRepository.findById(dto.getEmailId());
		 if (optional.isPresent()) {
			 
			return null;
		}
		 AdminEntity adminEntity=
				 new AdminEntity();
		  adminEntity.setEmailId(dto.getEmailId());
		  adminEntity.setFullname(dto.getFullname());
		  adminEntity.setPassword(dto.getPassword());
		  userAdminRepository.save(adminEntity);
		  
//		  for admin user response 
		  AdminDto adminDto=new AdminDto();
		  adminDto.setEmailId(adminEntity.getEmailId());
		  adminDto.setFullname(adminEntity.getFullname());
		  adminDto.setPassword(adminEntity.getPassword());
		return adminDto;
	}

	public UserLogin_Response adminLogin(User_Login_Info dto) {
		 AdminEntity adminEntity=userAdminRepository.findById(dto.getEmailId())
				 .orElseThrow(null);
		 if (adminEntity!=null) {
			UserLogin_Response userLogin_Response=new UserLogin_Response();
			userLogin_Response.setEmailId(adminEntity.getEmailId());
			
		}
		return null;
	}
	
	
}
