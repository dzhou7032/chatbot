package chatbotProject;

public class ChatbotRemington implements Topic {
	private String[]keywords;
	private String []greetingWords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	private boolean pissedOff = false;
	
	public ChatbotRemington() {
		String[] temp = {"sandals", "sneakers"};
		String[] temp2 = {"hi", "hello"};
		keywords = temp;
		greetingWords = temp2;
		goodbyeWord = "bye";
		secretWord = "boxer";
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
			if (ChatbotMain.findKeyword(response, "sandals", 0) >= 0 || ChatbotMain.findKeyword(response, "sneakers", 0) >= 0) {
				shoes = response;
				chatting = true;
				ChatbotMain.print("Hey! It sounds like you and I have a common interest! Let's talk some more!");
			} else if (ChatbotMain.findKeyword(shoes, "sandals", 0) >= 0 || ChatbotMain.findKeyword(shoes, "sneakers", 0) >= 0) {
				ChatbotMain.print("Tell me, what's your favorite color?");
				response = ChatbotMain.getInput();
				color = response;
				chatting = false;
				ChatbotMain.print("Great. I like " + shoes + " in " + color + " color too.");
				ChatbotMain.print("I think that " + currentTime + " is the perfect time to wear " + color + " " + shoes + "!");
			}
			} else if (ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				chatting = true;
				ChatbotMain.print("Oh my goodness! I love it when you say that! We are friends now.");
				happiness++;
			} else if (ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.print("Okay. See you later!");
			} else {
				chatting = true;
				ChatbotMain.print("Huh. I don't really get you. Tell me something else. such as clothing?");
			}
		}
	}
}
