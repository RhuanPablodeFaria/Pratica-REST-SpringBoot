package com.learningalone.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learningalone.entyti.User;
import com.learningalone.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public User salvar(User user) {
		return userRepository.save(user);
	}

	@Transactional(readOnly = true)
	public User findId(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não localizado"));
	}

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Transactional
	public User editPassword(Long id, String currentPassword, String newPassword, String confirmPassword) {

		User user = findId(id);

		if (!user.getPassword().equals(currentPassword)) {
			throw new RuntimeException("Your password doesn`t match");
		}

		if (!newPassword.equals(confirmPassword)) {
			throw new RuntimeException("The new password doesn`t match the current password");
		}
		user.setPassword(newPassword);
		return user;
	}

	public void alterActiveStatus(Long id) {
		userRepository.updateActiveUserById(id);
	}
}
