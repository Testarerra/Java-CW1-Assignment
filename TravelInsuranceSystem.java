import java.util.Scanner;

public class TravelInsuranceSystem {
    public static void main(String[] args) {
        InusrancePlan insurancePlan = new InusrancePlan("",0,0,0,false,false);
        int option;
        do{
            //Display Menu
            System.out.println("\n====================================");
            System.out.println("         TRAVELSAFE INSURANCE      ");
            System.out.println("====================================");
            System.out.println("1. Display Insurance Plans");
            System.out.println("2. Calculate Insurance Premium");
            System.out.println("3. Generate Summary Report");
            System.out.println("4. Exit");
            System.out.println("====================================");
            //Prompt User Ihput
            System.out.print("Please Choose Your Option:");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            System.out.println();
            //Process
            switch(option){
                case 1 -> System.out.println(insurancePlan.display_plans());
                case 2 -> System.out.println(insurancePlan.calculate_insurance_premium());
                case 3-> System.out.println(insurancePlan.report);
                case 4 -> System.out.println("Thank You For Using TravelSafe Insurance!");
                case 5 -> System.out.println("\n**INVALID CHOICE**\n(Please Choose A Valid Choice [1,2,3,4])");
            }
        }while(option != 4); //keep looping until user choose to exit
    }
}
