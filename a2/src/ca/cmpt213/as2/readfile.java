package ca.cmpt213.as2;

import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * readfile Class read the file in correct type
 */

public class readfile {
    public static ArrayList<File> fileList = new ArrayList<>();
    public static ArrayList<Tokimon> filesData = new ArrayList<>();

    private static void dumpFiles(ArrayList<File> fileList) throws FileNotFoundException {
        JsonParser parser = new JsonParser();

        for(File subFile : fileList){
//            System.out.println(" file: " + subFile.getAbsolutePath());
            Tokimon firstTokimon = new Tokimon();
            JsonObject obj = (JsonObject)parser.parse(new FileReader(subFile));
            JsonArray arr = (JsonArray) obj.getAsJsonObject().get("team");
            for (JsonElement x : arr) {
//                System.out.println("New tokimon added");
                JsonObject tokimon = (JsonObject) x;
                String name = tokimon.getAsJsonObject().get("name").getAsString();
                String id = tokimon.getAsJsonObject().get("id").getAsString();
                double score = tokimon.getAsJsonObject().get("compatibility").getAsJsonObject().get("score").getAsDouble();
                String comment = tokimon.getAsJsonObject().get("compatibility").getAsJsonObject().get("comment").getAsString();
                firstTokimon.addMember(name, id, score, comment);
            }
            String extra_comments = obj.getAsJsonObject().get("extra_comments").getAsString();
            firstTokimon.setExtraComments(extra_comments);
//            System.out.println("extra comment: " + extra_comments);
//            System.out.println("All Tokimons added");
            filesData.add(firstTokimon);
        }
    }

    public void readFileIntoList() throws FileNotFoundException{
        TxtFilter filter = new TxtFilter();
        File testFile = new File("testdata/InputTestDataSets");
        filter.testCorrectFile(testFile, fileList);
        dumpFiles(fileList);
    }
}

