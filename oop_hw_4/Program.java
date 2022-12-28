package oop_hw_4;

public class Program {

    public static void main(String[] args) {
      Chat gb = new Chat();
  
      User client1 = new User("Ivan", gb);
      User client2 = new User("Sergey", gb);
      User client4 = new User("Stanley", gb);
  
      gb.appendClient(client1);
      gb.appendClient(client2);
      gb.appendClient(client4);
  
      client1.sendMsg("Hello!");
  
      client2.sendMsg("Greetings!");
  
      User client3 = new User("Nick", gb);
      gb.appendClient(client3);
  
      client3.sendMsg("Good evening!");
  
      client4.sendMsg("How are you?");
  
      client4.setName("Creed");
      client4.sendMsg("I changed my name!)");
    }
  }
  
  interface Chatroom {
      void sendMessage(String msg, User user);
    
      void appendClient(User user);
    }