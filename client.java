old	new	
...	...	@@ -0,0 +1,49 @@
	1	+package sk.mysko.Sockets;
	2	+
	3	+import java.io.BufferedWriter;
	4	+import java.io.IOException;
	5	+import java.io.OutputStreamWriter;
	6	+import java.net.Socket;
	7	+import java.net.UnknownHostException;
	8	+
	9	+public class Client {
	10	+	
	11	+	private Socket clientSocket;
	12	+	
	13	+	public static void main(String[] args){
	14	+		Client client = new Client();
	15	+	}
	16	+	
	17	+	public Client(){
	18	+		try {
	19	+			this.clientSocket = new Socket("localhost", 25565);
	20	+		} catch (UnknownHostException e) {
	21	+			// TODO Auto-generated catch block
	22	+			e.printStackTrace();
	23	+		} catch (IOException e) {
	24	+			// TODO Auto-generated catch block
	25	+			e.printStackTrace();
	26	+		}
	27	+		
	28	+		
	29	+		try {
	30	+			BufferedWriter	out = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));
	31	+			int counter = 1;
	32	+		
	33	+		while(true){
	34	+			String temp = "Toto je " + counter +". sprava pre socket tutorial.";
	35	+			out.write(temp + "\r\n");
	36	+			out.flush();
	37	+			counter++;
	38	+			try{
	39	+				Thread.sleep(5000);
	40	+			} catch(InterruptedException e){
	41	+				e.printStackTrace();
	42	+			}
	43	+		}
	44	+		} catch(IOException e){
	45	+			e.printStackTrace();
	46	+		}
	47	+}
	48	+}
	49	+
