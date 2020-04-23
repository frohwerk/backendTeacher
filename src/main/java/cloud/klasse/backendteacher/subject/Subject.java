package cloud.klasse.backendteacher.subject;

import cloud.klasse.backendteacher.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    private long id;
    private String name;
    private String topic;
    private User teacher;
    private String pushNotificationPrivateKey;
    private String pushNotificationPublicKey;
}
