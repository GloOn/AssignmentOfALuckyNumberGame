
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	public void getDate(){	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	System.out.println(sdf.format(date));
	}
}
