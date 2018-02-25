
import java.io.*;
import java.net.*;

public class TCPServer {
	public static BufferedReader getinput(Socket  s) throws IOException{
		return new BufferedReader(new InputStreamReader(s.getInputStream()));
			
	}
	public static DataOutputStream getoutput(Socket  s) throws IOException{
		return new DataOutputStream(new DataOutputStream(s.getOutputStream()));
			
	}
 public static void main(String args[]) throws Exception {
  String clientSentence;
  String capitalizedSentence;
 ServerSocket welsocket=new ServerSocket(6789);
  while (true) {
    Socket connectionSocket = welsocket.accept();
    BufferedReader ReceiveFromClient =getinput(connectionSocket);//new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
     DataOutputStream sendToClient = getoutput(connectionSocket);//new DataOutputStream(connectionSocket.getOutputStream());
   clientSentence = ReceiveFromClient.readLine();
    System.out.println("Received: " + clientSentence);
   capitalizedSentence = clientSentence.toUpperCase();
  int numofCar= capitalizedSentence.length();
  String sen=capitalizedSentence + "  project client- serveurTCP " + "\n";
   
   sendToClient.writeBytes(" Bonjour" + "le mot envoye par le client" +" " +clientSentence + " contient " + numofCar+ " lettres  ;" + sen);
  }
 }
}