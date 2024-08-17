package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileSHA256Calculator {

    public static byte[] calculateSHA256(String filePath) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        try (FileInputStream fis = new FileInputStream(filePath);
             FileChannel channel = fis.getChannel();
             DigestInputStream dis = new DigestInputStream(fis, digest)) {
            ByteBuffer buffer = ByteBuffer.allocate(8192); // 8 KB buffer
            while (channel.read(buffer) != -1) {
                buffer.flip();
                digest.update(buffer);
                buffer.clear();
            }
            return digest.digest();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/yzl/Downloads/ubuntu-20.04.6-desktop-amd64.iso";
        try {
            byte[] sha256 = calculateSHA256(filePath);
            String sha256Hex = bytesToHex(sha256);
            System.out.println("File SHA256: " + sha256Hex);
            String sign = "510ce77afcb9537f198bc7daa0e5b503b6e67aaed68146943c231baeaab94df1";
            System.out.println("File sign: " + sign);

            System.out.println(sha256Hex.equals(sign));
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}


