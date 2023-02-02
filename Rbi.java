import java.util.Scanner;

class Rbi{

    public static void main(String[] args) {
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("******** WELCOME TO THE RESERVE BANK OF INDIA ********");
        System.out.println("\n");
        System.out.println("Do you want to open an Account?: PRESS 1 OR Want to check the menu? PRESS 2");
        Scanner sc=new Scanner(System.in);
        int choice2=sc.nextInt();
        if(choice2==1){
            OpenAccount obj=new OpenAccount();
            obj.createAccount();
        }
        if(choice2==2){
            BankAccount obj=new BankAccount();
            obj.showMenu();
        }
        

    }

}

class OpenAccount{

String name;
int accountNum;
String accountType;
String dob;
String bank;

void createAccount(){

    Scanner sc=new Scanner(System.in);
    System.out.println("Which bank You want to open your Account in:  1. HDFC  2. AXIS  3. YES ");
    int choice=sc.nextInt();
    if(choice==1){
        bank="HDFC";
    }
    if(choice==2){
        bank="AXIS";
    }
    if(choice==3){
        bank="YES";
    }

    System.out.println("Please Tell us your name!");
    sc.nextLine();
    name=sc.nextLine();


    System.out.println("please Tell us your Date of Birth");
    dob=sc.nextLine();

    System.out.println("What type of account you want to open: 1. Savings  2. Current");
    int choice1=sc.nextInt();
    if(choice1==1){
        accountType="Savings";
    }

    if(choice1==2){
        accountType="Current";
    }

    System.out.println("Your Account has been opened with the following details");
    System.out.println("Bank: "+bank);
    System.out.println("Name: "+name);
    System.out.println("DOB: "+dob);
    System.out.println("Account Type: "+accountType);
    System.out.println("Account Number: RBI00" +Math.floor(Math.random()*100000));

    System.out.println("\n");
    BankAccount obj1=new BankAccount();
    obj1.showMenu();
    sc.close();


    
}




}

class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;




   


    void deposit(int amount){
        if(amount!=0){
            balance=balance+amount;
            previousTransaction=amount;

        }
    }

    void withdraw(int amount){
        if(amount!=0){
            balance=balance-amount;
            previousTransaction=-amount;

        }

    }

    void getPreviousTransaction(){
        if(previousTransaction>0){
            System.out.println("Deposited: $"+previousTransaction);
        }else if(previousTransaction<0){
            System.out.println("withdrawn: $"+Math.abs(previousTransaction));
        }else{
            System.out.println("Sorry,no transaction occured!");

        }
    }

     void calculateInterest(int bal){
      System.out.println("We provide a wooping 8% Interest");
      System.out.println("Enter year to calculate interest");
      Scanner sc=new Scanner(System.in);
      int year=sc.nextInt();
      int amt= (balance*8*year)/100;
      System.out.println("The interest earned over "+year+ " year is"+" $"+amt);

     }

    void showMenu(){
        char option='\0';
        Scanner sc=new Scanner(System.in);
       
        System.out.println("Welcome to the menu");
        System.out.println("\n");
        System.out.println("A. Check Balance ");
        System.out.println("B. Deposit Amount");
        System.out.println("C. Withdraw Amount");
        System.out.println("D. See Previous Transaction");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit");

        do{
            System.out.println("****************************************");
            System.out.println("Enter an option");
            System.out.println("****************************************");
            option=sc.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case 'A':
                System.out.println("--------------------------------");
                System.out.println("Balance = $"+balance);
                System.out.println("\n");
                break;

                case 'B':
                System.out.println("--------------------------------");
                System.out.println("Enter an amount($) to deposit: ");
                int amount=sc.nextInt();
                deposit(amount);
                System.out.println("\n");
                break;

                case 'C':
                System.out.println("--------------------------------");
                System.out.println("Enter an amount($) to withdraw: ");
                int amount1=sc.nextInt();
                withdraw(amount1);
                System.out.println("\n");
                break;

                case 'D':
                System.out.println("--------------------------------");
                getPreviousTransaction();
                System.out.println("\n");
                break;
                 
                case 'E':
                System.out.println("--------------------------------");
                calculateInterest(balance);
                System.out.println("\n");
                break;

                case 'F':
                System.out.println("****************************************");
                break;

                default:
                System.out.println("Entered Invalid Input!,PLease Try Again");
                break;
            }


        }while(option!='F');
        System.out.println("Thankyou for choosing our Services!");
        sc.close();

    }


}















