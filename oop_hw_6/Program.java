package oop_hw_6;

public class Program {

    public static void main(String[] args) {
      Chat gb = new Chat();
  
      User client1 = new User("Lena", gb);
      User client2 = new User("Kostya", gb);
      User client4 = new User("Irina", gb);
  
      gb.appendClient(client1);
      gb.appendClient(client2);
      gb.appendClient(client4);
  
      client1.sendMsg("Hello!");
  
      client2.sendMsg("Hey!");
  
      User client3 = new User("Ivan", gb);
      gb.appendClient(client3);
  
      client3.sendMsg("Good day!");
  
      client4.sendMsg("How are you? =)");
  
      client4.setName("Sveta");
      client4.sendMsg("I changed my name!)");
      client3.sendMsg("Hello there!");
      client3.addFriend("Sveta");
      client3.showFriendList();
      client2.addFriend("Irina");
      client2.addFriend("Kostya");
      client2.showFriendList();
    }
  }
  
  interface Chatroom {
      void sendMessage(String msg, User user);
    
      void appendClient(User user);
    }