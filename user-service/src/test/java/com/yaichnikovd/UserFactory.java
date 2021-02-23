package com.yaichnikovd;

import com.yaichnikovd.d2.dto.UserDTO;

import static io.qala.datagen.RandomShortApi.english;

public class UserFactory {

    private static final String VALID_EMAIL = "valid.email@gmail.com";
    private static final String INVALID_EMAIL_WITHOUT_AT_SYMBOL = "invalid.emailgmail.com";
    private static final String INVALID_EMAIL_WITHOUT_DOT_BEFORE_DOMAIN = "invalid.email@gmailcom";

    public static UserDTO aUserDTOWithInvalidEmailWithoutAtSymbol() {
        return of(english(0, 255), english(0, 255), INVALID_EMAIL_WITHOUT_AT_SYMBOL);
    }

    public static UserDTO aUserDTOWithInvalidEmailWithoutDotBeforeDomain() {
        return of(english(0, 255), english(0, 255), INVALID_EMAIL_WITHOUT_DOT_BEFORE_DOMAIN);
    }

    public static UserDTO aUserDTOWithLastNameShorterThanLowerBound() {
        return of(english(0, 255), english(0, 255), VALID_EMAIL);
    }

    public static UserDTO aUserDTOWithLastNameLongerThanUpperBound() {
        return of(english(1, 255), english(1, 256), VALID_EMAIL);
    }

    public static UserDTO aUserDTOWithFirstNameShorterThanLowerBound() {
        return of(english(0, 255), english(1, 255), VALID_EMAIL);
    }

    public static UserDTO aUserDTOWithFirstNameLongerThanUpperBound() {
        return of(english(1, 256), english(1, 255), VALID_EMAIL);
    }

    public static UserDTO aValidUserDTO() {
        return of(english(1, 255), english(1, 255), VALID_EMAIL);
    }

    public static UserDTO of(final String firstName, final String lastName, final String email) {
        return UserDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();
    }
}
