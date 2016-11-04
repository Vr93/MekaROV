
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

public class SerialReader implements Runnable {
    // data from arduino

    private final InputStream in;
    private final DataHandler dh;
    private final Semaphore semaphore;
    byte[] data = new byte[3];
    int count = 0;
    

    public SerialReader(InputStream in, DataHandler datahandler, Semaphore semaphore) {
        this.in = in;

        this.dh = datahandler;
        this.semaphore = semaphore;
    }

   
    @Override
    public void run() {
        while (true) {
            try {
                semaphore.acquire();
                if(in.available()>0){
                in.read(data);
                count++;
                }
                if(count == 3){
                    semaphore.release();
                }
              
                    //in.read(data);
                    System.out.println(Arrays.toString(data));
                    
                }catch (InterruptedException ex) {
                Logger.getLogger(SerialWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
                catch(IOException e){
            }
            }
        }
    
    
    
}
