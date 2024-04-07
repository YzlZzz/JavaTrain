package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class CodeBase64 {
    public static void main(String[] args) throws FileNotFoundException {
        String in = "E:\\CUFE\\数字取证技术\\实验4 数据流分析\\Ann的约会\\new";
        String out = "E:\\CUFE\\数字取证技术\\实验4 数据流分析\\Ann的约会\\decoded.docx";

        decodeFile(in, out);
    }

    public static String encode(String s) {
        try {
            return Base64.getEncoder().encodeToString(s.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String decode(String s) {
        byte[] res = Base64.getDecoder().decode(s);
        return new String(res);
    }

    public static void decodeFile(String inputFilePath, String outputFilePath) throws FileNotFoundException {
        try {
            String string = readFileToString(inputFilePath);
            byte[] decoded = Base64.getDecoder().decode(string);

            writeBytesToFile(outputFilePath, decoded);

            System.out.println("文件解码完毕");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void encodeFile(String inputFilePath, String outputFilePath){
        try {
            String string = readFileToString(inputFilePath);

            byte[] decoded = Base64.getEncoder().encode(string.getBytes("UTF-8"));
            writeBytesToFile(outputFilePath, decoded);

            System.out.println("文件编码完毕");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readFileToString(String filePath) throws IOException {
        // 读取文件内容为字符串
        Path path = Paths.get(filePath);
        byte[] encoded = Files.readAllBytes(path);
        return new String(encoded);
    }

    private static void writeBytesToFile(String filePath, byte[] bytes) throws IOException {
        // 将字节数组写入文件
        try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
            fos.write(bytes);
        }
    }
}
