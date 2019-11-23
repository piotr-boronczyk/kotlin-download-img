import java.io.*;
import java.net.URL;

public class ImageFromUrl {
    public static void saveImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        String fileName = url.getFile();
        String destName = fileName.substring(fileName.lastIndexOf("/")).substring(1);

        System.out.println(destName);

        InputStream is = url.openStream();
        try{
            FileOutputStream os = new FileOutputStream(destName);
            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
