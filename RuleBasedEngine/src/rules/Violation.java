package rules;

public class Violation {

    private final String violationMessage;

    public Violation(String violationMessage) {
        this.violationMessage = violationMessage;
    }

    public static Violation getViolationMessage(String violationMessage) {
        return new Violation(violationMessage);
    }
}
