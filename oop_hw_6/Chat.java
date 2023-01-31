package oop_hw_6;

import java.util.*;

public class Chat implements Chatroom {

    ArrayList<User> users = new ArrayList<>();
  
    @Override
    public void sendMessage(String text, User me) {
  
      for (User user : users) {
        if (user.name == me.name) {
          user.printMessage(text);
        }
      }
    }
    @Override
    public void appendClient(User client) {
      System.out.println("\n >>> Зашел новый пользователь! " + client.name);
      System.out.println();
      users.add(client);
  
    }
}  