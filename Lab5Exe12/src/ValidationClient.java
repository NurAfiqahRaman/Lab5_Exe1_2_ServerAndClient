import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ValidationClient {
	public static void main(String[]args) {
		
		try {
			//Connect to the server at localhost, port 1221
			Socket socket=new Socket (InetAddress.getLocalHost(),1000);
			
			//Create input stream
			BufferedReader bufferedReader=new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			//Read from the network and display 
			
			String name =bufferedReader.readLine();
			System.out.println("product name: "+name);
			int id = bufferedReader.read();
			System.out.println("\nProduct Id : "+id);
			
			
			//Close everything
			bufferedReader.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
