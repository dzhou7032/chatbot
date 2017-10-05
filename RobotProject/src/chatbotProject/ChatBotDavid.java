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
		while(chatting) {
			response = ChatbotMain.getInput();
			for (int i =0;i<4; i++) {
				if (ChatbotMain.findKeyword(response, agreementWord[i], 0) >= 0) {
					ChatbotMain.print("Sweet, let's play guess my clothing!");
					playingGame = true;
					startPlaying(response);
					return;
				}}
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
		ChatbotMain.print("The rules of guess my clothing are simple, I think of a specific piece of clothing and you guess what I'm thinking based off of the hints I give you");
		int randomNum = (int)(Math.random() * 3);
		if (randomNum == 0) {
			String theAnswer = answers[0];
		}
		if (randomNum == 1) {
			String theAnswer = answers[1];
		}
		if (randomNum == 2) {
			String theAnswer = answers[2];
		}
		else {
			String theAnswer = answers[3];
		}
		while (playingGame) {
			response = ChatbotMain.getInput();
			
			
		}
		
	}
}

