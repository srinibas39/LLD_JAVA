public class UserProfile {
    private final String username;
    private final String email;
    private final String phone;
    private final String address;
    private final String bio;
    private final String avatarUrl;

    private UserProfile(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.bio = builder.bio;
        this.avatarUrl = builder.avatarUrl;
    }

    public static class Builder {
        private final String username;
        private final String email;
        private String phone;
        private String address;
        private String bio;
        private String avatarUrl;

        public Builder(String username, String email) {
            if (username == null || username.isBlank()) {
                throw new IllegalArgumentException("username is required");
            }
            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("email is required");
            }
            this.username = username;
            this.email = email;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder bio(String bio) {
            this.bio = bio;
            return this;
        }

        public Builder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this);
        }
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", bio='" + bio + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
