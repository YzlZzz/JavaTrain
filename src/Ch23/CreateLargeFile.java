package Ch23;

import java.io.*;

public class CreateLargeFile {
    public static void main(String[] args) throws Exception{
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("largeData.dat")));
        for(int i = 0; i < 2000000; i++){
            output.writeInt((int) (Math.random() * 5000000));
        }

        output.close();

        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("largeData.dat")));
        for(int i = 0; i < 100; i++){
            System.out.print(input.readInt() + " ");
        }

        input.close();
    }
}
