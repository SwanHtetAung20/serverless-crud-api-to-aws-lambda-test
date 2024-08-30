package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<UserDto> userDtoList = new ArrayList<>();


    public UserDto add(UserDto userDto) {
        userDtoList.add(userDto);
        return userDto;
    }

    public List<UserDto> getAllUsers() {
        return new ArrayList<>(userDtoList);
    }

    public Optional<UserDto> findById(Long id) {
        return userDtoList.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public UserDto updateUserDto(Long id, UserDto userDto) {
        return findById(id).map(existingUser -> {
            existingUser.setName(userDto.getName());
            existingUser.setEmail(userDto.getEmail());
            return existingUser;
        }).orElseGet(() -> UserDto.builder().message("User Not Found").build());
    }

    public boolean deleteUser(Long id) {
        return userDtoList.removeIf(user -> user.getId().equals(id));
    }
}
