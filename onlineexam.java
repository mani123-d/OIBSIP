import java.io.*;
import java.util.*;

import javax.script.ScriptContext;
class OnlineExamination{
    String Fullname;
    String Gender;
    String UserName;
    String Password;
    String Phonenumber;
    int count=0;
    int score=0;
    int attempt=0;
    Scanner sc=new Scanner(System.in);
    HashMap<String,String> data=new HashMap<String,String>();
    public void Register(){
        System.out.println("Registration Form");
        System.out.print("Enter Full Name: ");
        this.Fullname=sc.nextLine();
        System.out.print("Enter Gender:Male/Female ");
        this.Gender=sc.nextLine();
        String Gender1="Male";
        String Gender2="Female";
        if(this.Gender.equals(Gender1)){
            this.Gender="Male";
        }
        else{
            this.Gender="Female";
        }
        System.out.print("Enter Username: ");
        this.UserName=sc.nextLine();
        System.out.print("Enter Password: ");
        this.Password=sc.nextLine();
        data.put(this.UserName,this.Password);
        System.out.print("Enter Phone Number: ");
        this.Phonenumber=sc.nextLine();
        while((Phonenumber.length())!=10){
            System.out.print(" number must be 10 digits ");
            this.Phonenumber=sc.nextLine();
        }
        System.out.println("Your are Successfully Registered!!");
        System.out.println("Please Login to Take Online Exam");
    }
    public boolean Login(){
        boolean log=false;
        System.out.print("Enter your User name: ");
        String Username;
        Username=sc.nextLine();
	if(data.containsKey(Username)){
            System.out.print("Enter your Password: ");
            String Pass_Word;
            Pass_Word=sc.nextLine();
            if(data.containsKey(Username) && data.containsValue(Pass_Word)){
                System.out.println("Login Successful...");
                log=true;
            }
            else{
                System.out.println("invalid password");
            }
	}
	else{
	    System.out.println("you didnt redgister with this username!");
	}
        return log;
    }
    public void View_Profile(){
        System.out.println("Your Profile: ");
        System.out.println("Full Name: "+this.Fullname);
        System.out.println("Gender: "+this.Gender);
        System.out.println("User Name: "+this.UserName);
        System.out.println("Password(Don't Share with any one) :"+this.Password);
        System.out.println("Phone Number: "+this.Phonenumber);
    }
    public void Update_Profile(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Username: ");
        String Username;
        Username=sc.nextLine();
        if(Username.equals(this.UserName)){
            System.out.println("Select: \n1.To change Username\n2.To change Password");
            int ch;
            System.out.print("Your Option: ");
            ch=sc.nextInt();
            switch(ch){
                case 1:Update_Username();
                       break;
                case 2:Update_PassWord();
                       break;
                default :System.out.println("Invalid option...");
            }
        }
        else{
            System.out.println("you didnt register with this username \n");
        }
    }
    public void Update_Username(){
        Scanner sc=new Scanner(System.in);
        String User;
        String User1;
        System.out.print("Enter New User Name to Update: ");
        User=sc.nextLine();
        if(!(User.equals(this.UserName))){
            System.out.print("Conform New User Name to Update: ");
            User1=sc.nextLine();
            if(User.equals(User1)){
                System.out.println("Username Updated Successfully...");
                this.UserName=User1;
                return;
            }
            else{
                System.out.println("You must type the same Username...");
                Update_Username();
            }
        }
        else{
            System.out.println("New Username and Present Username cannot not be same...");
            Update_Username();
        }
    }
    public void Update_PassWord(){
        Scanner sc=new Scanner(System.in);
        String Pass;
        String Pass1;
        System.out.print("Enter New Password to Update: ");
        Pass=sc.nextLine();
        if(!(Pass.equals(this.Password))){
            System.out.print("Conform New Password to Update: ");
            Pass1=sc.nextLine();
            if(Pass.equals(Pass1)){
                System.out.println("Password Updated Successfully...");
                this.Password=Pass1;
                return;
            }
            else{
                System.out.println("You must type the same Password...");
                Update_PassWord();
            }
        }
        else{
            System.out.println("New Password and Present Password cannot not be same...");
            Update_PassWord();
        }
    }
    public void Take_exam(){
        long examtime=System.currentTimeMillis();
        long endtime=examtime+45*1000;
        int ans;
        int ch;
       
            System.out.println("Welcome to Mathematics Exam: ");
            System.out.println("Each Question carries 10 marks");
            System.out.println("You have 45 seconds to answer 5 questions");
            attempt=0;
            System.out.println("enter choice :1.start\n2.exit");
            ch=sc.nextInt();
        if(ch==1){
            while(System.currentTimeMillis()<endtime){
		count=0;
                System.out.println("Question 1. 10*30 = ?");
                System.out.println("Option 1. 500\nOption 2. 722\nOption 3. 300\nOption 4.200 \n");
                System.out.print("Enter Your Answer: ");
                ans=sc.nextInt();
                if(ans==3){
                    count++;
                }
                System.out.println("Question 2. 3*3+1 = ?");
                System.out.println("Option 1. 5\nOption 2. 1\nOption 3. 10\nOption 4. 0\n");
                System.out.print("Enter Your Answer: ");
                ans=sc.nextInt();
                if(ans==3){
                    count++;
                }
                System.out.println("Question 3. 100-10 = ?");
                System.out.println("Option 1. 20\nOption 2. 80\nOption 3. 90\nOption 4. 15\n");
                System.out.print("Enter Your Answer: ");
                ans=sc.nextInt();
                if(ans==3){
                    count++;
                }
                System.out.println("Question 4. 20/0 = ?");
                System.out.println("Option 1. 0\nOption 2. infinite\nOption 3. not possible\nOption 4. 20\n");
                System.out.print("Enter Your Answer: ");
                ans=sc.nextInt();
                if(ans==2){
                    count++;
                }
                System.out.println("Question 5. 3/3 = ?");
                System.out.println("Option 1. 0\nOption 2. 1\nOption 3. not possible\nOption 4. None of the above\n");
                System.out.print("Enter Your Answer: ");
                ans=sc.nextInt();
                if(ans==2){
                    count++;
                }
                attempt++;
                break;
            }
        }
        
    }
    public void View_Marks(){
	int score=10*count;
	if(score==50){
	    System.out.println("Congratulations....");
	}
	else if(score<50 && score>=35){
	    System.out.println("Well Done...");
	}
	else if(score<35 && score>=20){
	    System.out.println("Well Tried...");
	}
	else if(score<20 && score>=10){
	    System.out.println("Good...");
	}
	else{
	    System.out.println("Ok! Try Again...");
	}
        if(attempt==1){
            System.out.println("Your Score: "+score+"/50");
        }
        else{
            System.out.println("You haven't Written any exam...");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("!!!!!!!----WELCOME----!!!!!!!");
        System.out.println("Please Register first to write the exam");
        System.out.print("enter Your choice:\n1.Register\n2.Exit");
        int choice;
        choice=sc.nextInt();
        if(choice==1){
            OnlineExamination exam=new OnlineExamination();
            exam.Register();
            while(choice==1){
               
                System.out.println("select one: \n1.Login(If already Registered)\n2.Exit");
                System.out.print(" enter Your option :");
                int option=sc.nextInt();
                if (option==1){
                    if(exam.Login()){
                        while(true){
                            System.out.println("\n\nWelcome to Online Examination");
                            System.out.println("1.View Profile\n2.Update Profile and Password\n3.Take Exam\n4.View Marks\n5.Logout");
                            System.out.print("Enter your option :");
                            int select; 
                            select=sc.nextInt();
                            switch(select){
                                case 1 : exam.View_Profile();
                                         break;
                                case 2 : exam.Update_Profile();
                                         break;
                                case 3 : exam.Take_exam();
                                         break;
                                case 4 : exam.View_Marks();
                                         break;
                                case 5 : System.out.println("\nLogged out Successfully..."); 
                                         System.exit(0);
                                         break;
                                default: System.out.println("Invalid option!...Enter Valid option...");
                            }
                        }
                    }
                }
                else{
                    System.out.println("\nThank you"); 
                    System.exit(0);
                }
            }
        }
        else {
            System.out.println("\nThank you...Visit Again...:)"); 
        	System.exit(0);
        }
    }
}
