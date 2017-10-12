package chatbotProject;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class ChatbotRemington implements Topic {
	private String[]keywords;
	private String []greetingWords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	private boolean pissedOff = false;
	java.util.Date todaysDate = Calendar.getInstance().getTime();
	
	/*Calendar start = Calendar.getInstance();
	Calendar end = Calendar.getInstance();
	start.set(2010, 7, 23);
	end.set(2010, 8, 26);
	Date startDate = start.getTime();
	Date endDate = end.getTime();
	long startTime = startDate.getTime();
	long endTime = endDate.getTime();
	long diffTime = endTime - startTime;
	long diffDays = diffTime / (1000 * 60 * 60 * 24);
	DateFormat dateFormat = DateFormat.getDateInstance();
	System.out.println("The difference between "+
	  dateFormat.format(startDate)+" and "+
	  dateFormat.format(endDate)+" is "+
	  diffDays+" days.");*/
	
	
	
	public ChatbotRemington() {
		String[] temp = {"footwear", "sneakers"};
		String[] temp2 = {"hi", "hello, hey"};
		keywords = temp;
		greetingWords = temp2;
		goodbyeWord = "bye";
		secretWord = "money";
	}
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < greetingWords.length; i++) {
			/*if (ChatbotMain.findKeyword(response, "hello", 0)>= 0 || ChatbotMain.findKeyword(response, "hi", 0) >= 0 || ChatbotMain.findKeyword(response, "hey", 0) >= 0){
				return true;	
			}*/
			
			if (ChatbotMain.findKeyword(response, greetingWords[i], 0) >= 0)
			{
				return true;
			}
			
		}
		return false;
	}
	public void startChatting(String response, int happiness) {
			chatting = true;
			while(chatting) {
				//response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, "hello", 0)>= 0 || ChatbotMain.findKeyword(response, "hi", 0) >= 0 || ChatbotMain.findKeyword(response, "hey", 0) >= 0) {
					ChatbotMain.print("Now that we've said our hellos, let's continue the conversation. What would you like to talk about?");
					happiness++;
					response = ChatbotMain.getInput();
					continueChatting(response, happiness);
				}
				else {
					ChatbotMain.print("Wow... where are your manners??");
					happiness--;
					pissedOff = true;
					ChatbotMain.print("I'm not talking to you until you greet me.");
				}
			}
		}
	public void continueChatting(String response, int happiness) {
		String shoes = "";
		String color = "";
		while(chatting) {
			//response = ChatbotMain.getInput();
			if (ChatbotMain.findKeyword(response, "footwear", 0) >= 0 || ChatbotMain.findKeyword(response, "sneakers", 0) >= 0) {
				shoes = response;
				chatting = true;
				ChatbotMain.print("Hey! It sounds like you and I have a common interest! Let's talk some more!");
			} else if (ChatbotMain.findKeyword(shoes, "footwear", 0) >= 0 || ChatbotMain.findKeyword(shoes, "sneakers", 0) >= 0) {
				ChatbotMain.print("Tell me, what's your favorite color?");
				response = ChatbotMain.getInput();
				color = response;
				chatting = false;
				ChatbotMain.print("What?! I like " + color + " " + shoes + " too!");
				ChatbotMain.print("You know what would be perfect? If you wore " + color + " " + shoes + " on New Years Day!");
				ChatbotMain.print("Today is " + todaysDate + ". Only " + + " days until the new year!");
			}  
				if (ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				chatting = true;
				ChatbotMain.print("Oh my goodness! I love money as well! We are friends now.");
				happiness++;
			} else if (ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.print("Okay. See you later!");
			} else {
				chatting = true;
				ChatbotMain.print("Huh. I don't really get you. Tell me something else– such as sneakers.");
			}
		}
	}
}
