/**
 * Practice: Prototype pattern — email templates + registry.
 * Complete the TODO blocks, then: javac EmailTemplateExercise.java && java EmailTemplateExercise
 */
import java.util.HashMap;
import java.util.Map;

public class EmailTemplateExercise {

    interface EmailTemplate extends Cloneable {
        EmailTemplate clone();

        void setContent(String content);

        void send(String to);
    }

    static class WelcomeEmail implements EmailTemplate {
        private String subject;
        private String content;

        public WelcomeEmail() {
            this.subject = "Welcome to TUF+";
            this.content = "Hi there! Thanks for joining us.";
        }

        // TODO: Return a new WelcomeEmail with the same subject/content (use super.clone() + Cloneable, or copy fields manually).
        @Override
        public WelcomeEmail clone() {
            try{
                return (WelcomeEmail) super.clone();
            }
            catch(Exception e){

                throw new UnsupportedOperationException("TODO: implement clone()");
            }
        }

        @Override
        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public void send(String to) {
            System.out.println("Sending to " + to + ": [" + subject + "] " + content);
        }
    }

    static class EmailTemplateRegistry {
        private static final Map<String, EmailTemplate> templates = new HashMap<>();

        static {
            // TODO: put the "welcome" prototype into `templates`.
            templates.put("welcome", new WelcomeEmail());
        }

        // TODO: Look up `type`, then return a clone (never return the instance stored in the map).
        public static EmailTemplate getTemplate(String type) {
            return templates.get(type).clone();
        }
    }

    public static void main(String[] args) {
        EmailTemplate a = EmailTemplateRegistry.getTemplate("welcome");
        a.setContent("Hi Alice, welcome to TUF Premium!");
        a.send("alice@example.com");

        EmailTemplate b = EmailTemplateRegistry.getTemplate("welcome");
        b.setContent("Hi Bob, thanks for joining!");
        b.send("bob@example.com");

        EmailTemplate c = EmailTemplateRegistry.getTemplate("welcome");
        c.setContent("Hi Sri ");
        c.send("abc@gmail.com");
    }
}
