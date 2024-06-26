package com.learningalone.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.learningalone.entyti.User;
import com.learningalone.web.dto.UserCreateDTO;
import com.learningalone.web.dto.UserRespondeDTO;

public class UserMapper {

	public static User toUser(UserCreateDTO createDTO) {
		return new ModelMapper().map(createDTO, User.class);
	}
	
	public static UserRespondeDTO toDto(User user) {
		String userType = user.getRole().name().substring("TYPE_".length());
		Boolean userStatus = user.getActiveUser();
		PropertyMap<User, UserRespondeDTO> props = new PropertyMap<User, UserRespondeDTO>() {
			
			@Override
			protected void configure() {
				map().setRole(userType);
				map().setActiveUser(userStatus);
			}
		};
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(props);
		return mapper.map(user, UserRespondeDTO.class);
	}
	
	public static List<UserRespondeDTO> toListDto(List<User> users){
		return users.stream().map(user -> toDto(user)).collect(Collectors.toList());
	}
}
