package com.yaichnikovd.d2;

import com.yaichnikovd.d2.data.domain.User;
import com.yaichnikovd.d2.data.mapper.UserMapper;
import com.yaichnikovd.d2.data.repository.UserRepository;
import com.yaichnikovd.d2.dto.UserDTO;
import com.yaichnikovd.d2.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.yaichnikovd.UserFactory.aValidUserDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    private UserService userService;

    @BeforeEach
    void setUp() {
        final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        this.userService = new UserService(userMapper, userRepository);
    }

    @Test
    public void whenDtoIsValid_save_shouldSaveNewUser() {
        //given
        final UserDTO expected = aValidUserDTO();

        //when
        userService.save(expected);

        //then
        verify(userRepository).save(userCaptor.capture());
        final User actual = userCaptor.getValue();
        assertThat(actual).extracting(User::getFirstName, User::getLastName, User::getEmail)
                .containsExactly(expected.getFirstName(), expected.getLastName(), expected.getEmail());
    }

//    @Test
//    public void whenFirstNameIsLongerThanUpperBound_save_shouldThrowObjectNotValidException() {
//        assertThatThrownBy(() -> userService.save(aUserDTOWithFirstNameLongerThanUpperBound()))
//                .isInstanceOf(ObjectNotValidException.class);
//    }
//
//    @Test
//    public void whenFirstNameIsShorterThanLowerBound_save_shouldThrowObjectNotValidException() {
//        assertThatThrownBy(() -> userService.save(aUserDTOWithFirstNameShorterThanLowerBound()))
//                .isInstanceOf(ObjectNotValidException.class);
//    }
//
//    @Test
//    public void whenLastNameIsShorterThanLowerBound_save_shouldThrowObjectNotValidException() {
//        assertThatThrownBy(() -> userService.save(aUserDTOWithLastNameShorterThanLowerBound()))
//                .isInstanceOf(ObjectNotValidException.class);
//    }
//
//    @Test
//    public void whenLastNameIsLongerThanUpperBound_save_shouldThrowObjectNotValidException() {
//        assertThatThrownBy(() -> userService.save(aUserDTOWithLastNameLongerThanUpperBound()))
//                .isInstanceOf(ObjectNotValidException.class);
//    }
//
//    @Test
//    public void whenEmailHasNoAtSymbol_save_shouldThrowObjectNotValidException() {
//        assertThatThrownBy(() -> userService.save(aUserDTOWithInvalidEmailWithoutAtSymbol()))
//                .isInstanceOf(ObjectNotValidException.class);
//    }
//
//    @Test
//    public void whenEmailHasNoDotBeforeDomain_save_shouldThrowObjectNotValidException() {
//        assertThatThrownBy(() -> userService.save(aUserDTOWithInvalidEmailWithoutDotBeforeDomain()))
//                .isInstanceOf(ObjectNotValidException.class);
//    }
}
