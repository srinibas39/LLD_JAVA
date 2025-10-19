public class PremiumEmail extends Email{

    private String cc;
    private String bcc;

    public PremiumEmail(String recipient, String subject, String body, String cc, String bcc) {
        super(recipient, subject, body);
        this.cc = cc;
        this.bcc = bcc;
    }

    public PremiumEmail(PremiumEmail email){
        super(email);
        this.cc = email.cc;
        this.bcc = email.bcc;
    }

    @Override
    public PremiumEmail copy() {
        return new PremiumEmail(this);
    }

    public String getCc() {
        return cc;
    }
    public String getBcc() {
        return bcc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("CC: " + cc);
    }



}
