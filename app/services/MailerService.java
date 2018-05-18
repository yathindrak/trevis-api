package services;//package services;
//
//import play.Play;
//import play.libs.mailer.Email;
//import play.libs.mailer.MailerClient;
//import javax.inject.Inject;
//import java.io.File;
//import org.apache.commons.mail.EmailAttachment;
//
//public class MailerService {
//    @Inject MailerClient mailerClient;
//
//    public void sendEmail() {
//        String cid = "1234";
//        Email email = new Email()
//                .setSubject("Simple email")
//                .setFrom("yathindarawya123@gmail.com")
//                .addTo("yathindrarawya123@gmail.com")
//                // adds attachment
//                //.addAttachment("attachment.pdf", new File("/some/path/attachment.pdf"))
//                // adds inline attachment from byte array
//                //.addAttachment("data.txt", "data".getBytes(), "text/plain", "Simple data", EmailAttachment.INLINE)
//                // adds cid attachment
//                //.addAttachment("image.jpg", new File("/some/path/image.jpg"), cid)
//                // sends text, HTML or both...
//                .setBodyText("A text message")
//                .setBodyHtml("<html><body><p>An <b>html</b> message with cid </p></body></html>");
//        System.out.println("Mail : "+email);
//        System.out.println("Mail : "+email.getBodyText());
//        Play.application().injector().instanceOf(MailerClient.class).send(email);
//        mailerClient.send(email);
//    }
//}