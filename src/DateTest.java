import java.util.Scanner;
import java.util.regex.Pattern;

public class DateTest {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the date in given format(dd-mm-yyyy):");
		String date = sc.nextLine();
		System.out.println("enter the no.of days :");
		int n;
		try {
			n = Integer.parseInt(sc.nextLine());
			
		}
		catch(Exception e) {
			System.out.println("invalid date");
			return;
		}
		finally {
			sc.close();
		}
		System.out.println("result : "+addNToDate(date, n));
		
		

	}

	
	public static boolean checkLeapYear(int y) 
	{
		
		if(y%100==0 & y%400==0)
			return true;
		
		if(y%100!=0 & y%4==0)
			return true;
		
		
		return false;
	}
	
	public static boolean validateDate(String date) {
		
		//checking for valid format
		Pattern pdate = Pattern.compile("\\d{2}\\-\\d{2}\\-\\d{4}");
		if(!pdate.matcher(date).matches()) {
			System.out.println("invalid date");
			return false;
		}
		
		
		String arr[] = date.split("-");
		Integer dd = Integer.parseInt(arr[0]);
		Integer mm = Integer.parseInt(arr[1]);
		Integer yyyy = Integer.parseInt(arr[2]);
		
		System.out.println(dd+"-"+mm+"-"+yyyy);
		
		
		switch(mm)
		{
		case 1 : if(dd > 31 && dd < 1) return false; break;
		case 2 : 	if(checkLeapYear(yyyy)&&(dd > 29 || dd < 1)) {
							System.out.println("invalid date");
						    return false;
						}
					else if(dd < 1 || dd >28)
							return false;
		break;
		case 3 : if(dd > 31 || dd < 1) return false; break;
		case 4 : if(dd > 30 || dd < 1) return false; break;
		case 5 : if(dd > 31 || dd < 1) return false; break;
		case 6 : if(dd > 30 || dd < 1) return false; break;
		case 7 : if(dd > 31 || dd < 1) return false; break;
		case 8 : if(dd > 31 || dd < 1) return false; break;
		case 9 : if(dd > 30 || dd < 1) return false; break;
		case 10 : if(dd > 31 || dd < 1) return false; break;
		case 11 : if(dd > 30 || dd < 1) return false; break;
		case 12 : if(dd > 31 || dd < 1) return false; break;
		default : return false;
		}
		
		
		return true;
	}
	
	public static String addNToDate(String date, int n) {
		
		//check if valid date or not
		if(!validateDate(date))
			return "invalid date";
			
		return "valid date";
	}
}
