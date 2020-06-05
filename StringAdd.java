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
		if(number.charAt(0)== '/' && number.charAt(1)== '/'){
			String delim="";
			int j=2;
			//checking for [ in string if there are multiple delims
			if(number.charAt(2)=='['){
				String delimore=number.substring(3,number.indexOf('\\'));
				String delimz = "";
				long cnt = delimore.chars().filter(ch -> ch == ']').count();
				long a=0;
				int ca=0;
				while(a<cnt	 && ca<delimore.length()){
					if(delimore.charAt(ca)=='['){
						ca+=1;
						delimz+="|";
					}
					else if(delimore.charAt(ca)==']'){
						ca+=1;
					}
					else {
						delimz+=delimore.charAt(ca);
						ca+=1;
						a+=1;
					}
				}
				String aaa=number.split("\\\\n")[1];
				String seque = number;
				List<String> seq= Arrays.asList(aaa.split(delimz));
				List<Integer> sumi= seq.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
				List<Integer> loi= new ArrayList<Integer>(sumi);
				sumi.removeIf(x -> x<0|x>1000);
				loi.removeIf(x->x>0);
				neglist=loi;
				sum=sumi.stream().mapToInt(Integer::intValue).sum();
			}
			else{
				delim=number.substring(2,number.indexOf('\\'));
				j+=2+delim.length();
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
							// checkcing if the charecter sequence is the delim
							if(cter == delim.length()){
								// increment sum by number found earlier
								if(Integer.parseInt(temp)<1000){
									sum += Integer.parseInt(temp);
								}
								// reset the temp variable for the next integer
								temp = "0";
								//
								i+=delim.length()-1;
							}
							else{
								//if the charecter is something other than the deliminator
								sum=-1;
								temp="0";
								break;
							}
						}
						else if(number.charAt(i+(delim.length()))=='-'){
							int init=i+(delim.length())+1;
							String tn="";
							try{
								while(Character.isDigit(number.charAt(init))){
									tn+=number.charAt(init);
									init+=1;
								}
							}
							catch(StringIndexOutOfBoundsException e){
							}
							i=init-1;
							neglist.add(Integer.parseInt('-'+tn));
							throw new SomeException();
						}
						else{
							//if the charecter is something other than the deliminator
							sum=-1;
							temp="0";
							break;
						}
					}
					catch(SomeException s){
					}
					catch(StringIndexOutOfBoundsException e){
						System.out.println("deliminators must be succeded by numbers");
						e.printStackTrace();
					}
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
						if(Integer.parseInt(temp)<1000){
							sum += Integer.parseInt(temp);
						}
						// reset the temp variable for the next integer
						temp = "0";
					}
					// if the charecter is '\' then check if it is succeded by n 
					// and then a number then add it to the sum
					else if (ch=='\\' && number.charAt(i+1)=='n' && Character.isDigit(number.charAt(i+2))){
						i+=1;
						if(Integer.parseInt(temp)<1000){
							sum += Integer.parseInt(temp);
						}
						// reset the temp variable for the next integer
						temp = "0";
					}
					else if(number.charAt(i+1)=='-' && ch==','){
						int init=i+2;
						String tn="";
						try{
							while(Character.isDigit(number.charAt(init))){
								tn+=number.charAt(init);
								init+=1;
							}
						}
						catch(StringIndexOutOfBoundsException e){
						}
						i=init-1;
						neglist.add(Integer.parseInt('-'+tn));
						throw new SomeException();
					}
					else if(number.charAt(i+2)=='-' && ch=='\\' && number.charAt(i+1)=='n'){
						int init=i+3;
						String tn="";
						try{
							while(Character.isDigit(number.charAt(init))){
								tn+=number.charAt(init);
								init+=1;
							}
						}
						catch(StringIndexOutOfBoundsException e){
						}
						i=init-1;
						neglist.add(Integer.parseInt('-'+tn));
						throw new SomeException();
					}
					else{
						//if the charecter is something other than number or comma
						sum=-1;
						temp="0";
						break;
					}
				}
				catch(SomeException s){
				}
				catch(StringIndexOutOfBoundsException e){
					System.out.println("deliminators must be succeded by numbers");
				}
				
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