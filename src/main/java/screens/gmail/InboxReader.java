
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

@SuppressWarnings("all")
public class InboxReader {
String n;
    public static void main(String args[]) throws MessagingException {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getDefaultInstance(props, null);
            //session.setDebug(true);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", "glbltest.salesforce@gmail.com", "61084n7mex01");
            // System.out.println(store);
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_ONLY);
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message messages[] = inbox.search(ft);
            try {
                        for (Message message : messages) {
                        if(message.getSubject().contains("Verify your identity in Salesforce")) {
                            System.out.println("Unread mails: " + messages.length);
                            System.out.println(" Email found!!");
                           // System.out.println(message.getSubject());
                           // System.out.println(message.getContent().toString());
                            String cadena = message.getContent().toString();
                            char [] cadena_div = cadena.toCharArray();
                            String n = "";
                            for (int i=0; i<cadena_div.length; i++){
                                if(Character.isDigit(cadena_div[i])){
                                    n+=cadena_div[i];
                                }
                            }

                            getCode(n);
/*                             String num ="";
                            char[] ncode={n.charAt(n.length()-5),n.charAt(n.length()-4),n.charAt(n.length()-3),n.charAt(n.length()-2),n.charAt(n.length()-1)};
                            for(int i=0; i<ncode.length; i++){
                                num+=ncode[i];
                            }
                            System.out.println("Verification code:  "+num);*/
                        }else{System.out.println("Not found!!");}
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());


//message.setFlag(Flags.Flag.ANSWERED, true);
//message.setFlag(Flags.Flag.SEEN, true);

/*                String subject = message.getSubject();
                String content = message.getContentType();
                //AQUI
                MimeMultipart part = (MimeMultipart) message.getContent();
                BodyPart bodyPart = part.getBodyPart(1);
                part.getContentType().split(" ")[1].trim();
                part.getCount();
                part.getPreamble();


                try {
                    printParts(message);

                    System.out.println("This is a String");
                } catch (Exception e) {

// TODO Auto-generated catch block
                    e.printStackTrace();

                }
                Flags flags = message.getFlags();
                Address[] form = message.getFrom();*/
            }
        } catch (NoSuchProviderException e) {
/*            e.printStackTrace();
            System.exit(1);*/
        } catch (MessagingException e) {
       /*     e.printStackTrace();
            System.exit(2);*/
        } /*catch (IOException e) {
// TODO Auto-generated catch block
        *//*    e.printStackTrace();*//*
        }*/


/*        public static void printParts (Part p) throws Exception{
*//*            Object o = p.getContent();
            if (p.getDescription().contains("Verification Code"))
                System.out.println(" 1 match found");
            else {
                System.out.println("No match");
            }
            if (o instanceof String) {
                System.out.println("This is a String");
                System.out.println((String) o);
            } else if (o instanceof Multipart) {
                System.out.println("This is a Multipart");
                Multipart mp = (Multipart) o;
                int count = mp.getCount();
                for (int i = 0; i < count; i++) {
                    System.out.println("TEST GLB");
                    printParts(mp.getBodyPart(i));
                }
            } else if (o instanceof InputStream) {
                System.out.println("This is just an input stream");
                InputStream is = (InputStream) o;
                int c;
                while ((c = is.read()) != -1)
                    System.out.write(c);
            }*//*
        }*/
    }

    public static String getCode(String n){
        String num ="";
        char[] ncode={n.charAt(n.length()-5),n.charAt(n.length()-4),n.charAt(n.length()-3),n.charAt(n.length()-2),n.charAt(n.length()-1)};
        for(int i=0; i<ncode.length; i++){
            num+=ncode[i];
        }
        System.out.println("Verification code:  "+num);
        return num;
    }
    public void getEmail(String gUser, String gPass){
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getDefaultInstance(props, null);
            //session.setDebug(true);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", gUser, gPass);
            // System.out.println(store);
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_ONLY);
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message messages[] = inbox.search(ft);
            try {
                for (Message message : messages) {
                    if(message.getSubject().contains("Verify your identity in Salesforce")) {
                        System.out.println("Unread mails: " + messages.length);
                        System.out.println(" Email found!!");
                        // System.out.println(message.getSubject());
                        // System.out.println(message.getContent().toString());
                        String cadena = message.getContent().toString();
                        char [] cadena_div = cadena.toCharArray();
                        String n="";

                        for (int i=0; i<cadena_div.length; i++){
                            if(Character.isDigit(cadena_div[i])){
                                n+=cadena_div[i];
                            }
                        }
/*                             String num ="";
                            char[] ncode={n.charAt(n.length()-5),n.charAt(n.length()-4),n.charAt(n.length()-3),n.charAt(n.length()-2),n.charAt(n.length()-1)};
                            for(int i=0; i<ncode.length; i++){
                                num+=ncode[i];
                            }
                            System.out.println("Verification code:  "+num);*/
getCode(n);

                    }else{System.out.println("Not found!!");}
                }
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
    }catch (Exception e){
                System.out.println(e.getMessage());
            }
}

}