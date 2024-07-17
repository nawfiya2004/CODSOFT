import java.util.*;
public class Codsoft_Task2_Student_Grade_Calculator {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Your Name:");
        String name=scan.nextLine();
        int avg,total;
        System.out.println("Enter the marks For First Semester Subjects");
        System.out.print("Profesional English-I:");
        int eng1=scan.nextInt();
        System.out.print("Matrics And Calculus :");
        int mat=scan.nextInt();
        System.out.print("Engineering Chemistry:");
        int che=scan.nextInt();
        System.out.print("Engineering Physics  :");
        int phy=scan.nextInt();
        System.out.print("Problem solving and Python Programming :");
        int pro=scan.nextInt();
        total=eng1+mat+che+phy+pro;
        avg=(total/5);
        System.out.println("Total marks You Scored Out of 500 :"+total);
        System.out.println("Your Average Percentage :"+avg+"%");
        System.out.print("Your Grade For Average Percentage :");
        if(avg==100){
            System.out.println("'O' Grade");
        }else if(avg>=90 &&avg<=99){
            System.out.println("'A+' Grade");
        }else if(avg>=80 &&avg<=89){
            System.out.println("'A' Grade");
        }else if(avg>=70 &&avg<=79){
            System.out.println("'B+' Grade");
        }else if(avg>=60 &&avg<=69){
            System.out.println("'B' Grade");
        }else if(avg>=50 &&avg<=59){
            System.out.println("'C' Grade");
        }else{
            System.out.println("Oops!,You Failed in exam :(");
        }
        if(avg>=50){
            System.out.println("Congratulationa! "+name+" You Secured a good grade");
        }else{
            System.out.println("Don\'t Worry,"+name+".You\'ll do better next time.\nKeep trying!");
        }
    }
}
