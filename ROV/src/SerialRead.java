
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
public class SerialRead implements Runnable {

    Semaphore semaphore;
    SerialPort serialPort;
    byte[] dataGUI = new byte[6];

    public SerialRead(Semaphore s, SerialPort sp) {
        this.semaphore = s;
        this.serialPort = sp;
    }

    public void receiveSensorValues() {

    }

    public void run() {
        try {
            while (true) {
                semaphore.acquire();
                byte[] data = serialPort.readBytes(6);
                byte[] arrangedData = checkDataArrangement(data);
                dataGUI = arrangedData;
                System.out.println("Read " + Arrays.toString(arrangedData));
                semaphore.release();
            }
        } catch (SerialPortException ex) {
        } catch (InterruptedException e) {
        }
    }
    
    public byte[] dataFromGUI(){
        return dataGUI;
    }

    public byte[] checkDataArrangement(byte[] data) {
        byte[] realData = new byte[6];
        for (int x = 0; x <= 5; x++) {
            if (data[x] == (-128)) {

                if (x == 5) {
                    realData[0] = data[x];
                    realData[1] = data[x - 5];
                    realData[2] = data[x - 4];
                    realData[3] = data[x - 3];
                    realData[4] = data[x - 2];
                    realData[5] = data[x - 1];
                } else if (x == 4) {
                    realData[0] = data[x];
                    realData[1] = data[x + 1];
                    realData[2] = data[x - 4];
                    realData[3] = data[x - 3];
                    realData[4] = data[x - 2];
                    realData[5] = data[x - 1];
                } else if (x == 3) {
                    realData[0] = data[x];
                    realData[1] = data[x + 1];
                    realData[2] = data[x + 2];
                    realData[3] = data[x - 3];
                    realData[4] = data[x - 2];
                    realData[5] = data[x - 1];
                } else if (x == 2) {
                    realData[0] = data[x];
                    realData[1] = data[x + 1];
                    realData[2] = data[x + 2];
                    realData[3] = data[x + 3];
                    realData[4] = data[x - 2];
                    realData[5] = data[x - 1];
                } else if (x == 1) {
                    realData[0] = data[x];
                    realData[1] = data[x + 1];
                    realData[2] = data[x + 2];
                    realData[3] = data[x + 3];
                    realData[4] = data[x + 4];
                    realData[5] = data[x - 1];
                } else {
                    realData = data;
                }
                System.out.println("READ real " + Arrays.toString(realData));
            }

        }
        return realData;
    }

}
