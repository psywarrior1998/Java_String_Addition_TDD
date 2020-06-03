import java.util.*;  

class WithFunction{
	int Add(String number){
		//temp variable to store a single number
		String temp="0";
		// variable to store the sum
		int sum=0;
		
		if(number.charAt(0)== '/' && number.charAt(1)== '/'){
			String delim="";
			int j=2;
			while(number.charAt(j)!='\\' && number.charAt(j+1)!='n'){
				delim+=number.charAt(j);
				j+=1;
			}
			j+=2;
			for(int i = j; i < number.length(); i++) 
			{ 
				char ch = number.charAt(i); 
				try{
					// if current character is a digit			
					if (Character.isDigit(ch)){
						//the number is added to the number in temp 
						// so that multiple digit numbers aren't missed.
						temp += ch;
					}
					// if current character is starting letter of deliminator
					else if (ch==delim.charAt(0) && Character.isDigit(number.charAt(i+(delim.length()))))
					{
						int cter = 1;
						for(int k=1;k<delim.length(); k++)
						{
							if(number.charAt(i+k)==delim.charAt(k)){
								cter += 1;
							}
							else{
								break;
							}
						}
						if(cter == delim.length()){
							// increment sum by number found earlier
							sum += Integer.parseInt(temp);
							// reset the temp variable for the next integer
							temp = "0";
							i+=2;
						}
						else{
							//if the charecter is something other than the deliminator
							sum=-1;
							temp="0";
							break;
						}
					}	
					else{
						//if the charecter is something other than the deliminator
						sum=-1;
						temp="0";
						break;
					}
				}
				catch(StringIndexOutOfBoundsException e){
					System.out.println("deliminators must be succeded by numbers");
				}
			}
			
		}
		else{
			for(int i = 0; i < number.length(); i++) 
			{ 
				char ch = number.charAt(i); 
				try{
					// if current character is a digit			
					if (Character.isDigit(ch)){
						//the number is added to the number in temp 
						// so that multiple digit numbers aren't missed.
						temp += ch;
					}
					// if current character is a comma 
					else if (ch==',' && Character.isDigit(number.charAt(i+1)))
					{ 
						// increment sum by number found earlier (if any)
						sum += Integer.parseInt(temp);
						
						// reset the temp variable for the next integer
						temp = "0";
					}
					// if the charecter is '\' then check if it is succeded by n 
					// and then a number then add it to the sum
					else if (ch=='\\' && number.charAt(i+1)=='n' && Character.isDigit(number.charAt(i+2))){
						i+=1;
						sum += Integer.parseInt(temp);
						// reset the temp variable for the next integer
						temp = "0";
					}
					else{
						//if the charecter is something other than number or comma
						sum=-1;
						temp="0";
						break;
					}
				}
				catch(StringIndexOutOfBoundsException e){
					System.out.println("deliminators must be succeded by numbers");
				}
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
		System.out.println("Please enter the string with numbers in the format <number1>,<number2> or <number1>\\n<number2>");
		str =  scan.nextLine();
		WithFunction wf = new WithFunction();
		int sum=wf.Add(str);
		if(sum!=-1){
			System.out.println("the sum of the numbers is " + sum);
		}
		else{
			System.out.println("The numbers should be seperated by commas or '\\n' (next line) only");
		}
	}
}