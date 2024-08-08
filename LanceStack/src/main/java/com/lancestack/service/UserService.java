package com.lancestack.service;

import java.util.List;

import com.lancestack.dto.ApiResponse;
import com.lancestack.dto.User.UserDTO;
import com.lancestack.dto.User.UserForgetPassword;
import com.lancestack.dto.User.UserLoginDTO;
import com.lancestack.dto.User.UserRegistrationDTO;

public interface UserService {
	ApiResponse registerUser(UserRegistrationDTO user);
	
	List<UserDTO> getAllUsers();
	
	UserDTO getUser(Long id);
	
	ApiResponse updateUser(Long id, UserRegistrationDTO user);
	
	ApiResponse deleteUser(Long id);

	UserDTO getUserByEmailAndPassword(UserLoginDTO userLoginDTO);

	ApiResponse forgetPassword(UserForgetPassword user);
}
