import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vegard
 */
public class UDPServerSend {

    //Image image = new Image();
    Video video1 = new Video(0);
   // Video video2 = new Video(1);

    public UDPServerSend() {

    }

    public void sendVideo(String iNetAddress) {
        while (true) {
            try {
                //byte[] imageBytes1 = video1.getByteArrayImage();
                //System.out.println(imageBytes1.length);
                DatagramSocket ds = new DatagramSocket();
                InetAddress ia = InetAddress.getByName(iNetAddress);
                //DatagramPacket packet1 = new DatagramPacket(imageBytes1, imageBytes1.length, ia, 9876);
                //ds.send(packet1);
            } catch (SocketException e) {

            } catch (UnknownHostException e) {

            } catch (IOException e) {

            }

        }
    }
    
    public void sendData(String iNetAddress) {
        while (true) {
            try {
                //byte[] imageBytes1 = video1.getByteArrayImage();
                //System.out.println(imageBytes1.length);
                DatagramSocket ds = new DatagramSocket();
                InetAddress ia = InetAddress.getByName(iNetAddress);
                //DatagramPacket packet1 = new DatagramPacket(imageBytes1, imageBytes1.length, ia, 9876);
                //ds.send(packet1);
            } catch (SocketException e) {

            } catch (UnknownHostException e) {

            } catch (IOException e) {

            }

        }
    }
    
}