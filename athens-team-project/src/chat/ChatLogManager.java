package chat;

import java.util.ArrayList;
import java.util.Date;

/*
 * time stamp format:19-03-2016 02:29:35.895
 */
public class ChatLogManager {
	/**
	 * Get the message according to the time
	 * M:12
	 * M--->month W--->Week D--->day H-->hour Min--->minutes   
	 */
	public static ArrayList<Message>getLogByTime(ArrayList<Message> loglist,String duration){
		if(duration.equals("ALL"))
			return loglist;
		 ArrayList<Message> newlist=new  ArrayList<Message>();
		 for(Message m:loglist){			 
			 int number=Integer.parseInt(duration.split(":")[1]);
			 switch(duration.split(":")[0]){
			 	case "M":{
			 		if(getnowMins()-getMins(m.getTimestamp())<=30*24*60*number)
			 			newlist.add(m);
			 		break;
			 	}
			 	case "W":{
			 		if(getnowMins()-getMins(m.getTimestamp())<=7*24*60*number)
			 			newlist.add(m);
			 		break;
			 	}
			 	case "D":{
			 		if(getnowMins()-getMins(m.getTimestamp())<=24*60*number)
			 			newlist.add(m);
			 		break;
			 	}
			 	case "H":{
			 		if(getnowMins()-getMins(m.getTimestamp())<=60*number)
			 			newlist.add(m);
			 		break;
			 	}
			 	case "Min":{
			 		if(getnowMins()-getMins(m.getTimestamp())<=number)
			 			newlist.add(m);
			 		break;
			 	}
			 	default:break;
			 }
	
		 }
		 return newlist;
	}
	
	public static ArrayList<Message>getLogBysender(ArrayList<Message> loglist,String name){
		if(name.length()==0)
			return loglist;
		ArrayList<Message> newlist=new  ArrayList<Message>();
		 for(Message m:loglist){
			 if(m.getSenderNickname().contains(name))
				 newlist.add(m);
		 }
		 return newlist;
		
	}
	public static  ArrayList<Message>getLog(ArrayList<Message> loglist,String duration,String name){
		ArrayList<Message> newlist=new ArrayList<Message>();
		newlist=getLogBysender(loglist,name);
		
		return getLogByTime(newlist,duration);
	}
		 

	
	@SuppressWarnings("deprecation")
	public static int getnowMins(){
		Date date=new Date();
		int month=(date.getMonth()+1)*30*24*60;
		int day=(date.getDate())*24*60;
		int hour=(date.getHours())*60;
		int min=date.getMinutes();
		
		return month+day+hour+min;
	}
	public static int getMins(String time){
		int month=Integer.parseInt(time.split("-")[1]);
		int day=Integer.parseInt(time.split("-")[0]);
		int hour=Integer.parseInt(time.split(" ")[1].split(":")[0]);
		int min=Integer.parseInt(time.split(" ")[1].split(":")[1]);
		
		return month*30*24*60+day*24*60+hour*60+min;
	}
	
	public static String print(ArrayList<Message> list){
		String s="";
		 for(Message m:list){
	        	s=s+m.getSenderNickname()+" ("+m.getSenderUsername()+" At "+m.getTimestamp().substring(0, 19)+") :"+m.getMessage()+"\n";
	     }
		 return s;
	}
	

}
