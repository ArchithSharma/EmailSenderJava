package emails;

import java.util.Scanner;
import java.util.HashMap;
import java.io.*;

public class Sender {
	

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("/Your/path/to/message/email.html");
		Scanner s = new Scanner(f);
		String a = "";

		HashMap<String, String> members = new HashMap<String, String>();
		members.put("Member1", "Email1@gmail.com");
		members.put("Member2", "Email2@gmail.com");
		
		
		HashMap<String, String> specificcompetitionlist = new HashMap<String, String>();
		specificcompetitionlist.put("Name1", "Email1@gmail.com"); // and repeat for all other names
		
		
		HashMap<String, String> clubboardlist = new HashMap<String, String>();
		clubboardlist.put("VP", "VP@yourschool.org");
		clubboardlist.put("Secretary", "Sec@yourschool.org");
		clubboardlist.put("Treasurer", "Tres@yourschool.org");
		
		System.out.println();
		HashMap<String, String> test = new HashMap<String, String>();
		test.put("YourEmail1", "YourEmail@Gmail.com");
		test.put("YourEmail2", "YourEmail2@yourschool.org");
		
		SendEmail send = new SendEmail();
		while (s.hasNextLine()) {
			a = a + s.nextLine();
			
		}
		for(String i: genlist.keySet()) {
			
			a = a.replace("uniqueStringName", i);
			send.setbody(a);
			send.setreceiver(genlist.get(i));
			send.setsubject("REMINDER: Club meeting today!");
			send.sendit();
			a = a.replace(i, "uniqueStringName"); 
			
			
			//System.out.print(members.get(i) + " ");
		}
		s.close();
				

	}

}
