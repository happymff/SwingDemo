import java.io.*;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        try {
            writeByteToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            readByteFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------");
        try {
            writeCharToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            readCharFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeByteToFile() throws IOException {
        String hello= new String( "您好。hello word!");
        byte[] byteArray= hello.getBytes();
        File file= new File( "/Users/mff/Desktop/test.txt");
        //因为是用字节流来写媒介，所以对应的是OutputStream
        //又因为媒介对象是文件，所以用到子类是FileOutputStream
        OutputStream os= new FileOutputStream( file);
        os.write( byteArray);
        os.close();
    }
    public static void readByteFromFile() throws IOException{
        File file= new File( "/Users/mff/Desktop/test.txt");
        byte[] byteArray= new byte[( int) file.length()];
        //因为是用字节流来读媒介，所以对应的是InputStream
        //又因为媒介对象是文件，所以用到子类是FileInputStream
        InputStream is= new FileInputStream( file);
        int size= is.read( byteArray);
        System. out.println( "大小:"+size +";内容:" +new String(byteArray));
        is.close();
    }
    public static void writeCharToFile() throws IOException{
        String hello= new String( "您好。hello word!");
        File file= new File( "/Users/mff/Desktop/test1.txt");
        //因为是用字符流来读媒介，所以对应的是Writer，又因为媒介对象是文件，所以用到子类是FileWriter
        Writer os= new FileWriter( file);
        os.write( hello);
        os.close();
    }
    public static void readCharFromFile() throws IOException{
        File file= new File( "/Users/mff/Desktop/test1.txt");
        //因为是用字符流来读媒介，所以对应的是Reader
        //又因为媒介对象是文件，所以用到子类是FileReader
        Reader reader= new FileReader( file);
        System.out.println(( int) file.length());
        char [] byteArray= new char[( int) file.length()];
        int size= reader.read( byteArray);
        System. out.println( "大小:"+size +";内容:" +new String(byteArray));
        reader.close();
    }
}
