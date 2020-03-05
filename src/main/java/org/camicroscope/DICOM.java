package org.camicroscope;

import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.display.SourceImage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DICOM {
    private static AttributeList list = new AttributeList();

    private static String getTagInformation(AttributeTag attrTag) {
        return Attribute.getDelimitedStringValuesOrEmptyString(list, attrTag);
    }

    //to print the metadata temporarily
    public static void extractData(String dicomFile) {
        String fileName = dicomFile.substring(dicomFile.lastIndexOf("/") + 1); //e.g.: 0002.DCM
        try {
            list.read(dicomFile);
            System.out.println("Transfer Syntax:" + getTagInformation(TagFromName.TransferSyntaxUID));
            System.out.println("SOP Class:" + getTagInformation(TagFromName.SOPClassUID));
            System.out.println("Modality:" + getTagInformation(TagFromName.Modality));
            System.out.println("Samples Per Pixel:" + getTagInformation(TagFromName.SamplesPerPixel));
            System.out.println("Photo Int:" + getTagInformation(TagFromName.PhotometricInterpretation));
            System.out.println("Pixel Spacing:" + getTagInformation(TagFromName.PixelSpacing));
            System.out.println("Bits Allocated:" + getTagInformation(TagFromName.BitsAllocated));
            System.out.println("Bits Stored:" + getTagInformation(TagFromName.BitsStored));
            System.out.println("High Bit:" + getTagInformation(TagFromName.HighBit));
            SourceImage img = new com.pixelmed.display.SourceImage(list);
            System.out.println("Number of frames " + img.getNumberOfFrames());
            System.out.println("Width " + img.getWidth());
            System.out.println("Height " + img.getHeight());
            System.out.println("Is Grayscale? " + img.isGrayscale());
            System.out.println("Pixel Data present:" + (list.get(TagFromName.PixelData) != null));

            //To insert data into a local Database
            //insertData(fileName,img.getHeight(),img.getWidth());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertData(String fileName, int height, int width){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dicomdata","root","root");
            Statement stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate("INSERT INTO dicom_dimensions (name,height,width) VALUES ('" + fileName + "', " + height + ", " + width + ")");
            System.out.println(rowsAffected + " images added to database.");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
