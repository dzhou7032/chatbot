package chatbotProject;

public class ChatbotRemington implements Topic {
	private String[]keywords;
	private String []greetingWords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	private boolean pissedOff = false;
	
	public ChatbotRemington() {
		String[] temp = {"clothing","clothes","color"};
		String[] temp2 = {"hi", "hello"};
		keywords = temp;
		greetingWords = temp2;
		goodbyeWord = "bye";
		secretWord = "sneakers";
	}
	
	public boolean isTriggered(String response) {
		for(int i=0;i<keywords.length;i++) {
			if (ChatbotMain.findKeyword(response, greetingWords[i],0)>=0){
			return true;	
			}
		}
		return false;
	}
	public void feelingsHurt(String response, int happiness, boolean pissedOff) {
		while(chatting) {
			response = ChatbotMain.getInput();
			for(int i=0;i<greetingWords.length;i++) {
				if (ChatbotMain.findKeyword(response, greetingWords[i],0)>=0){
					ChatbotMain.print("Awesome! Let's talk!");
				}
				else {
					ChatbotMain.print("Wow... where are your manners??");
					happiness--;
					pissedOff = true;
					if(pissedOff = true) {
						ChatbotMain.print("I'm not talking to you until you greet me.");
					}
				}
			}
		}
	}
	public void startChatting(String response, int happiness) {
		//i need feelings hurt to run first!@!!!!!
			ChatbotMain.print("Hey! It sounds like you and I have a common interest! Let's talk some more!");
			chatting = true;
			while(chatting) {
				response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
					chatting = false;
					ChatbotMain.chatbot.startTalking();
				} else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
					ChatbotMain.print("Oh my goodness! I love it when you say that! We are friends now.");
					happiness++;
				}else {
					ChatbotMain.print("Huh. I don't really get you. Tell me something else?");
				}
			}
		}
	/*public void startChatting(String response, int happiness) {
		ChatbotMain.print("Hey! It sounds like you and I have a common interest! Let's talk some more!");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			} else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				ChatbotMain.print("Oh my goodness! I love it when you say that! We are friends now.");
				happiness++;
			}else {
				ChatbotMain.print("Huh. I don't really get you. Tell me something else?");
			}
		}
	} */
}
