package cloud.klasse.backendteacher.subject;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subject")
    public ResponseEntity<Subject> createSubject (@RequestBody final Subject subject) {
        final Optional<Subject> optionalSubject = subjectService.createSubject(subject);
        return optionalSubject.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable final long id) {
        final Optional<Subject> optionalSubject = subjectService.getSubjectById(id);
        return optionalSubject.map((final Subject s) -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
