package com.api.backend.service;

import com.api.backend.dto.UsersRequest;
import com.api.backend.entity.Users;

import java.util.List;

public interface UsersService {
    public List<Users> GetAllUsers();

    public Users AddUser(UsersRequest user);
}