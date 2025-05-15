Server side: (Server.java)
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
private static final int PORT=1721;
public void downFile(String fileName) {
try {
ServerSocket serverSocket = new ServerSocket(PORT);
Socket socket = serverSocket.accept();
System.out.println("Establish a socket link");
DataInputStream inputStream = new DataInputStream(new
BufferedInputStream(socket.getInputStream()));
byte[] buf = new byte[1024];
DataOutputStream fileOut = new DataOutputStream(new BufferedOutputStream(new
FileOutputStream(fileName)));
System.out.println("Start receiving files!" + "\n");
while ((inputStream.read(buf))!=-1) {
fileOut.write(buf, 0,buf.length);
}
System.out.println("Received, save the file as" + fileName);
fileOut.close();
} catch (Exception e) {
System.out.println("Error receiving message");
return;
}
}
public static void main(String[] args) {
Server server=new Server();
server.downFile("copy.txt");
} }