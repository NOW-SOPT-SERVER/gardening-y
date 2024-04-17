package com.example.carrot.service;

import com.example.carrot.domain.User;
import com.example.carrot.dto.request.UserCreateRequest;
import com.example.carrot.dto.response.UserCreateResponse;
import com.example.carrot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserCreateResponse createUser(UserCreateRequest request) {
        User user = User.createUser(request.name());
        userRepository.save(user);
        return UserCreateResponse.of(user);
    }
}