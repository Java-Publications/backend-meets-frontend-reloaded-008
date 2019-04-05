package org.rapidpm.vaadin.v10.issuetracker.services;

import org.rapidpm.frp.model.Result;
import org.rapidpm.frp.model.serial.Pair;

import java.time.LocalDateTime;

import static org.rapidpm.frp.matcher.Case.match;
import static org.rapidpm.frp.matcher.Case.matchCase;
import static org.rapidpm.frp.model.Result.failure;
import static org.rapidpm.frp.model.Result.success;

public class SecurityService {

  public Result<User> checkLogin(String username, String password) {
    return match(matchCase(() -> failure("securityservice.login.denied")),
                 matchCase(() -> username == null, () -> failure("securityservice.username.null")),
                 matchCase(username::isEmpty, () -> failure("securityservice.username.is-empty")),
                 matchCase(() -> password == null, () -> failure("securityservice.password.null")),
                 matchCase(password::isEmpty, () -> failure("securityservice.password.is-empty")),
                 matchCase(() -> username.equals("admin") && password.equals("admin"),
                           () -> success(new User("Jon Doe", LocalDateTime.now()))));
  }

  public static class User extends Pair<String, LocalDateTime> {
    public User(String name, LocalDateTime timestamp) {
      super(name, timestamp);
    }
  }
}
