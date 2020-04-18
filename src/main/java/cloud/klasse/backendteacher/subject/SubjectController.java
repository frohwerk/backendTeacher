package cloud.klasse.backendteacher.subject;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SubjectController {

    @Autowired
    private SubjectService subjectService;


}
