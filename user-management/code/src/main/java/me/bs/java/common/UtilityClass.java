package me.bs.java.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


public class UtilityClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		replaceUnderScoreCasing("CaseTestingValue");
		replaceUnderScoreCasing(null);

	}
	
	public static String replaceUnderScoreCasing(String text) {
		if(StringUtils.isBlank(text)) {
			System.out.println("UNKNOWN"); 
			return "UNKNOWN";
		}
		
		Matcher m = Pattern.compile("(?<=[a-z])[A-Z]").matcher(text);

		StringBuffer sb = new StringBuffer();
		while (m.find()) {
		    m.appendReplacement(sb, "_"  + m.group());
		}
		m.appendTail(sb);
		String result = sb.toString().toUpperCase();
		System.out.println(result); 
		return result;
		
	}
	
}
