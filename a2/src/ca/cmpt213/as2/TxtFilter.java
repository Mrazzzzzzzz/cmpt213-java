package ca.cmpt213.as2;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/**
 * TxtFilter Class filter for the right type
 */

public class TxtFilter implements FileFilter {
    @Override
    public boolean accept(File pathname){
        return pathname.getAbsolutePath().toLowerCase().endsWith(".json");
    }

    public File testCorrectFile(File file, ArrayList<File> fileList){
        if(!(file.isDirectory())) {
            if(file.getAbsolutePath().toLowerCase().endsWith(".json")){
                return file;
            }
        }
        else {
            File[] newFiles = file.listFiles();
            for (File x : newFiles) {
                File correctType = testCorrectFile(x, fileList);
                if (x.getAbsolutePath().toLowerCase().endsWith(".json")) {
                    fileList.add(correctType);
                    return correctType;
                }
            }
        }
        return null;
    }
}
