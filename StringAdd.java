import java.util.*;  

class WithFunction{
	int Add(String number){
		//temp variable to store a single number
		String temp="0";
		// variable to store the sum
		int sum=0;
		cter = 0
		for(int i = 0; i < number.length(); i++) 
		{ 
			char ch = number.charAt(i); 
			
			// if current character is a digit 
			if (Character.isDigit(ch)){
				//the number is added to the number in temp so that multiple digit numbers aren't missed.
				temp += ch;
			}
			// if current character is a comma 
			else if(ch==',' && cter<1)
			{ 
				// increment sum by number found earlier (if any) 
				sum += Integer.parseInt(temp); 
	
				// reset the temp variable
				temp = "0";
				cter+=1;
			}
			else{
				//if the charecter is something other than number or comma
				sum=-1;
				temp="0";
				break;
			}
		}
		sum += Integer.parseInt(temp);
		//to add the last digit eg 1,2 then this will add 2 to the sum
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