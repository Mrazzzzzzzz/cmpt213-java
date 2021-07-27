package ca.cmpt213.as2;

import java.util.ArrayList;

/**
 * OrganizingData Class organize the data in the file
 */

public class OrganizingData{
    public static ArrayList<Tokimon> teamData = new ArrayList<>();

    public static void OrganizeData(){
        while(!(readfile.filesData.size() == 0)){
//            System.out.println("file size: " + readfile.filesData.size());
            int teamMember = 0;
            int firstMember = 0;
            int Index = readfile.filesData.get(teamMember).team.get(firstMember).getId().indexOf("-");
            String teamNumber = readfile.filesData.get(teamMember).team.get(firstMember).getId().substring(Index+1, Index+3).trim();
            int sameTeamMember = 0;
            while(sameTeamMember < readfile.filesData.size()){
                firstMember = 0;
                Index = readfile.filesData.get(sameTeamMember).team.get(firstMember).getId().indexOf("-");
                teamNumber = readfile.filesData.get(sameTeamMember).team.get(firstMember).getId().substring(Index+1, Index+3).trim();
                if(teamNumber.equalsIgnoreCase(teamNumber)){
                    teamData.add(readfile.filesData.get(sameTeamMember));
                    readfile.filesData.remove(sameTeamMember);
                }
                sameTeamMember++;
            }
        }
    }
}
