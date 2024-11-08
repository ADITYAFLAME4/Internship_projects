import java.util.*;
class  Calculator{
    public static void main(String[] args) {
      
        //First Function Call
        Calculate();

        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to Calculate again ?");
        System.out.println("Press 'Y' to Continue or any key to Exit !");

        char restart = input.next().charAt(0);

        if (restart == 'Y' || restart == 'y'){
        //Second Function Call

                Calculate();
        }
        else
            System.out.println("Thanks for using this Calculator ! :) ");    
}


                
        public static void Calculate(){

            @SuppressWarnings("resource")
            Scanner input = new Scanner(System.in);
            //To cleare the screen
    
            System.out.print("\033[H\033[2J");
            System.out.flush();
    
            //Number Inputs
            System.out.print("Enter 1st number:");
            float num1 = input.nextFloat();
            System.out.println();
    
            System.out.print("Enter 2nd number:");
            float num2 = input.nextFloat();
            System.out.println();
            
            //Preparing for switch case
    
            System.out.println("--For Add Press '+' , For Substraction Press '-' , For Multipication Press '*' , For division Press '/' , For Modulus Press '%' ---");
    
            System.out.println();
    
            char operation = input.next().charAt(0);
    
            switch(operation)
            {
                case '+' ->  {     
                    System.out.println("Addition of "+ num1 + " and "+ num2 +" is : "+ (num1 + num2));
                    break;
                }
    
                case '-' ->  {
                    System.out.println("Substraction of "+ num1 + " and "+ num2 +" is : "+ (num1 - num2));
                    break;
                }
    
                case '*' ->  {
                    System.out.println("Multipication of "+ num1 + " and "+ num2 +" is : "+ (num1 * num2));
                    break;
                }
    
                case '/' ->  {
                    System.out.println("Dividation from "+ num1 + " to "+ num2 +" is : "+ (num1 / num2));
                    break;
                }
    
                case '%' ->  {
                    System.out.println("Modulus of "+ num1 + " and "+ num2 +" is : "+ (num1 % num2));
                    break;
                }
    
                default ->  {
                    System.out.println("------ Error! , Please input Proper Operation Symbols ------");
                    //If wrong Input then restarts the program (Recursive)

                    Calculate();
                }
                
                
            }
    
        }   
        
        

}          
