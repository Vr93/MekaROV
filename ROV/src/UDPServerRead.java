
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vegard
 */
public class UDPServerRead {

    int port;
    DatagramSocket datagramSocket;

    public UDPServerRead(int portNr) throws SocketException {
        this.port = portNr;
        datagramSocket = new DatagramSocket(this.port);
    }

    public byte[] receiveControllerData() {
       byte[] data = new byte[6];
        try {    
            DatagramPacket packet = new DatagramPacket(data, data.length);
            datagramSocket.receive(packet);
            data = packet.getData();
            //System.out.println("FROM GUI " + Arrays.toString(data));
        }//System.out.println(Arrays.toString(data));
        catch (SocketException e) {
            System.out.println("uhdfuhdf");
        } catch (IOException e) {
            System.out.println("usjxjxj");
        }
        return data;
    }
    
   public boolean portIsOpen(){
       boolean isOpen = false;
       if(datagramSocket.isConnected()){
           isOpen = true;
       }
       return isOpen;
   }
    //return data;
}
