package com.d2.service;

import com.d2.dto.UserRequest;
import com.d2.dto.UserResponse;
import com.d2.exception.PersistenceException;
import com.d2.mapper.UserMapper;
import com.d2.model.User;
import com.d2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Transactional
    public UUID create(final UserRequest body) {
        final var savedUser = userRepository.save(userMapper.to(body));

        return savedUser.getId();
    }

    @Transactional(readOnly = true)
    public UserResponse fetch(final UUID id) {
        final var user = userRepository.findById(id)
                .orElseThrow(() -> new PersistenceException.EntityNotFoundException(User.class, id));

        return userMapper.to(user);
    }
}
