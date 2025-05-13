package com.example.resourceserver.services;

import com.example.resourceserver.dtos.UserDto;
import com.example.resourceserver.dtos.UserRolesDto;
import com.example.resourceserver.entities.UserEntity;
import com.example.resourceserver.entities.UserRole;
import com.example.resourceserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
   @Autowired
    private PasswordEncoder encoder;
   @Autowired
   private UserRepository repository;
//    public UserService(PasswordEncoder encoder, UserRepository repository) {
//        this.encoder = encoder;
//        this.repository = repository;
//    }

    public UserDto createUser(UserDto dto){
        Optional<UserEntity> userExist = repository.findByUsername(dto.getUsername());
        if(userExist.isPresent()){
            System.out.println("exist");
        } else {
            UserEntity entity = new UserEntity();
            entity.setUsername(dto.getUsername());
            entity.setPassword(encoder.encode(dto.getPassword()));
            entity.setEnabled(true);
            repository.save(entity);
        }
        return dto;
    }


    public UserDto createUserRoles(UserRolesDto dto){
         UserEntity entity = repository.findById(dto.getUserId()).get();
         List<UserRole> urList = new ArrayList<>();
         dto.getRoleIds().forEach(id->{
             UserRole ur = new UserRole();
             ur.setId(id);
             urList.add(ur);
         });
        entity.setRoles(urList);
        repository.save(entity);
        return null;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        List<GrantedAuthority> roles = user.getRoles()
                    .stream()
                    .map(r -> new SimpleGrantedAuthority(r.getName()))
                    .collect(Collectors.toList());
        System.out.println("roles->"+roles);
        return new User(user.getUsername(),user.getPassword(),roles);
    }
}
