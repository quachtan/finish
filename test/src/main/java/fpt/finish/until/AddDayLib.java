package fpt.finish.until;

public class AddDayLib {
	public String addday1(String day){
		String subStrmy=day.substring(0, 8);
		String subStrd=day.substring(8);
		int intStr=Integer.parseInt(subStrd);
		intStr+=1;
		subStrd=String.valueOf(intStr);	
		return subStrmy.concat(subStrd);
	}
	public String addday2(String day){
		String subStrmy=day.substring(0, 8);
		String subStrd=day.substring(8);
		int intStr=Integer.parseInt(subStrd);
		intStr+=2;
		subStrd=String.valueOf(intStr);	
		return subStrmy.concat(subStrd);
	}
	public String addday3(String day){
		String subStrmy=day.substring(0, 8);
		String subStrd=day.substring(8);
		int intStr=Integer.parseInt(subStrd);
		intStr+=3;
		subStrd=String.valueOf(intStr);	
		return subStrmy.concat(subStrd);
	}
	public String addday4(String day){
		String subStrmy=day.substring(0, 8);
		String subStrd=day.substring(8);
		int intStr=Integer.parseInt(subStrd);
		intStr+=4;
		subStrd=String.valueOf(intStr);	
		return subStrmy.concat(subStrd);
	}
	public String addday5(String day){
		String subStrmy=day.substring(0, 8);
		String subStrd=day.substring(8);
		int intStr=Integer.parseInt(subStrd);
		intStr+=5;
		subStrd=String.valueOf(intStr);	
		return subStrmy.concat(subStrd);
	}
	public String addday6(String day){
		String subStrmy=day.substring(0, 8);
		String subStrd=day.substring(8);
		int intStr=Integer.parseInt(subStrd);
		intStr+=6;
		subStrd=String.valueOf(intStr);	
		return subStrmy.concat(subStrd);
	}
	
}
