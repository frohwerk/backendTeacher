package cloud.klasse.backendteacher.subject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.Subject;
import java.util.Optional;

@Service
@Slf4j
public class SubjectService {

    private final RestTemplate restTemplate;
    private final String backendUrl;

    public SubjectService(final RestTemplate restTemplate,
                          @Value("${backend.server.url:http://localhost:8080}") final String backendUrl) {
        this.restTemplate = restTemplate;
        this.backendUrl = backendUrl;
    }

    public Optional<Subject> getSubjectById (final long id) {

        return Optional.ofNullable()
    }

}
