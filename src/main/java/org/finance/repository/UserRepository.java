package org.finance.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.finance.model.User;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {
}
