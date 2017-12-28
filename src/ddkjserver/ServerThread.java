package ddkjserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * This class is a multithreaded class for the server side
 */
public class ServerThread implements Runnable {
	 
	private Socket client = null;
	public ServerThread(Socket client){
		this.client = client;
	}
	
	@Override
	public void run() {
		try{
			//get Socket output stream, used for send data to client
			PrintStream out = new PrintStream(client.getOutputStream());
			//get Socket input stream£¬used for receive data from client
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			boolean flag =true;
			CommandUtil c = new CommandUtil();
			while(flag){
				//receive data from client
				String str =  buf.readLine();
				if(str == null || "".equals(str)){
					flag = false;
				}else{
					if("bye".equals(str)){
						flag = false;
					}else{
						
						String open = "C137550001000101CS1A";
						String cs = CommandUtil.cs(open.substring(0, open.length()-4));
						String commandOpen = open.replace("CS", cs);
						out.println("Data:" + commandOpen);
						
						
					}
				}
			}
			out.close();
			client.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
