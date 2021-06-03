package java_io;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * FileTest
 * 磁盘操作：File
 *
 * @author lijunsong
 * @date 2021/5/25 14:03
 * @since 1.0
 */
@Slf4j
public class FileTest {
    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            log.info("is file : {}", dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }

        /**
         * 从 Java7 开始，可以使用 Paths 和 Files 代替 File
         *  java.nio.file.DirectoryStream;
         *  java.nio.file.FileSystem;
         *  java.nio.file.FileSystems;
         *  java.nio.file.Files;
         *  java.nio.file.Path;
         *  java.nio.file.Paths;
         *  java.nio.file.attribute.FileAttribute;
         *  java.nio.file.attribute.PosixFilePermission;
         *  java.nio.file.attribute.PosixFilePermissions;
         * 等等，来取代原来的基于java.io.File的文件IO操作方式.
         */

    }

    public static void main(String[] args) {
        listAllFiles(new File("D:\\download"));
    }
}
