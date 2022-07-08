package machete.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface ConsumerBinding {
    String BINDING_TARGET_NAME = "usersChannel";

    @Input(BINDING_TARGET_NAME)
    MessageChannel orderIn();
}
