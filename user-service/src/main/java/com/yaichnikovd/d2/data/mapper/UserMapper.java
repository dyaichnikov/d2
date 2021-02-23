package com.yaichnikovd.d2.data.mapper;

import com.yaichnikovd.d2.data.domain.User;
import com.yaichnikovd.d2.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    UserDTO to(User entity);

    User to(UserDTO dto);

    void update(UserDTO dto, @MappingTarget User entity);
}
