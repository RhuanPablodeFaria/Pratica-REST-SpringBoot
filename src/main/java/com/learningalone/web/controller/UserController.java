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
import com.learningalone.web.exception.ErrorMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "User", description = "Operations about user CRUD")
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "usuarios")
public class UserController {

	private final UserService userService;

	@Operation(summary = "Create a new user", description = "Create a new user", responses = {
			@ApiResponse(responseCode = "201", description = "User created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserRespondeDTO.class))),
			@ApiResponse(responseCode = "400", description = "Email, Full Name or CPF already registered in the system", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
			@ApiResponse(responseCode = "422", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
	})
	@PostMapping
	public ResponseEntity<UserRespondeDTO> create(@RequestBody UserCreateDTO createDTO) {
		User user = userService.salvar(UserMapper.toUser(createDTO));
		return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDto(user));
	}

	@Operation(summary = "Get a user by id", description = "Get a user by id", responses = {
			@ApiResponse(responseCode = "200", description = "Located user successfully", content = @Content(schema = @Schema(implementation = UserRespondeDTO.class))),
			@ApiResponse(responseCode = "404", description = "User not found", content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
	})
	@GetMapping(path = "/{id}")
	public ResponseEntity<UserRespondeDTO> getById(@PathVariable Long id) {
		User user = userService.findId(id);
		return ResponseEntity.ok(UserMapper.toDto(user));
	}

	@Operation(summary = "Change password", description = "Change password", responses = {
			@ApiResponse(responseCode = "200", description = "Password changed successfully", content = @Content(schema = @Schema(implementation = UserRespondeDTO.class))),
			@ApiResponse(responseCode = "400", description = "User not found", content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
	})
	@PatchMapping(path = "/{id}")
	public ResponseEntity<Void> alterPassword(@PathVariable Long id, @RequestBody UserPasswordDto userDto) {
		User user = userService.editPassword(id, userDto.getCurrentPassorwd(), userDto.getNewPassword(),
				userDto.getConfirmPassword());
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "Get all users", description = "Get all users", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserRespondeDTO.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
	})
	@GetMapping()
	public ResponseEntity<List<UserRespondeDTO>> getAll() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok(UserMapper.toListDto(users));
	}

	@Operation(summary = "Change active status", description = "Change active status", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserRespondeDTO.class))),
			@ApiResponse(responseCode = "204", description = "User not found", content = @Content(schema = @Schema(implementation = UserRespondeDTO.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
	})
	@PatchMapping(path = "userList/{id}")
	public void alterActiveStatus(@PathVariable Long id) {
		userService.alterActiveStatus(id);
	}

}
