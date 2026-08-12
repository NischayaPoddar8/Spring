package nischaya.example.ProfileDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev") // When profile is dev choose this to create bean
public class DummyNotificationServiceImpl implements NotificationService{
    @Override
    public String sendNotification() {
        return "Dummy notification sent";
    }
}
