import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CopyFile {
    public static void copy(S3Data s3Data, String imagePath, File newPath, int counter, MetaData metaData, String columnName) {
        String fileName = s3Data.getS3Url().substring(s3Data.getS3Url().length() - 40);

        Path srcPath = Paths.get(imagePath + fileName);
        Path destPath = Paths.get(String.valueOf(newPath) + fileName);
        try {
            Files.copy(srcPath, destPath);
            renameFile(newPath, metaData, fileName, destPath, columnName);
            System.out.println("file copied to ------------------> " + destPath);
            System.out.println("Total file copied for " + columnName + " ==> " + counter);
        } catch (IOException e) {
            System.out.println("Error while copying " + e);
        }
    }

    private static void renameFile(File newPath, MetaData metaData, String imageName, Path destPath, String columnName) {
        File file = new File(String.valueOf(destPath));
        file.renameTo(new File(String.valueOf(newPath) + "/" + columnName + "-" + metaData.getFirstName() + "-" + metaData.getDateCreated() + imageName.substring(imageName.length() - 4)));
    }
}
