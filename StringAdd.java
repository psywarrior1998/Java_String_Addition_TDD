import java.util.*;  

class WithFunction{
	int Add(String number){
		// variable to store the sum
		int sum=0;
		return sum;
	}
}
public class StringAdd{
	public static void main (String[] args) 
	{ 
		String str = "";
		Scanner scan= new Scanner(System.in);
		System.out.println("Please enter the string with numbers in the format <number1>,<number2>");
		str =  scan.nextLine();
		WithFunction wf = new WithFunction();
		int sum=wf.Add(str);
		if(sum!=-1){
			System.out.println("the sum of the numbers is " + sum);
		}
		else{
			System.out.println("The numbers should be seperated by commas only");
		}
	}
}