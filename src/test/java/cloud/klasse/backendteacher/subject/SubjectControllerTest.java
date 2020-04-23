package cloud.klasse.backendteacher.subject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SubjectController.class)
class SubjectControllerTest {
/*
    @Autowired
    MockMvc mockMvc;

    @MockBean
    SubjectService subjectService;

    @BeforeEach
    void setup() {

    }

    @Test
    public void createSubjectTest() throws Exception {
        Subject s = new Subject();   ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(s );
        when(subjectService.createSubject(s)).thenReturn(Optional.empty());
        this.mockMvc.perform(post("/subject").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isNotFound());
    }
*/

}