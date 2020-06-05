import java.util.*;
import java.util.stream.Collectors;

class SomeException extends Exception {
	SomeException() {
		super(); 
	} 
}
class WIPException extends Exception {
	WIPException() {
		super("Congrats you found our yet not completed feature... wait sometime for it to be active"); 
	} 
}
class WithFunction{
	int Add(String number){
		//temp variable to store a single number
		String temp="0";
		// variable to store the sum
		int sum=0;
		List<Integer> neglist=new ArrayList<Integer>();
		String delim="";
		if(number.charAt(0)== '/' && number.charAt(1)== '/' && number.charAt(2)=='['){
			try{
				String delimoree=number.substring(3,number.indexOf("]\\"));
				delim=delimoree.replace("][","|");
				String aaa=number.split("\\\\n")[1];
				String seque = number;
				List<String> seq= Arrays.asList(aaa.split(delim));
				List<Integer> sumi= seq.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
				List<Integer> loi= new ArrayList<Integer>(sumi);
				sumi.removeIf(x -> x<0|x>1000);
				loi.removeIf(x->x>0);
				neglist=loi;
				sum=sumi.stream().mapToInt(Integer::intValue).sum();
			}
			catch (NumberFormatException n){
				System.out.println("Enter delims with numbers");
				sum=-1;
				temp="0";
			}
		}
		else if (number.charAt(0)== '/' && number.charAt(1)== '/'){
			try{
				delim=number.substring(2,number.indexOf("\\"));
				String aaa=number.split("\\\\n")[1];
				String seque = number;
				List<String> seq= Arrays.asList(aaa.split(delim));
				List<Integer> sumi= seq.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
				List<Integer> loi= new ArrayList<Integer>(sumi);
				sumi.removeIf(x -> x<0|x>1000);
				loi.removeIf(x->x>0);
				neglist=loi;
				sum=sumi.stream().mapToInt(Integer::intValue).sum();
			}
			catch (NumberFormatException n){
				System.out.println("Enter delims with numbers");
				sum=-1;
				temp="0";
			}
		}
		else{
			try{
				delim=",|\\\\n";
				String seque = number;
				List<String> seq= Arrays.asList(number.split(delim));
				List<Integer> sumi= seq.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
				List<Integer> loi= new ArrayList<Integer>(sumi);
				sumi.removeIf(x -> x<0|x>1000);
				loi.removeIf(x->x>0);
				neglist=loi;
				sum=sumi.stream().mapToInt(Integer::intValue).sum();
			}
			catch (NumberFormatException n){
				System.out.println("Enter delims with numbers");
				sum=-1;
				temp="0";
			}
		}
		if(!neglist.isEmpty()){
			for(Integer nume:neglist){
				System.out.print(" "+nume+" ");
			}
			System.out.println("Are the negetive numbers in the statement \n they arent allowed so are being ignored");
		}
		if(Integer.parseInt(temp)<1000){
			sum += Integer.parseInt(temp);
		}
		//to add the last digit eg 1,2 then this will add 2 to the sum
		return sum;
	}
}
public class StringAdd{
	public static void main (String[] args) 
	{ 
		String str = "";
		Scanner scan= new Scanner(System.in);
		System.out.println("Please enter the string with numbers in the format\n<number1>,<number2> or <number1>\\n<number2> or //<delimiter>\\n<number1><delimiter><number2> \n//[<delimiter1>][<delimiter2>]\\n<number1><delimiter><number2><delimiter><number3>");
		str =  scan.nextLine();
		WithFunction wf = new WithFunction();
		int sum=wf.Add(str);
		if(sum!=-1){
			System.out.println("The sum of the numbers is " + sum);
		}
		else{
			System.out.println("The numbers should be seperated by commas or '\\n' (next line) or your custom defined delimiteronly");
		}
	}
}