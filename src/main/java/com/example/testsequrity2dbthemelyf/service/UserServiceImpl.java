package com.example.testsequrity2dbthemelyf.service;

import com.example.testsequrity2dbthemelyf.dto.UserDto;
import com.example.testsequrity2dbthemelyf.entity.Role;
import com.example.testsequrity2dbthemelyf.entity.User;
import com.example.testsequrity2dbthemelyf.repository.RoleRepository;
import com.example.testsequrity2dbthemelyf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public void saveUser(UserDto UserDto) {
        User user = new User();
        user.setName(UserDto.getFirstName() + " " + UserDto.getLastName());
        user.setEmail(UserDto.getEmail());
        user.setPassword(passwordEncoder.encode(UserDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExist();
        }
        user.setRoles(List.of(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToUserDto).collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        UserDto UserDto = new UserDto();
        String[] firstLastNames = user.getName().split(" ");
        UserDto.setFirstName(firstLastNames[0]);
        UserDto.setLastName(firstLastNames[1]);
        UserDto.setEmail(user.getEmail());
        return UserDto;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
