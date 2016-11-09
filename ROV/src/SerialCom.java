
import java.io.IOException;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;
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
public class SerialCom {

    private SerialPort serialPort = new SerialPort("COM4");
    Semaphore semaPhore = new Semaphore(1,true);
    private Thread reader; // reads from arduino
    private Thread sender;  // writes to arduino
    
    public SerialCom() {
        connect(); 
    }

    public void connect() {
        try {
            if(!serialPort.isOpened()){
            serialPort.openPort();
            getSerialPort().setParams(19200, 8, 1, 0);
            reader = new Thread(new SerialRead(semaPhore,serialPort));
            sender = new Thread(new SerialSend(semaPhore,serialPort));
            sender.start();
            reader.start(); 
            }  
        } catch (SerialPortException e) {
        }
    }

    public SerialPort getSerialPort() {
        return this.serialPort;
    }

    public String[] getPortList() {
        String[] portNames = SerialPortList.getPortNames();

        if (portNames.length == 0) {
            System.out.println("There are no serial-ports :( You can use an emulator, such ad VSPE, to create a virtual serial port.");
            System.out.println("Press Enter to exit...");
            try {
                System.in.read();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        for (int i = 0; i < portNames.length; i++) {
            System.out.println(portNames[i]);
        }
        return portNames;
    }
    
    public Semaphore getSemaphore(){
        return semaPhore;
    }

}
