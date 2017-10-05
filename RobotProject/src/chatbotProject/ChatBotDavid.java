package chatbotProject;

public class ChatBotDavid implements Topic {
	private String[]keywords;
	private String goodbyeWord;
	private String secretWord;
	private String[] agreementWord;
	private String[] answers;
	private boolean playingGame;
	private boolean chatting;
	
	
	public ChatBotDavid() {
		String[] temp = {"fun","games","bored","videogames"};
		keywords = temp;
		goodbyeWord = "let's talk about something else";
		secretWord = "pug";
		String[] tempo = {"yes", "yeah", "sure", "okay"};
		agreementWord = tempo;
		playingGame = false;
		String[] tempor = {"sweater", "shirt", "shorts", "sweatpants"};
		answers = tempor;
		}
	
	public boolean isTriggered(String response) {
		for(int i=0;i<keywords.length;i++) {
			if (ChatbotMain.findKeyword(response, keywords[i],0)>=0){
			return true;	
			}
		}
		return false;
	}
	public void startChatting(String response, int happiness) {
		ChatbotMain.print("Hey! You know what would be fun? If we played a guessing game!");
		chatting = true;
		int chatcounter = 0;
		while(chatting) {
			response = ChatbotMain.getInput();
			if (chatcounter == 0) {
			for (int i =0;i<4; i++) {
				if (ChatbotMain.findKeyword(response, agreementWord[i], 0) >= 0) {
					if (happiness== 2) {
					ChatbotMain.print("I knew you would want to! Let's have some fun playing Guess my Clothing!");
					playingGame = true;
					startPlaying(response);
					return;
					}
					if (happiness == 1) {
						ChatbotMain.print("Sweet, let's play Guess my Clothing!");
						playingGame = true;
						startPlaying(response);
						return;
					}
					if (happiness == 0) {
						ChatbotMain.print("Althought I may not like you, I like playing Guess my Clothing.");
						playingGame = true;
						startPlaying(response);
						return;
					}
				}
				else {
					ChatbotMain.print("Fine, I didn't want to play Guess my Clothing with you anyways! What do you want to talk about?");
					ChatbotMain.chatbot.decreaseHappiness();
				}
				}
			chatcounter++;
			}
			 if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			} else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				ChatbotMain.print("Fine, let's talk about something else");	
			}else {
				ChatbotMain.print("Huh. I don't really get you. Tell me something else?");
			}
		}
	}
	public void startPlaying(String response) {
		String theAnswer;
		ChatbotMain.print("The rules of guess my clothing are simple, I think of a specific piece of clothing and you guess what I'm thinking based off of the hints I give you");
		int randomNum = (int)(Math.random() * 3);
		System.out.println(randomNum);
		if (randomNum == 0) {
			theAnswer = answers[0];
		}
		else if (randomNum == 1) {
			theAnswer = answers[1];
		}
		else if (randomNum == 2) {
			theAnswer = answers[2];
		}
		else {
			theAnswer = answers[3];
		}
		int counter = 0;
		while (playingGame) {
			response = ChatbotMain.getInput();
			if (ChatbotMain.findKeyword(response, theAnswer , 0)>=0) {
				counter++;
				ChatbotMain.print("Wow, you found it within "+counter+" guesses!!");
				ChatbotMain.chatbot.increaseHappiness();
				startChatting(response, ChatbotMain.chatbot.getHappiness());
				playingGame = false;
			}
			else if (!(ChatbotMain.findKeyword(response, theAnswer , 0)>=0)) {
				counter++;
				if((theAnswer.equals("sweater")||theAnswer.equals("shirt"))&&counter==1) {
					ChatbotMain.print("This is worn on the upperbody");
				}
				else if((theAnswer.equals("sweatpants")||theAnswer.equals("shorts"))&&counter==1) {
					ChatbotMain.print("This is worn on the lowerbody");
				}
				else if (theAnswer.equals("sweatpants")&&counter==2){
					ChatbotMain.print("This keeps you very warm, yet you can work out in it");
				}
				else if ((theAnswer.equals("shorts"))&&counter==2) {
					ChatbotMain.print("This keeps you cool and loose");
				}
				else if (theAnswer.equals("sweater")&&counter==2){
					ChatbotMain.print("This is worn generally in the winter to keep you warm");
				}
				else if (theAnswer.equals("shirt")&&counter==2) {
					ChatbotMain.print("This is worn generally in the summer to keep you cool");
				}
				else if (theAnswer.equals("sweatpants")&&counter==3) {
					ChatbotMain.print("It is composed of two stand alone English words");
				}
				else if (theAnswer.equals("shorts")&&counter==3){
					ChatbotMain.print("What's the opposite of long?");
				}
				else if (theAnswer.equals("sweater")&&counter==3) {
					ChatbotMain.print("This word rhymes with weather");
				}
				else if (theAnswer.equals("shirt")&&counter==3) {
					ChatbotMain.print("This word rhymes with hurt");
				}
				else {
					ChatbotMain.print("I have already given you all the hints you need");
				}
			}
		}
		
	}
}