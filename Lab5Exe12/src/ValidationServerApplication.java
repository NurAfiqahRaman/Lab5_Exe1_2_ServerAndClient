import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ValidationServerApplication {

	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(1000);
			try {
				
				ItemProduct itemProduct=new ItemProduct();
				String name="Botol_Biru ";
				
				int id=1;
				itemProduct.setItemProduct(id);
				itemProduct.setName(name);
				
				
				
				while (true) {
					
					//Accept client request for connection
					Socket clientSocket=ss.accept();
					System.out.println("client connected");
					
					//Create stream to write data on the network
					DataOutputStream outputStream =new DataOutputStream(clientSocket.getOutputStream());
					
					//Send current data back to the client
					outputStream.writeUTF(name);
					outputStream.writeInt(id);
					
					
					//Close the socket
					clientSocket.close();

				}
				
				//Closing is not necessary because the code is unreachable
			} catch (IOException ioe) {
				if (ss!=null)
					ss.close();
				ioe.printStackTrace();
			}

		
	}
}
