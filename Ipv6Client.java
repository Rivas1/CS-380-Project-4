import java.io.*;
import java.net.*;

public class Ipv6Client
{
	public static void main ( String[] args ) throws IOException
	{
		try
		{
			byte[] serverResponse = new byte[100];
			String[] hexCodes = new String[100];
			StringBuilder s = new StringBuilder();
			Socket socket = new Socket ("codebank.xyz", 38004);
			if ( socket.isConnected() )
				System.out.println("Connected!");

			// Server to client stream
			InputStream IS = socket.getInputStream(); 
			// Client to server stream
			PrintStream PS = new PrintStream( socket.getOutputStream() ); 
			// Send to server
			PS.println(0x6);
			
			// Receive server's response (pending function)
			for ( int i = 0; i < 4; i++ )
			{
				serverResponse[i] = (byte) IS.read();
				// hexCodes[i] = Integer.toHexString( serverResponse[i] );
				// System.out.println( hexCodes[i] );
				s.append(String.format("%02X", ));
			}

			System.out.println( "Error code: " + s.toString() );
		}
		catch ( IOException e )
		{ e.printStackTrace(); }
	}
}