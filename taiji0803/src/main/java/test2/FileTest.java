package test2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileTest {
    public static void main(String[] args) throws IOException {
        FileTest fileTest = new FileTest();
        fileTest.createFile();
    }
    public void createFile() throws IOException {
        String filePath = "D:/a/b";
        File dir = new File(filePath);
        // 一、检查放置文件的文件夹路径是否存在，不存在则创建
        if (!dir.exists()) {
            dir.mkdirs();// mkdirs创建多级目录
        }
        File checkFile = new File(filePath + "/a.txt");
        FileWriter writer = null;
        try {
            // 二、检查目标文件是否存在，不存在则创建
            if (!checkFile.exists()) {
                checkFile.createNewFile();// 创建目标文件
            }
            // 三、向目标文件中写入内容
            // FileWriter(File file, boolean append)，append为true时为追加模式，false或缺省则为覆盖模式
            writer = new FileWriter(checkFile, true);
            writer.append("Hello world");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer)
                writer.close();
        }
    }
}
