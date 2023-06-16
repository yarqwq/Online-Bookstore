package com.web.bookshop.model;
import jakarta.validation.constraints.NotBlank;
import org.apache.logging.log4j.message.Message;
import org.springframework.lang.NonNull;
import java.io.Serializable;
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    @NotBlank(message= "Username is required")
    private String username;
    @NotBlank(message= "Password is required")
    private String password;
    @NotBlank(message= "Cellphone is required")
    private String cellphone;
    @NotBlank(message= "Email is required")
    private String email;
    @NotBlank(message= "Address is required")
    private String address;
    private Boolean admin;
    public User() {
    }
    public User(String id,String username, String password, String cellphone, String email, String address, Boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
        this.email = email;
        this.address = address;
        this.admin = admin;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCellphone() {
        return cellphone;
    }
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Boolean getAdmin() {
        return admin;
    }
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", admin=" + admin +
                '}';
    }
}