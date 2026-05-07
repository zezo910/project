package com.example.project;

public class User {

        private String identifier;
        private String password;
        private String role;

        // Constructor
        public User(String identifier, String password, String role) {
            this.identifier = identifier;
            this.password = password;
            this.role = role;
        }

        // Getters
        public String getIdentifier() {
            return identifier;
        }
        public String getPassword() {
            return password;
        }
        public String getRole() {
            return role; }
        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public void setRole(String role) {
            this.role = role;
        }

}
