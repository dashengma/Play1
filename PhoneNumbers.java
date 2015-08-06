package myplay;

import java.util.*;

/**
 * Write the algorithm to find all possible phone numbers that can be dialed on a standard touch-tone phone keypad 
 * when the "next digit" can only be selected from the #'s that are reached by moving as a Chess Knight 
 * (over 2 & up/down 1, or over 1 & up/down 2)  
 */
public class PhoneNumbers {
	public static String[] pos = {"46", "68", "79", "48", "39", "", "17", "26", "13", "24"};

	public static void main(String[] args) {		
		int start=-1;
		String pn = "";
		Set<String> pnList = new HashSet<String>();
		
		for (int i=0; i<10; i++) {
			start = i;
			pn = start+"";			
			getPhoneNumbers(pnList, pn, start);
		}
		System.out.println("counter:"+pnList.size()+", "+pnList);
	}
	
	public static void getPhoneNumbers (Set<String> pnList, String pn, int start) {
		if (pn.length()==2) {
			pnList.add(pn);
		}
		else {
			String pStr = pos[start];
			int ns = -1;
			for (int i=0; i<pStr.length(); i++) {
				ns = Integer.parseInt(pStr.substring(i, i+1));
				getPhoneNumbers(pnList, pn+ns, ns);
			}
		}
	}
}
