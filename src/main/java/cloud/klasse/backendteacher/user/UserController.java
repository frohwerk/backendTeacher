package cloud.klasse.backendteacher.user;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/user")
    public ResponseEntity<User> createUser (@RequestBody final User user) {
        final Optional<User> optionalUser = userService.createUser(user);
        logger.info("Creates user with userName: {}", user.getUserName());
        return optionalUser.map((final User responseUser) -> new ResponseEntity<>(responseUser, HttpStatus.CREATED))
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser (@PathVariable final long id) {
        final Optional<User> optionalUser = userService.getUser(id);
        logger.info("Get user with userid: {}", id);
        return optionalUser.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
