package com.company.Mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args){
        TextChat chat = new TextChat();
        Admin admin = new Admin(chat);
        chat.setAdmin(admin);
        SimpleUser user1 = new SimpleUser("vasya", chat);
        SimpleUser user2 = new SimpleUser("kek", chat);
        SimpleUser user3 = new SimpleUser("lol", chat);

        chat.addUser(user1);
        chat.addUser(user2);
        chat.addUser(user3);

        user1.sendMessage("hello, gays");
        admin.sendMessage("shut up");
    }
}
//Client
interface User{
    void sendMessage(String message);
    void getMessage(String message);
}
abstract class AbstractUser implements User{
    protected Chat chat;
    protected String name;
    @Override
    public void getMessage(String message) {
        System.out.println(name + ": " + message);
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
}

class Admin extends AbstractUser{
    public Admin(Chat chat) {
        name = "Admin";
        this.chat = chat;
    }
}
class SimpleUser extends AbstractUser{
    public SimpleUser(String name ,Chat chat) {
        this.name = name;
        this.chat = chat;
    }
}
//Mediator
interface Chat{
    void sendMessage(String message, User user);
}

class TextChat implements Chat{
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) { this.admin = admin; }

    public void addUser(User user){ users.add(user); }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users){
            u.getMessage(message);
        }
        admin.getMessage(message);
    }
}


