package chatbotProject;

import java.util.*;
import java.io.*;

public class ChatbotRemington implements Topic {
	private String[]keywords;
	private String []greetingWords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	private boolean pissedOff = false;
	private String feeling = "";
	


	
	
	
	public ChatbotRemington() {
		String[] temp = {"shoes", "sneakers"};
		String[] temp2 = {"hi", "hello", "hey"};
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
			ChatbotMain.print("Now that we've said our hellos, let's continue the conversation. How are you doing?");
			happiness++;

			while(chatting) {
				response = ChatbotMain.getInput();				
				if(ChatbotMain.findKeyword(response, "good", 0)>= 0 || ChatbotMain.findKeyword(response, "great", 0) >= 0 || ChatbotMain.findKeyword(response, "ok", 0) >= 0 || ChatbotMain.findKeyword(response, "well", 0) >= 0) {
					happiness++;
					chatting = false;
					continueChatting(response, happiness);
				}
				else {
					ChatbotMain.print("Wow... where are your manners??");
					happiness--;
					pissedOff = true;
					chatting = true;
					ChatbotMain.print("I'm not talking to you until you tell me how you feel.");
				}
			}
		}
	public void continueChatting(String response, int happiness) {
		//feeling = response;
		chatting = true;
		String footwear = "";
		String color = "";
		ChatbotMain.print("Okay. Let's continue the conversation. What do you want to talk about?");
		happiness++;
		while(chatting) {
			response = ChatbotMain.getInput();
			if (ChatbotMain.findKeyword(response, "shoes", 0) >= 0 || ChatbotMain.findKeyword(response, "sneakers", 0) >= 0) {
				footwear = response;
				chatting = true;
				ChatbotMain.print("Hey! It sounds like you and I have a common interest! Let's talk some more! Tell me, what's your favorite color (ROYGBIV)?");
			} else if (ChatbotMain.findKeyword(response, "red", 0) >= 0 || ChatbotMain.findKeyword(response, "orange", 0) >= 0 ||
						ChatbotMain.findKeyword(response, "yellow", 0) >= 0 || ChatbotMain.findKeyword(response, "green", 0) >= 0 ||
						ChatbotMain.findKeyword(response, "blue", 0) >= 0 || ChatbotMain.findKeyword(response, "purple", 0) >= 0 ||
						ChatbotMain.findKeyword(response, "indigo", 0) >= 0 || ChatbotMain.findKeyword(response, "violet", 0) >= 0 ||
						ChatbotMain.findKeyword(response, "white", 0) >= 0 || ChatbotMain.findKeyword(response, "black", 0) >= 0 ){
				color = response;
				chatting = false;
				happiness++;
				ChatbotMain.print("What?! I like " + color + " " + footwear + " too!");
				ChatbotMain.print("You know what would be perfect? If you wore " + color + " " + footwear + " on New Years Day!");
				
				Calendar myCal = Calendar.getInstance();
				myCal.set(2018, 0, 1);
				Date newYearsDay = myCal.getTime();
				Date todaysDate = Calendar.getInstance().getTime();
				
				//diff in msec:
				long diff = newYearsDay.getTime() - todaysDate.getTime();
				//diff in days:
				long days = diff / (24 * 60 * 60 * 1000);				
				
				ChatbotMain.print("Today is " + todaysDate + ". Only " + days + " days until the new year!");
			} else if (ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				chatting = true;
				ChatbotMain.print("Oh my goodness! I love money as well! We are friends now. Anything else?");
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
