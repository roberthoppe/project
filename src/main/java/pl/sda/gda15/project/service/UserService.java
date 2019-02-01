package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.entity.User;
import pl.sda.gda15.project.domain.repository.UserRepository;
import pl.sda.gda15.project.model.UserPOJO;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserPOJO> getUser(){
    return userRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }
    public void save(UserPOJO userPOJO){
    userRepository.save(map(userPOJO));
    }


    public User map(UserPOJO userPOJO){
    return new User(userPOJO.getUserID(),userPOJO.getName(),userPOJO.getSurname(),userPOJO.getAdres(),userPOJO.getCity(),
            userPOJO.getCountry(),userPOJO.getEmail(),userPOJO.getTel());
    }
    public UserPOJO map(User user){
    return new UserPOJO(user.getUserId(),user.getName(),user.getSurname(),user.getAdres(),user.getCity(),
            user.getCountry(),user.getEmail(),user.getTel());
    }

    public UserPOJO getUser(UUID userId) {
    return map(userRepository.getOne(userId));
    }
}
