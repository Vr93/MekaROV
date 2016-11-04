
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;





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
    public UDPServerRead(int portNr) {
        this.port = portNr;
    }

    public byte[] receiveData() {
        byte[] data = new byte[5];
        try {

            DatagramSocket datagramSocket = new DatagramSocket(this.port);
            DatagramPacket packet = new DatagramPacket(data, data.length);
            datagramSocket.receive(packet);
            data = packet.getData();
        } catch (SocketException e) {
        } catch (IOException e) {
        }
        return data;
    }
}
