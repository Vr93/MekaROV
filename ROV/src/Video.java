
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vegard
 */
public class Video {

    Mat mat = new Mat();
    BufferedImage image;
    byte[] dat;

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    //Mat2Image mat2Img = new Mat2Image();
    
    Mat frame = new Mat();
    VideoCapture video = new VideoCapture();
    public Video(int videoNr) {
        video.open(videoNr);
    }

    public BufferedImage getOneFrame() {
        video.read(frame);
        BufferedImage img = matToBufferedImage(frame);
        return img;
    }

    public int getVideoWidth() {
        double w = video.get(3);
        int width = (int) w;
        return width;
    }

    public int getVideoHeight() {
        double h = video.get(4);
        int height = (int) h;
        return height;
    }

    public BufferedImage matToBufferedImage(Mat matrix) {
        int cols = matrix.cols();
        int rows = matrix.rows();
        int elemSize = (int) matrix.elemSize();
        byte[] data = new byte[cols * rows * elemSize];
        int type;

        matrix.get(0, 0, data);

        switch (matrix.channels()) {
            case 1:
                type = BufferedImage.TYPE_BYTE_GRAY;
                break;

            case 3:
                type = BufferedImage.TYPE_3BYTE_BGR;

                // bgr to rgb
                byte b;
                for (int i = 0; i < data.length; i = i + 3) {
                    b = data[i];
                    data[i] = data[i + 2];
                    data[i + 2] = b;
                }
                break;

            default:
                return null;
        }

        BufferedImage image = new BufferedImage(cols, rows, type);
        image.getRaster().setDataElements(0, 0, cols, rows, data);

        return image;
    }
    
    public byte[] getByteArrayImage()
    {
        byte[] imageBytes = new byte[35000];
        try{
        BufferedImage image = getOneFrame();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        baos.flush();
        imageBytes = baos.toByteArray();
        
        }
        catch(IOException e)
        {
            
        }
        return imageBytes;
    }
    
    public byte[] addIdToByteArray(int Id, byte[] inputArray) {
        byte[] idTag = new byte[1];
        idTag[0] = (byte) Id;
        byte[] byteArrayWithId = new byte[idTag.length + inputArray.length];
        System.arraycopy(idTag, 0, byteArrayWithId, 0, idTag.length);
        System.arraycopy(inputArray, 0, byteArrayWithId, idTag.length, inputArray.length);

        return byteArrayWithId;
    }
}
