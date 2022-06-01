import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        while(true) {
            try(FileReader firstcode = new FileReader("firstcode.txt");
                FileWriter second = new FileWriter("second.txt")) {
                int count = 0;
                String text = "";
                while ((count = firstcode.read()) != -1) {
                    text += (char) count;
                }
                String b = text.replaceAll("\\//.+", "");
                String c = b.replaceAll("\\/\\*([\\S\\s]+)\\*\\/", "");
                second.write(c);
                second.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}