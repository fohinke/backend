package com.api.backend.service;

import com.api.backend.dto.UsersRequest;
import com.api.backend.entity.Users;

import java.util.Optional;

public interface AuthService {
    public Optional<Users> AddUser(UsersRequest user);
}
