public class NotificationSystem {
    interface NotificationSender {
        void send(String message);
    }

    static class EmailSender implements NotificationSender {
        @Override
        public void send(String message) {
            System.out.println("EMAIL: " + message);
        }
    }

    static class SmsSender implements NotificationSender {
        @Override
        public void send(String message) {
            System.out.println("SMS: " + message);
        }
    }

    static class PushSender implements NotificationSender {
        @Override
        public void send(String message) {
            System.out.println("PUSH: " + message);
        }
    }

    static class NotificationFactory {
        static NotificationSender getSender(String channel) {
            if (channel == null) {
                throw new IllegalArgumentException("Channel cannot be null");
            }

            return switch (channel.trim().toLowerCase()) {
                case "email" -> new EmailSender();
                case "sms" -> new SmsSender();
                case "push" -> new PushSender();
                default -> throw new IllegalArgumentException("Unsupported channel: " + channel);
            };
        }
    }

    public static void main(String[] args) {
        NotificationSender email = NotificationFactory.getSender("email");
        NotificationSender sms = NotificationFactory.getSender("sms");
        NotificationSender push = NotificationFactory.getSender("push");

        email.send("Welcome!");
        sms.send("Your OTP is 123456");
        push.send("New login on your account");
    }
}
