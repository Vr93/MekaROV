
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vegard
 */
public class DataHandler {

    UDPServerRead reader;

    public DataHandler() {

    }

    public void initializeReaderPort(int port) {
        try {
            reader = new UDPServerRead(port);
        } catch (SocketException e) {
        }
    }

    public boolean checkOpenPort() {
        boolean isOpen = false;
        if (reader.portIsOpen()) {
            isOpen = true;
        }
        return isOpen;
    }

    public byte[] getDataFromGUI() {
        byte[] data = new byte[6];
        data = reader.receiveControllerData();
        return data;
    }

}
