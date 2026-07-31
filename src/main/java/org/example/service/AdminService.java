package org.example.service;

import java.util.List;

import org.example.dto.AdminDto;
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
		 AdminEntity adminEntity=userAdminRepository.findById(dto.getEmailId())
				 .orElseThrow(()->  new UsernameNotFoundException("Admin  is not found"));
		 if (adminEntity!=null) {
			return null;
		}
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
	
	
}
