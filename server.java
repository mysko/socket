old	new	
...	...	@@ -0,0 +1,61 @@
	1	+package sk.mysko.Sockets;
	2	+
	3	+import java.io.BufferedReader;
	4	+import java.io.IOException;
	5	+import java.io.InputStreamReader;
	6	+import java.net.ServerSocket;
	7	+import java.net.Socket;
	8	+import java.util.ArrayList;
	9	+
	10	+public class Server {
	11	+
	12	+	private ServerSocket serverSocket;
	13	+	private ArrayList<BufferedReader> clientReaders;
	14	+	
	15	+	public static void main(String[] args) {
	16	+		Server server = new Server();
	17	+
	18	+	}
	19	+	
	20	+	public Server(){
	21	+		try {
	22	+			this.serverSocket = new ServerSocket(25565);
	23	+			this.clientReaders = new ArrayList<BufferedReader>();
	24	+			
	25	+			this.listen();
	26	+		} catch (IOException e) {
	27	+			// TODO Auto-generated catch block
	28	+			e.printStackTrace();
	29	+		}
	30	+	}
	31	+	
	32	+	public void listen(){
	33	+		Thread acceptThread = new Thread(new Runnable(){
	34	+			public void run(){
	35	+				while(true){
	36	+					try{
	37	+					Socket client = serverSocket.accept();
	38	+					clientReaders.add(new BufferedReader(new InputStreamReader(client.getInputStream())));
	39	+					System.out.println("Klient sa pripojil");
	40	+					} catch(IOException e){
	41	+						e.printStackTrace();
	42	+					}
	43	+				}
	44	+			}
	45	+		});
	46	+		
	47	+		acceptThread.start();
	48	+		
	49	+		while(true){
	50	+			for(BufferedReader in : this.clientReaders){
	51	+				try {
	52	+					System.out.println(in.readLine());
	53	+				} catch (IOException e) {
	54	+					// TODO Auto-generated catch block
	55	+					e.printStackTrace();
	56	+				}
	57	+			}
	58	+		}
	59	+	}
	60	+}
	61	+
