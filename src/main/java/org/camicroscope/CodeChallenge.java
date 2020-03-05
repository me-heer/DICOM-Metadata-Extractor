package org.camicroscope;

import java.util.Scanner;

public class CodeChallenge {
    public static void main(String[] args) {
        System.out.println("Please enter DICOM Image Path: ");
        Scanner filePath = new Scanner(System.in);
        String dicomFile = filePath.nextLine();
        DICOM.extractData(dicomFile);
    }
}
