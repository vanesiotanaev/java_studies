package oop_hw_6;

import java.util.ArrayList;

public class User {
    String name;
    private Chatroom chatroom;
    ArrayList<String>friendlist = new ArrayList<String>();

    public User(String name, Chatroom chatroom) {
      this.name = name;
      this.chatroom = chatroom;
    }

    public void setName(String value) {
        System.out.println();
        System.out.println(">>>" + " " + this.name + " chanded name to " + value);
        System.out.println();
        this.name = value;
    }
  
    void printMessage(String msg) {
      System.out.printf("%s: %s\n", name, msg);
    }
  
    void sendMsg(String text) {
      chatroom.sendMessage(text, this);
    }

    void addFriend(String name) {
      System.out.println(">>> " + this.name + " added " + name + " to friend list!");
      friendlist.add(name);
    }

    void showFriendList() {
      System.out.println(this.name + "'s friends list: " + this.friendlist + " :)");
    }
  }
