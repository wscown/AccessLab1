import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by wscown on 1/24/16.
 */
public class ConnectionSpec {

    Connection a = Connection.makeConnection(7000, new int[] {1,2,3,4});
    Connection b = Connection.makeConnection(7000, new int[] {1,2,3,4});

    @Test
    public void testmakeConnection() {
        /*
        static Connection makeConnection(int portNumber, int[] IPAddress){
            return new Connection(portNumber, IPAddress);
        }
        */
        assertTrue("Connection.makeConnection failed to return a Collection object.", Connection.makeConnection(7000, new int[] {1,2,3,4}).getClass().equals(Connection.class));

    }

    @Test
    public void testgetsetPortNumber() {
        /*
        int getPortNumber() {
            return portNumber;
        }
        */
        a.setPortNumber(7001);
        b.setPortNumber(7002);

        int atest = a.getPortNumber();
        int btest = b.getPortNumber();

        assertEquals("Using setPortNumber with 7001 and then using getPortNumber did not return 7001", 7001, atest);
        assertEquals("Using setPortNumber with 7001 and then using getPortNumber did not return 7001", 7002, btest);
    }

    @Test
    public void testgetsetIPAddress() {
        /*
        int[] getIPAddress() {
            return IPAddress;
        }
        */

        int [] testDataA = new int[] {3,4,5,6};
        int [] testDataB = new int[] {7,8,9,10};

        a.setIPAddress(testDataA);
        b.setIPAddress(testDataB);

        int[] atest = a.getIPAddress();
        int[] btest = b.getIPAddress();

        assertArrayEquals("Using setIPAddress and then getIPAddress did not return test data", testDataA, atest);
        assertArrayEquals("Using setIPAddress and then getIPAddress did not return test data", testDataB, btest);
    }
}

