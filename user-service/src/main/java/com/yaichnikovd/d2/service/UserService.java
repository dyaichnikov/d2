package com.yaichnikovd.d2.service;

import com.yaichnikovd.d2.data.domain.User;
import com.yaichnikovd.d2.data.mapper.UserMapper;
import com.yaichnikovd.d2.data.repository.UserRepository;
import com.yaichnikovd.d2.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDTO fetch(final UUID id) {
        final User user = getById(id);

        return userMapper.to(user);
    }

    @Transactional
    public void save(final UserDTO dto) {
        userRepository.save(userMapper.to(dto));
    }

    @Transactional
    public void update(final UUID id, final UserDTO dto) {
        final User user = getById(id);
        userMapper.update(dto, user);
    }

    @Transactional
    public void delete(final UUID id) {
        userRepository.deleteById(id);
    }

    private User getById(final UUID id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
