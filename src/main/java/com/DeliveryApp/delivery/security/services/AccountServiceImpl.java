package com.DeliveryApp.delivery.security.services;

import com.DeliveryApp.delivery.security.entities.Role;
import com.DeliveryApp.delivery.security.entities.User;
import com.DeliveryApp.delivery.security.repositories.RoleRepository;
import com.DeliveryApp.delivery.security.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService{
    /* @Autowired
     private UserRepository userRepository;

     @Autowired
     private RoleRepository roleRepository;
     */
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public User createUser(String username, String password, String email, String confirmPassword) {
       /*
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        return userRepository.save(user);
        */
        User user = userRepository.findByUsername(username);
        if (user!=null) throw new RuntimeException("Exist");
        if (!password.equals(confirmPassword)) throw new RuntimeException("Error");
        user = User
                .builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)

                .build();
        return userRepository.save(user);
    }

    @Override
    public Role createRole(String role) {
        Role role1 = roleRepository.findById(role).orElse(null);
        role1 = Role.builder()
                .role(role)
                .build();
        return roleRepository.save(role1);
    }

    @Override
    public void addRoletoUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        Role role1 = roleRepository.findById(role).orElse(null);
        user.getRoles().add(role1);
    }

    @Override
    public void removeRolefromUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        Role role1 = roleRepository.findById(role).orElse(null);
        user.getRoles().remove(role1);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
