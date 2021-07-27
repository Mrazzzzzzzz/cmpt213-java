package ca.cmpt213.as2;

import java.io.*;

/**
 * TokimonProcessor Class runs for testing
 */

public class TokimonProcessor {
    public static void main(String[] args) throws IOException {
        readfile readJsonFiles = new readfile();
        readJsonFiles.readFileIntoList();

        OrganizingData teamData = new OrganizingData();
        OrganizingData.OrganizeData();

        String heading = "Team#, From Toki, To Toki, , Score, Comment, , Extra";
        String fileName = "team_info.csv";

        OutputData.CsvFilesData(heading, fileName);
    }
}

