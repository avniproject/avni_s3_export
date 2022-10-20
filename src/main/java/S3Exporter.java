import java.io.File;
import java.nio.file.InvalidPathException;

public class S3Exporter {


    public static void S3Export(Address address, S3Data s3Data, int counter, MetaData metaData, String columnName) {
        String basePath = "/Users/sachink/project/s3data/";
        String imagePath = "/Users/sachink/avni/avni-s3-export/src/main/resources/images/";
        File newPath = new File(basePath + address.getState() + "/" + address.getDistrict() + "/" + address.getTaluka() + "/" + address.getGpVillage() + "/" + address.getDam() + "/");
        createDirectory(newPath);
        CopyFile.copy(s3Data, imagePath, newPath, counter, metaData, columnName);
    }

    private static void createDirectory(File newFile) {
        try {
            newFile.mkdirs();
        } catch (InvalidPathException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }


}
