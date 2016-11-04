
import java.util.Arrays;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import java.util.concurrent.Semaphore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vegard
 */
public class JSSCSerialRead implements Runnable {
    
    Semaphore semaphore;
    SerialPort serialPort;
    public JSSCSerialRead(Semaphore s,SerialPort sp) {
        this.semaphore = s;
        this.serialPort = sp;
    }

    public void receiveSensorValues() {

    }

    public void run() {
        try {
            while(true){
            semaphore.acquire();
            //System.out.println("READ");
            //getSerialPort().addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);
            byte[] data = serialPort.readBytes(3);
                System.out.println("READ " + Arrays.toString(data));
              
                
            semaphore.release();
            }
        } 
        catch (SerialPortException ex) {
            System.out.println("There are an error on writing string to port т: " + ex);
        } 
        catch (InterruptedException e) {
        }
        

        //return dataByteArray;
    }
/*
    private class PortReader implements SerialPortEventListener {

        @Override
        public void serialEvent(SerialPortEvent event) {
            if (event.isRXCHAR() && event.getEventValue() > 0) {
                try {
                    byte[] data = getSerialPort().readBytes(3);
                    System.out.println(Arrays.toString(data));
                } catch (SerialPortException ex) {
                    System.out.println("Error in receiving string from COM-port: " + ex);
                }

            }

        }

    }*/
}
