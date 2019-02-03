package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.entity.User;
import pl.sda.gda15.project.domain.repository.UserRepository;
import pl.sda.gda15.project.model.OrderPOJO;
import pl.sda.gda15.project.model.UserPOJO;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final OrderService orderService;

    @Autowired
    public UserService(UserRepository userRepository, OrderService orderService) {
        this.userRepository = userRepository;
        this.orderService = orderService;
    }


    public List<UserPOJO> userList() {
        return userRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    public UserPOJO userList(UUID uuid) {
        return map(userRepository.getOne(uuid));
    }

    public void save(UserPOJO userPOJO) {
        userRepository.save(map(userPOJO));
    }

    public User map(UserPOJO userPOJO) {
        User user = new User(userPOJO.getUserId(), userPOJO.getName(), userPOJO.getSurname(), userPOJO.getAdres(), userPOJO.getCity(),
                userPOJO.getCountry(), userPOJO.getEmail(), userPOJO.getTel());
        return user;
    }

    public UserPOJO map(User user) {
        UserPOJO userPOJO = new UserPOJO(user.getUserId(), user.getName(), user.getSurname(), user.getAdres(), user.getCity(),
                user.getCountry(), user.getEmail(), user.getTel());
        return userPOJO;
    }

}
