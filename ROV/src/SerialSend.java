
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.concurrent.Semaphore;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import jssc.*;
/**
 *
 * @author vegard
 */
public class SerialSend implements Runnable{


     Semaphore semaphore;
     SerialPort serialPort;
     
    public SerialSend(Semaphore s,SerialPort sp) {
        this.semaphore = s;
        this.serialPort = sp;
    }
    
    public void run() {
        try { 
            while(true){
            semaphore.acquire();
            byte[] test = {-128,101,102,103,104,105};
            System.out.println("SEND" + Arrays.toString(test));
           serialPort.writeBytes(test); 
           semaphore.release();
            }
        } 
        catch (SerialPortException ex) {
            System.out.println("There are an error on writing string to port т: " + ex);
        }
        catch(InterruptedException e){
        }
        
    }
    }

   /*
     private class PortReader implements SerialPortEventListener {
         //byte[] byteArray;
         int test;
         public PortReader()
         {
             this.test = byteArray;
         }
    
    @Override
    public void serialEvent(SerialPortEvent event) {
        if(event.isRXCHAR() && event.getEventValue() > 0) {
            try {
                //String receivedData = serialPort.readString(event.getEventValue());
                //String receivedData = getSerialPort().readString(event.getEventValue());
                //getSerialPort().writeBytes(byteArray);
                getSerialPort().writeInt(test);
            }
            catch (SerialPortException ex) {
                System.out.println("Error in receiving string from COM-port: " + ex);
            }
        }
    }*/
    
   
    


