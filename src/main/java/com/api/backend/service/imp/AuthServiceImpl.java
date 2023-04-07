package com.api.backend.service.imp;

import com.api.backend.exception.ExistEmailException;
import com.api.backend.dto.UsersRequest;
import com.api.backend.entity.Users;
import com.api.backend.mapper.UsersMapper;
import com.api.backend.repository.UsersRepository;
import com.api.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public Optional<Users> AddUser(UsersRequest user) {
        boolean existEmail = usersRepository
                .findByEmail(user.getEmail()).isPresent();

        if (existEmail)
            throw new ExistEmailException("Cet email exist deja!");

        Users newUser = usersMapper.apply(user);
        return Optional.of(usersRepository.save(newUser));
    }
}