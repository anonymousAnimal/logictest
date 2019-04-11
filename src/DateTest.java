import java.util.Scanner;
import java.util.regex.Pattern;

public class DateTest {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the date in given format(dd-mm-yyyy):");
		String date = sc.nextLine();
		System.out.println("enter the no.of days (it must be positive):");
		int n;
		try {
			n = Integer.parseInt(sc.nextLine());
			if(n < 0) {
				System.out.println("n must be positive number !");
				return;
			}
			
		}
		catch(Exception e) {
			System.out.println("invalid n");
			return;
		}
		finally {
			sc.close();
		}
		
		if(!validateDate(date))
		{
			System.out.println("invalid date");
			return;
		}
			
		System.out.println(daynoToDate(date, n));

	}

	
	public static boolean checkLeapYear(int y) 
	{
		
		if(y%100==0 && y%400==0)
			return true;
		
		if(y%100!=0 && y%4==0)
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean validateDate(String date) 
	{
		
		//checking for valid format
		Pattern pdate = Pattern.compile("\\d{1,2}\\-\\d{1,2}\\-\\d{4}");
		if(!pdate.matcher(date).matches()) {
			//System.out.println("invalid date");
			return false;
		}
		
		
		String arr[] = date.split("-");
		Integer dd = Integer.parseInt(arr[0]);
		Integer mm = Integer.parseInt(arr[1]);
		Integer yyyy = Integer.parseInt(arr[2]);
		
		//System.out.println(dd+"-"+mm+"-"+yyyy);
		
		
		switch(mm)
		{
		case 1 : if(dd > 31 && dd < 1) return false; break;
		case 2 : 	if(checkLeapYear(yyyy)&&(dd > 29 || dd < 1)) {
							//System.out.println("invalid date");
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
	
	public static int daysLeftTill31Dec(int d, int m, int y) 
	{
		
		int res = 0;
		int arr[];
		boolean isleap = checkLeapYear(y);
		if(isleap)
			arr = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
		else
			arr = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		
		res = arr[m-1]-d;
		
		for(int i = m; i< 12; i++) 
		{
			res += arr[i];
		}
		
		return res;
	}
	
	public static String daynoToDate(String date, int n) 
	{
		
		int d;
		int m;
		int y;
		
		String str[] = date.split("-");
		 d = Integer.parseInt(str[0]);
		 m = Integer.parseInt(str[1]);
		 y = Integer.parseInt(str[2]);
		
		 //this loop will runs until the date lies within the year
		while(true) {
			int daysLeftInCurrentYear = daysLeftTill31Dec(d, m, y);
			if(n > daysLeftInCurrentYear) 
			{
				n -= daysLeftInCurrentYear;
				d = 0;
				m = 1;
				y++;
			}
			else
				break;
		}
		
		
		//code if result date lies within the same year
		boolean isleap = checkLeapYear(y);
		int days[];
		
		if(isleap)
			days = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
		else
			days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		
		
		
		
		for(int i = m-1; i< 12 && n > 0; i++) 
		{
			
			
			if(n > days[i]-d) {
				n = n - (days[i]-d);
				d = 0;
				m += 1;
			}
			else {
				d += n;
				n = 0;
			}
		}
		
		
		return d+"-"+m+"-"+y;
	}
	
	
}
