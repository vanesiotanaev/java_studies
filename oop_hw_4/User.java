package oop_hw_4;

public class User {
    String name;
    private Chatroom chatroom;
  
    public User(String name, Chatroom chatroom) {
      this.name = name;
      this.chatroom = chatroom;
    }

    public void setName(String value) {
        System.out.println();
        System.out.println(">>>" + " " + this.name + " changed name to " + value);
        System.out.println();
        this.name = value;
    }
  
    void printMessage(String msg) {
      System.out.printf("%s: %s\n", name, msg);
    }
  
    void sendMsg(String text) {
      chatroom.sendMessage(text, this);
    }
  }