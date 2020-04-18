package cloud.klasse.backendteacher.subject;
import cloud.klasse.backendteacher.user.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.Optional;

@Service
@Slf4j
public class SubjectService {

    private final RestTemplate restTemplate;
    private final String backendUrl;
    private final Logger logger = LoggerFactory.getLogger(SubjectService.class);
    public SubjectService(final RestTemplate restTemplate,
                          @Value("${backend.server.url:http://localhost:8080}") final String backendUrl) {
        this.restTemplate = restTemplate;
        this.backendUrl = backendUrl;
    }

    public Optional<Subject> getSubjectById (final long id) {
        final URI uri = UriComponentsBuilder.fromHttpUrl(backendUrl).path("/subject/{id}").buildAndExpand(id).toUri();

        try {
            final ResponseEntity<Subject> responseSubject = restTemplate.getForEntity(uri, Subject.class);
            logger.info("Get for {} with id {}", responseSubject, id);
            return Optional.ofNullable(responseSubject.getBody());
        }
        catch (Exception e) {
            logger.error("Could not find Subject with id {}", id);
            return Optional.empty();
        }
    }

    public Optional<Subject> createSubject(Subject subject) {
        final URI uri = UriComponentsBuilder.fromHttpUrl(backendUrl).path("/subject").build().toUri();
        final HttpEntity<Subject>  subjectHttpEntity = new HttpEntity<>(subject);
        final Subject responseSubject = restTemplate.postForObject(uri, subjectHttpEntity, Subject.class);
        logger.info("Created an user {} with given user data {}", responseSubject, subject);
        return Optional.ofNullable(responseSubject);
    }
}
