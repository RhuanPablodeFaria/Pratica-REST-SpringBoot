package com.learningalone.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningalone.entyti.User;
import com.learningalone.service.UserService;
import com.learningalone.web.dto.UserCreateDTO;
import com.learningalone.web.dto.UserPasswordDto;
import com.learningalone.web.dto.UserRespondeDTO;
import com.learningalone.web.dto.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "usuarios")
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<UserRespondeDTO> create(@RequestBody UserCreateDTO createDTO) {
		User user = userService.salvar(UserMapper.toUser(createDTO));
		return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDto(user));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<UserRespondeDTO> getById(@PathVariable Long id) {
		User user = userService.findId(id);
		return ResponseEntity.ok(UserMapper.toDto(user));
	}

	@PatchMapping(path = "/{id}")
	public ResponseEntity<Void> alterPassword(@PathVariable Long id, @RequestBody UserPasswordDto userDto) {
		User user = userService.editPassword(id, userDto.getCurrentPassorwd(), userDto.getNewPassword(),
				userDto.getConfirmPassword());
		return ResponseEntity.noContent().build();
	}

	@GetMapping()
	public ResponseEntity<List<UserRespondeDTO>> getAll() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok(UserMapper.toListDto(users));
	}

	@PatchMapping(path = "userList/{id}")
	public void removeById(@PathVariable Long id) {
		userService.altesActiveStatus(id);
	}

}
