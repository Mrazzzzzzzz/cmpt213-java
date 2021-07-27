package ca.cmpt213.as2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * OutputData Class output data into a csv file
 * reference: https://gitlab.com/aryanarora9638/tokimon-processor-cmpt213-ca2/-/blob/master/src/ca/cmpt213/as2/WriteCsvFiles.java
 */

public class OutputData {

    public static void CsvFilesData(String heading, String fileName) throws IOException {
        FileWriter fileWriter = null;

        try{
            fileWriter = new FileWriter(fileName);
            fileWriter.append(heading + "\n");

            char teamMember = 'a';
            for (int teamItem = 0 ; teamItem < OrganizingData.teamData.size(); teamItem++) {
                int firstItemOfTheTeam = 0;
                char newTeamMember = getTeamNumber(teamItem, OrganizingData.teamData).charAt(1);
                if (newTeamMember == teamMember) {
                    fileWriter.append("\n");
                } else {
                    fileWriter.append("Team" + newTeamMember + "\n");
                    teamMember = newTeamMember;
                }
                System.out.println("Team number is - " + teamMember);

                for (int memberInfo = 0; memberInfo < OrganizingData.teamData.get(teamItem).team.size(); memberInfo++) {
                    if (memberInfo >= 0) {
                        fileWriter.append("" + ",");
                        System.out.println("Captain is - " + OrganizingData.teamData.get(teamItem).team.get(firstItemOfTheTeam).getId());
                        fileWriter.append(OrganizingData.teamData.get(teamItem).team.get(firstItemOfTheTeam).getId() + ",");
                        fileWriter.append(OrganizingData.teamData.get(teamItem).team.get(memberInfo).getId() + "," + "" + ",");
                        fileWriter.append(OrganizingData.teamData.get(teamItem).team.get(memberInfo).getScore() + ",");
                        fileWriter.append(OrganizingData.teamData.get(teamItem).team.get(memberInfo).getComment() + "," + "" + "," + "\n");
                    }
                }
                fileWriter.append("" + ",");
                fileWriter.append(OrganizingData.teamData.get(teamItem).team.get(firstItemOfTheTeam).getId() + "," + "-" + "," + "" + ",");
                fileWriter.append(OrganizingData.teamData.get(teamItem).team.get(firstItemOfTheTeam).getScore() + ",");
                fileWriter.append(OrganizingData.teamData.get(teamItem).team.get(firstItemOfTheTeam).getComment() + "," + "" + ",");
                fileWriter.append(OrganizingData.teamData.get(teamItem).getExtraComments() + "\n");
            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("General I/O exception: " + e.getMessage());
                e.printStackTrace();
            }

        }
    }

    public static String getTeamNumber(int teamItem, ArrayList<Tokimon> filesData){
        String teamNumber = "";
        int firstItemOfTheTeam = 0;
        int startIndex = filesData.get(teamItem).team.get(firstItemOfTheTeam).getId().indexOf("-");
        teamNumber = filesData.get(teamItem).team.get(firstItemOfTheTeam).getId().substring(startIndex+1, startIndex+3).trim();
        return teamNumber;
    }
}
