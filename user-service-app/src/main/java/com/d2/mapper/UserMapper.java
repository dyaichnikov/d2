package com.d2.mapper;

import com.d2.dto.UserRequest;
import com.d2.dto.UserResponse;
import com.d2.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User to(final UserRequest source);

    UserResponse to(final User source);
}
