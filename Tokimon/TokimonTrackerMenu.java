package Documents.cmpt213.a1.Tokimon;

import java.util.Scanner;
import java.util.List;

/**
 * TokimonTrackerMenu Class provides the methods for all the display user menu and data, add or delete or alter data, check
 * for user input error and some helper methods
 */

public class TokimonTrackerMenu {
    private String title;
    private List<Tokimon> tokimons_list;


    public TokimonTrackerMenu(String title) {
        this.title = title;
    }

    public TokimonTrackerMenu(List<Tokimon> tokimons_list) {
        this.tokimons_list = tokimons_list;
    }

    public void displayMainMenu(List<Tokimon> tokimons_list){
        System.out.println("Tokimon Tracker by Mraz Chen sn 301282775");
        int num = 0;
        while(num != 6){
            System.out.println("Main Menu");
            System.out.println("1. List Tokimons\n2. Add a new Tokimon\n3. Remove a Tokimon\n4. Change Tokimon strength\n5. DEBUG: Dump objects (toString)\n6. Exit");
            num = getOption(tokimons_list);
        }
        System.exit(0);
    }

    public int getOption(List<Tokimon> tokimons_list){
        int user_input = 0;
        int flag = 0;

        while(flag == 0){
            String UserInput = userInput();
            if(!isInt(UserInput)) {
                errorException(0, 1, 6);
            }else{
                user_input = Integer.parseInt(UserInput);
                if (!(user_input > 0 && user_input < 7)) {
                    errorException(1, 1, 6);
                } else {
                    flag = 1;
                }
            }
        }
        if(user_input == 1){
            displayAllTokis(tokimons_list);
        }else if(user_input == 2){
            addNewToki(tokimons_list);
        }else if(user_input == 3){
            deleteToki(tokimons_list);
        }else if(user_input == 4){
            alterToki(tokimons_list);
        }else if(user_input == 5){
            debug(tokimons_list);
        }else if(user_input == 6){
            System.out.println("BYE!");
        }
        return user_input;
    }
    public String userInput(){
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean isInt(String str){
        if(str == null){
            return false;
        }
        try{
            Integer.parseInt(str);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean isDouble(String str){
        if(str == null){
            return false;
        }
        try{
            Double.parseDouble(str);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public void errorException(int choice, int min, int max){
        if(choice == 0){
            System.out.print("Invalid Input: Please Enter a number between " + min + " and " + max + " : ");
        }else if(choice == 1){
            System.out.print("Out of Range: Please Enter a number between " + min + " and " + max + " : ");
        }else if(choice == 2){
            System.out.println("Invalid Input: Please Enter one of the following type: Fly Fire Water Electrify Freeze");
        }else{
            System.out.print("Invalid Input");
        }

}

    public void displayAllTokis(List<Tokimon> tokimons_list){
        System.out.println("List of Tokimons:");
        if(tokimons_list.size() == 0){
            System.out.println("Current Tokimons List is empty");
        }else{
            for(int i  = 0; i < tokimons_list.size(); i++){
                System.out.println((i+1) + ". " + tokimons_list.get(i).getName() + ", " + tokimons_list.get(i).getHeight() + "m, "+ tokimons_list.get(i).getWeight() + "kg, " + tokimons_list.get(i).getType() + " ability, " + tokimons_list.get(i).getStrength() + " strength");
            }
        }
        System.out.println();
    }

    public void addNewToki(List<Tokimon> tokimons_list){
        if(tokimons_list.size() == 300){
            System.out.println("Tokimon list is full. You can't add more.");
            System.out.println();
        }else {
            int flag1 = 0;
            int flag2 = 0;
            int flag3 = 0;
            String tokimon_name = "";
            String tokimon_type = "";
            double tokimon_height = 0;
            double tokimon_weight = 0;

            System.out.print("Enter Tokimon's name: ");
            tokimon_name = userInput();

            while (flag1 == 0) {
                System.out.print("Enter Tokimon's type: ");
                String str = userInput();
                if(!(str.equals("Fly") || str.equals("Fire") || str.equals("Water") || str.equals("Electrify") || str.equals("Freeze"))){
                    errorException(2, 0, 1);
                }else{
                    tokimon_type = str;
                    flag1 = 1;
                }
            }

            while (flag2 == 0) {
                System.out.print("Enter Tokimon's height: ");
                String str = userInput();
                if (!isDouble(str)) {
                    errorException(0, 0, 1000);
                } else {
                    if (Double.parseDouble(str) <= 0) {
                        errorException(0, 0, 1000);
                    } else {
                        tokimon_height = Double.parseDouble(str);
                        flag2 = 1;
                    }
                }
            }

            while (flag3 == 0) {
                System.out.print("Enter Tokimon's weight: ");
                String str = userInput();
                if (!isDouble(str)) {
                    errorException(0, 0, 1000);
                } else {
                    if (Double.parseDouble(str) <= 0) {
                        errorException(0, 0, 1000);
                    } else {
                        tokimon_weight = Double.parseDouble(str);
                        flag3 = 1;
                    }
                }
            }
            tokimons_list.add(new Tokimon(tokimon_name, tokimon_type, tokimon_height, tokimon_weight));
            System.out.println();
        }
    }

    public void deleteToki(List<Tokimon> tokimons_list){
        if(tokimons_list.size() == 0){
            System.out.println("Tokimon list is empty. You can't delete any more.");
            System.out.println();
        }else {
            int flag = 0;
            int choice = 0;

            System.out.println("Which Tokimon do you want to delete?");
            displayAllTokis(tokimons_list);
            while (flag == 0) {

                System.out.println("\nPlease enter the Tokimon number you would like to delete (or enter 0 to exit): ");
                String str = userInput();
                if (!isInt(str)) {
                    errorException(0, 1, tokimons_list.size());
                } else {
                    choice = Integer.parseInt(str);
                    if (choice == 0) {
                        System.out.println("Exit");
                        flag = 1;
                    } else if (choice < 0 || choice > tokimons_list.size()) {
                        errorException(1, 1, tokimons_list.size());
                    } else {
                        tokimons_list.remove(choice - 1);
                        System.out.println("The current list after deletion: ");
                        displayAllTokis(tokimons_list);
                        flag = 1;
                    }
                }
            }
            System.out.println();
        }
    }

    public void alterToki(List<Tokimon> tokimons_list){
        displayAllTokis(tokimons_list);
        System.out.println("(Enter 0 to cancel)");
        if(tokimons_list.size() == 0){
            System.out.println("Tokimon list is empty. You can't alter any Tokimon.");
            System.out.println();
        }else {
            int flag1 = 0;
            int flag2 = 0;
            int choice = 0;
            int strength = 0;

            while (flag1 == 0) {
                System.out.println();
                System.out.println("Please enter the Tokimon Number you would like to change (or enter 0 to exit): ");
                String str = userInput();
                if (!isInt(str)) {
                    errorException(0, 1, tokimons_list.size());
                } else {
                    choice = Integer.parseInt(str);
                    if (choice == 0) {
                        System.out.println("Exit");
                        flag1 = 1;
                        System.out.println();
                    } else if (choice < 0 || choice > tokimons_list.size()) {
                        errorException(1, 1, tokimons_list.size());
                    }else {
                        while (flag2 == 0) {
                            System.out.println();
                            System.out.println("By how much?: ");
                            String strength_str = userInput();
                            if (!isInt(strength_str)) {
                                errorException(0, 1, 100);
                            } else {
                                strength = Integer.parseInt(strength_str);
                                if (strength < 0 || strength > 100) {
                                    errorException(1, 1, 100);
                                } else {
                                    tokimons_list.get(choice - 1).setStrength(strength);
                                    System.out.println("Toki " + tokimons_list.get(choice - 1).getName() + " now has strength " + strength + " !");
                                    System.out.println("The current list after alter: ");
                                    displayAllTokis(tokimons_list);
                                    System.out.println();
                                    flag2 = 1;
                                }
                            }
                        }
                        flag1 = 1;
                    }
                }
            }
        }
    }

    public void debug(List<Tokimon> tokimons_list){
        System.out.println("All Tokimon objects: ");
        for(int i = 0; i < tokimons_list.size(); i++){
            System.out.println((i+1) + ". " + tokimons_list.get(i).toString());
        }
        System.out.println();
    }
}
