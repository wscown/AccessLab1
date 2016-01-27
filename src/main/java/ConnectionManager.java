import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wscown on 1/24/16.
 */
public class ConnectionManager {

    private static int numberOfConnections = 0;
    private static final int MAXCONNECTIONS = 3;
    private static ArrayList<Connection> connections = new ArrayList<Connection>();

    public static void main(String[] args) {
        connectManagerTest();
    }

    public static void connectManagerTest(){

        addConnection(7000, new int[] {153, 2, 76, 654});

        addConnection(7001, new int[] {803, 345, 8, 332});

        addConnection(7002, new int[] {125, 2, 56, 654});

        printConnections();

        removeConnection(0);

        printConnections();
    }

    private static Connection makeConnection(int portNumber, int[] IPAddress){
        if(numberOfConnections < MAXCONNECTIONS){
            numberOfConnections++;
            return Connection.makeConnection(portNumber, IPAddress);
        }else{
            return null;
        }
    }

    private static void addConnection(int portNumber, int[] IPAddress){
        Connection temp = makeConnection(portNumber, IPAddress);

        if(temp != null) {
            connections.add(temp);
        }
    }

    private static void removeConnection(int index){
        connections.remove(index);
    }

    private static void printConnections(){
        System.out.println("\nCurrent connections as follows:");
        for(Connection c: connections){
            System.out.println(c);
        }
    }
}

class Connection{

    private int portNumber;
    private int[] IPAddress = new int[] {0, 0, 0, 0};

    private Connection(int portNumber, int[] IPAddress){
        this.portNumber = portNumber;
        this.IPAddress = IPAddress;
    }

    static Connection makeConnection(int portNumber, int[] IPAddress){
        return new Connection(portNumber, IPAddress);
    }

    void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    void setIPAddress(int[] IPAddress) {
        this.IPAddress = IPAddress;
    }

    int getPortNumber() {
        return portNumber;
    }

    int[] getIPAddress() {
        return IPAddress;
    }

    public String toString(){
        return "Port number: " + portNumber + ", IPAddress: " + Arrays.toString(IPAddress);
    }
}
