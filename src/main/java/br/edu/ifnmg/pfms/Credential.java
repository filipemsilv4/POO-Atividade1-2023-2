package br.edu.ifnmg.pfms;

public class Credential {
    private Person person;
    private String email;
    private String password;
    private Boolean admin;

    public Credential(Person person, String email, String password, Boolean admin) throws Exception {
        this.setPerson(person);
        this.setEmail(email);
        this.setPassword(password);
        this.setAdmin(admin);
    }

    public void setPerson(Person person) throws Exception {
        if (person == null) {
            throw new Exception("Person cannot be null");
        }
        this.person = person;
    }

    public Person getPerson() {
        return this.person;
    }

    private void setEmail(String email) throws Exception {
        if (email == null || email.isEmpty()) {
            throw new Exception("Email cannot be null or empty");
        } else if (email.length() > 45) {
            throw new Exception("Email cannot be longer than 45 characters");
        }
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    private void setPassword(String password) throws Exception {
        if (password == null || password.isEmpty()) {
            throw new Exception("Password cannot be null or empty");
        } else if (password.length() > 45) {
            throw new Exception("Password cannot be longer than 45 characters");
        }
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean isAdmin() {
        return this.admin;
    }

    public Boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        String userType;
        if (this.admin) {
            userType = "Administrador";
        } else {
            userType = "Usuário geral";
        }
        return this.email + ", " + this.password + ", " + userType;
    }
}
