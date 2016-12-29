import java.util.*;


      <groupId>com.twilio.sdk</groupId>
      <artifactId>twilio</artifactId>
      <version>7.X.X</version>
      <scope>compile</scope>
 class twilio
 {

 public static void main(String[] args) throws Exception
{
   String accountSid = "AC16a884b5b5ecf241043b9204a2e4ba63"; // Your Account SID from www.twilio.com/user/account

String authToken = "5c90b7f8982302fca73ad630be103f00"; // Your Auth Token from www.twilio.com/user/account

Twilio.init(accountSid, authToken);

Message message = Message.creator(
    new PhoneNumber("9840521276"),  // To number
    new PhoneNumber("+19162519930"),  // From number
    "Hello world!"                    // SMS body
).create();

System.out.println(message.getSid());
}
}
