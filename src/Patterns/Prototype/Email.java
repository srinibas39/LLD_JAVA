package Patterns.Prototype;

public abstract class Email implements Prototype<Email>{

    private String recipient;
    private String subject;
    private String body;

    public Email(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public Email(Email email){
        this.recipient = email.recipient;
        this.subject = email.subject;
        this.body = email.body;
    }

    @Override
    public abstract Email copy();

    public String getRecipient() {
        return recipient;
    }
    public String getSubject() {
        return subject;
    }
    public String getBody() {
        return body;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public void display() {
        System.out.println("Recipient: " + recipient);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}
