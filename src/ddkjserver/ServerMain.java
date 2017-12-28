 package ddkjserver;  
     
 import java.net.ServerSocket;  
 import java.net.Socket;  
   
 public class ServerMain {  
     public static void main(String[] args) throws Exception{  
         //Server listening the TCP request on port 50006  
         ServerSocket server = new ServerSocket(50006);  
         Socket client = null;  
         boolean f = true;  
         while(f){  
             //Waiting for client connect  
             client = server.accept();  
             System.out.println("Client Connection Successful!");  
             //Open a thread for each client connect  
             new Thread(new ServerThread(client)).start();  
         }  
         server.close();  
     }  
}  