//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Email email = new Email("<EMAIL>", "Welcome to Java!", "Hello, welcome to Java!");
//        Email copy = new Email(email);
//        copy.display();



        PremiumEmail premiumEmail = new PremiumEmail("<EMAIL>", "Welcome to Java!", "Hello, welcome to Java!", "<EMAIL>", "<EMAIL>");



        PremiumEmail copy = premiumEmail.copy();
        copy.setBody("Hello, Welcome to Copy Java");
        copy.display();

    }
}