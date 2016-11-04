
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
public class DataHandler {
    
    private boolean threadStatus;
    
    
    
    public DataHandler(){
        
    }
    
    
    
    public boolean shouldThreadRun() {
        return threadStatus;
    }

    /**
     * Sets the threads status
     *
     * @param threadStatus Thread status
     */
    public void setThreadStatus(boolean threadStatus) {
        this.threadStatus = threadStatus;
    }
    
    public void getROVcontroller(){
        UDPServerRead udpReceive = new UDPServerRead(9876);
        byte[] data = udpReceive.receiveData();
        System.out.println(Arrays.toString(data));
    }
    
    
    
}
