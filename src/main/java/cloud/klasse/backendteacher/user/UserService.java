package cloud.klasse.backendteacher.user;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    private final RestTemplate restTemplate;
    private final String backendUrl;

    public UserService(final RestTemplate restTemplate,
                       @Value("${backend.server.url:http://localhost:8080}") final String backendUrl) {
        this.restTemplate = restTemplate;
        this.backendUrl = backendUrl;
    }

    public Optional<User> createUser (final User user) {
        final URI uri = UriComponentsBuilder.fromHttpUrl(backendUrl).path("/user").build().toUri();
        final HttpEntity<User> userHttpEntity = new HttpEntity<>(user);
        final User responseUser = restTemplate.postForObject(uri, userHttpEntity, User.class);
        log.info("Created an user {} with given user data {}", responseUser, user);
        return Optional.ofNullable(responseUser);
    }

    public Optional<User> getUser (final long id) {
        final URI uri = UriComponentsBuilder.fromHttpUrl(backendUrl).path("/user/{id}").buildAndExpand(id).toUri();
        try {
            final ResponseEntity<User> responseUser = restTemplate.getForEntity(uri, User.class);
            log.info("Getting an user {} with given user id {}", responseUser, id);
            return Optional.ofNullable(responseUser.getBody());
        } catch (Exception exception) {
            log.error("User not found with id {}!", id);
            return Optional.empty();
        }
    }
}
