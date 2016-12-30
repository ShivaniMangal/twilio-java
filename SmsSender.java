import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URISyntaxException;

public class SmsSender {

    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC16a884b5b5ecf241043b9204a2e4ba63";
    public static final String AUTH_TOKEN = "5c90b7f8982302fca73ad630be103f00";

    public static void main(String[] args) throws URISyntaxException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("9840521276"),  // to
                         new PhoneNumber("+19162519930"),  // from
                         "Where's Wallace?")
                .create();
    }
}
