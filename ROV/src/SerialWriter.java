

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;

public class SerialWriter implements Runnable {
    // stream to arduino

    private OutputStream out;
    private DataHandler datahandler;
    private Semaphore semaphore;

    public SerialWriter(OutputStream out, DataHandler datahandler, Semaphore semaphore) {
        this.out = out;
        this.datahandler = datahandler;
        this.semaphore = semaphore;
    }

    public void run() {
        //try {
            while (true) {
                
                try {
                    semaphore.acquire();
                    semaphore.release();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SerialWriter.class.getName()).log(Level.SEVERE, null, ex);
                }
                /*
                //if(datahandler.checkSendDataAvailable())
                //{
                    byte[] sendByte = datahandler.getDataFromController();
                    
                    this.out.write(sendByte);
                //}*/
                System.out.println("SERIAL");
  
                
                
                //Thread.yield();
            }   
        } /*
        catch (IOException e) {
            e.printStackTrace();*/
        }
    


    

