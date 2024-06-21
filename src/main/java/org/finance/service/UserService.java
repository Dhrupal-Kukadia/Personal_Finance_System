package org.finance.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;
import org.finance.model.User;
import org.finance.repository.UserRepository;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    public void createUser(User user) {
        userRepository.persist(user);
    }

    public User findById(String id) {
        return userRepository.findById(new ObjectId(id));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(new ObjectId(id));
    }
}
