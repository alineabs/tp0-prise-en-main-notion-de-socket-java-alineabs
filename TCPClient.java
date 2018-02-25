
import java.io.*;
import java.net.*;

public class TCPClient {
	public static BufferedReader getinput(Socket  s) throws IOException{
		return new BufferedReader(new InputStreamReader(s.getInputStream()));
			
	}
	public static DataOutputStream getoutput(Socket  s) throws IOException{
		return new DataOutputStream(new DataOutputStream(s.getOutputStream()));
			
	}
	
 public static void main(String args[]) throws Exception {
  String data;
  String dataInfo;
  BufferedReader receiveUserData = new BufferedReader(new InputStreamReader(System.in));
  Socket clientSocket = new Socket("localhost",6789);
  DataOutputStream sentToServer = getoutput(clientSocket);//new DataOutputStream(clientSocket.getOutputStream());
  BufferedReader inFromServer = getinput(clientSocket);//new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  data = receiveUserData.readLine();
  sentToServer.writeBytes(data + "\n");
  dataInfo = inFromServer.readLine();
  System.out.println("Received from ServerSocket : " + dataInfo + "  ; datasentandmodified");
  clientSocket.close();
 }
}