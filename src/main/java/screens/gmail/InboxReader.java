package screens.gmail;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.Properties;

@SuppressWarnings("All")
public class InboxReader {
    public static String getCode(String n) {
        String num = "";
        char[] ncode = {n.charAt(n.length() - 5), n.charAt(n.length() - 4), n.charAt(n.length() - 3), n.charAt(n.length() - 2), n.charAt(n.length() - 1)};
        for (int i = 0; i < ncode.length; i++) {
            num += ncode[i];
        }
        return num;
    }

    public static String getEmail(String gmailUser, String gmailPass) throws MessagingException {
        String vargetcode = "";
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", gmailUser, gmailPass);
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message messages[] = inbox.search(ft);
            try {
                for (Message message : messages) {
                    if (message.getSubject().contains("Verify your identity in Salesforce")) {
                        message.setFlag(Flags.Flag.SEEN, true);
                        String cadena = message.getContent().toString();
                        char[] cadena_div = cadena.toCharArray();
                        String n = "";
                        for (int i = 0; i < cadena_div.length; i++) {
                            if (Character.isDigit(cadena_div[i])) {
                                n += cadena_div[i];
                            }
                        }
                        vargetcode = getCode(n);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return vargetcode;
    }
}