
import java.io.IOException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

/**
 *
 * @author vegard
 */
public class ROV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException {
        
        /*
        UDPServerRead test = new UDPServerRead(9876);
        while(true){
            byte[] data = 
        test.receiveControllerData();
            System.out.println("asd " + Arrays.toString(data));
        }*/
        
        DataHandler test = new DataHandler();
        test.initializeReaderPort(9876);
        while(true){
        byte[] data = test.getDataFromGUI();
            System.out.println(Arrays.toString(data));
        }
        
        
       
        
    }

}
