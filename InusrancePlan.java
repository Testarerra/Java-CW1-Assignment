import java.util.Scanner;
public class InusrancePlan {
    //initializing
    private String destination;
    private int duration;
    private int depedents;
    private double price_per_day;
    private double subPrice;
    private double extreme_coverage_fee;
    private  double depedents_fee;
    private double totalPrice;
    private boolean extreme_coverage;
    private boolean family_coverage;
    private final double FEE = 10;
    private final double SERVICE_CHARGE = 0.8;  


    public String display_plans(){
        return "\nTravelSafe Insurance Plan"+
    "\n+-------------+-------------------+------------------------+\n" +
    "| Destination | Duration (Days)   | Premium per Day (RM)   |\n" +
    "+-------------+-------------------+------------------------+\n" +
    "| Domestic    | 1 - 7             | 5.00                   |\n" +
    "|             | 8 - 14            | 4.50                   |\n" +
    "|             | Above 14          | 4.00                   |\n" +
    "+-------------+-------------------+------------------------+\n" +
    "| Asia        | 1 - 7             | 8.00                   |\n" +
    "|             | 8 - 14            | 7.50                   |\n" +
    "|             | Above 14          | 7.00                   |\n" +
    "+-------------+-------------------+------------------------+\n" +
    "| Worldwide   | 1 - 7             | 12.00                  |\n" +
    "|             | 8 - 14            | 11.00                  |\n" +
    "|             | Above 14          | 10.00                  |\n" +
    "+-------------+-------------------+------------------------+";
    }

    //Public Method to Calculatoe The Insurance Premium Without Tax
    public double calculate_insurance_premium() {
        //Setting Variable
       destination = setDestination();
       duration = setDuration();
       //setting price per days based on destination
       switch(destination.charAt(0))
       {
        case 'd':
        price_per_day = (duration > 14) ? 4 : (duration>=8) ? 4.5 : 5;
        destination = "Domestic";
        break;

        case 'a':
        price_per_day = (duration > 14)? 7 : (duration >= 8) ? 7.5 : 8;
         destination = "Asia";
        break;

        case 'w':
        price_per_day = (duration > 14) ? 10 : (duration >= 8) ? 11 : 12;
         destination = "Worldwide";
        break;
       }
       //Asking user if they want to add extreme coverage
       char choice = '0';
       //looping until user enter either yes or no
       while(choice != 'y' && choice != 'n') {
       //Prompt user input
       System.out.println("\nDo You Wnat To Add Extreme Sport Coverage?");
       System.out.println("(Note: This will increase your premium by 20% to cover high-risk activities such as skydiving, scuba diving, bungee jumping, or skiing.)");
       System.out.print("Please Enter Y/N:");
       Scanner scanner = new Scanner(System.in);
       choice = scanner.nextLine().toLowerCase().charAt(0);
       //Display Error if user enter invalid input
       if(choice != 'y' && choice != 'n')
       System.out.println("\n**INVALID CHOICE**\n(Please Enter Either Yes or No)\n");
       extreme_coverage = (choice == 'y')? true : false;
       extreme_coverage_fee = (extreme_coverage)? price_per_day * duration * 0.2 : 0;
       }

       

       //Asking user if they want to add family coverage
       choice = 0;
        //looping until user enter either yes or no
       while(choice != 'y' && choice != 'n') {
       //Prompt user input
       System.out.println("\nDo You Wnat To Add Family Coverage?");
       System.out.println("(Note: Family coverage allows you to include your spouse and/or children under the same insurance plan." +
                            "An additional fee of RM50 will be charged **per dependent**.) ");
       System.out.print("Please Enter Y/N:");
       Scanner scanner = new Scanner(System.in);
       choice = scanner.nextLine().toLowerCase().charAt(0);
       //Display Error if user enter invalid input
       if(choice != 'y' && choice != 'n')
       System.out.println("\n**INVALID CHOICE**\n(Please Enter Either Y/N)\n");

       family_coverage = (choice == 'y')? true : false;
       }
       //Ask for number of depedents if user wants to add-on family coverage
       if(family_coverage == true){
       depedents = setDepedents();
       depedents_fee = depedents * 50;
       }
       subPrice += price_per_day * duration  + (depedents_fee) + (10) + extreme_coverage_fee; 
       totalPrice = subPrice + (subPrice * 0.08);
       return subPrice;
    }

    public String toString()
    {
        String report = String.format( "\n\n======= TravelSafe Insurance Summary Report =======\n" +
                        "--- Trip Details ---" +
                        "\nDestination: %s" + destination +
                        "\nDuration: %d days" +
                        "\nExtrem Sports Coverage: %s "+
                        "\nFamily Coverage: %s ", 
                        destination,
                        duration,
                        extreme_coverage ? "Yes" : "No",
                        family_coverage ? "Yes" : "No"
                        ) + String.format("\n\n--- Premium Breakdown ---" +
                        "\nBase Premium: RM %.2f x %d days = RM %.2f" +
                        "\nExtreme Sports Coverage (20%%): %.2f "+
                        "\nDepedent Fee (%d depedents x RM 50): RM%.2f" +
                        "\nStamp & Duty Fee: +RM %.2f" +
                        "\nSubtotal: RM%.2f" +
                        "\nService Charge (8%%): RM %.2f",
                        price_per_day, duration, duration * price_per_day,
                        extreme_coverage_fee,
                        depedents, depedents_fee,
                        FEE,
                        subPrice,
                        (subPrice * 0.08))+
                        String.format("\n\n--- Total Premium ---\n" +
                        "Total Price: RM%.2f" +
                        "=====================================================",
                        totalPrice);
                        
                        
        return report;
    }

    //duration setter
    private int setDuration(){
        do{
        //Prompt Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Trip's Duration (days):");
        duration = scanner.nextInt();
        //Display Error if Duration is less than 1
        if(duration < 1) 
        System.out.println("\n**INVALID DURATION**\n(Please enter a valid trip's duration [1 or more])\n");
        }while(duration < 1); // while trip's duration is less than 1, then loop.
        return duration;
    }

    //destination setter
    private String setDestination(){

        boolean isValid = false; //boolean to check if the destination is valid or not
        
       //Loop until input starts with d/a/w; if so, exit.
        while(isValid == false) {
         //Prompt user for input
        System.out.println(display_plans());
        System.out.print("Please Enter Your Destination (DOMESTIC/ASIA/WORLDWIDE):");
        Scanner scanner = new Scanner(System.in);
        destination = scanner.nextLine().toLowerCase(); //convert user input to lower case for easier validation
        //check if user input is either /d/a/w if not loop again
        switch(destination.charAt(0)){
            case 'd':
            case 'a':
            case 'w':
            isValid = true;
            break;
            default:
            System.out.println("\n**INVALID DESTINATION**\n(Please enter a valid destination [domestic / asia / worldwide] ).\n");
            isValid = false;
         }
        }
        return destination;
    }
    
    private int setDepedents()
    {
        //loop until user enter amount greater than 0
         while(depedents < 1)
        {
        //Prompt Input
         System.out.println("\nHow Many Depedents (excluding yourself) will be covered under this policy?" +
        "(Note: Each Depedents Adds RM50 To The Total Premium)");
        System.out.print("Number Of Depedents:");
        Scanner scanner = new Scanner(System.in);
        depedents = scanner.nextInt();
        //display error if user enter less than 0
        if(depedents < 1)
        {
            System.out.println("\n**INVALID AMOUNT**\n(Please enter valid amount[1 or more])\n");
        }
        }
        return  depedents;
    }

}
