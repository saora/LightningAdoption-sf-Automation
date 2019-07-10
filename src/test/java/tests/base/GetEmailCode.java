package tests.base;

import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import screens.gmail.InboxReader;

import javax.mail.MessagingException;

public class GetEmailCode {
    @Steps
    private InboxReader inboxReader;

    @Test
    public void getCodeG() throws MessagingException {
        String a = InboxReader.getEmail("glbltest.salesforce@gmail.com", "61084n7mex01");
        System.out.println(a);

    }
}
