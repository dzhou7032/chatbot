package chatbotProject;

public class ChatbotJason implements Topic {
	private String[]keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;

	
	public ChatbotJason() {
		String[] temp = {"no","don't","not"};
		keywords = temp;
		goodbyeWord = "bye";
		secretWord = "cloth";
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
		ChatbotMain.print("But our products are the best!");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			} else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever. We are friends now.");	
			}
			else if(ChatbotMain.findKeyword(response, "don't", 0) != -1 && ChatbotMain.findKeyword(response, "buy", 0) != -1) {
				ChatbotMain.print("hi");
				convincePerson();
			}
			else {
				ChatbotMain.print("Huh. I don't really get you. Tell me something else?");
			}
		}
	}
	public void convincePerson() {
		boolean convinced = false;
		int counter = 0;
		String response = "";
		if (ChatbotMain.findKeyword(response, "yes", 0) == -1) {
		}
		while(!convinced) {
			if (ChatbotMain.findKeyword(response, "yes", 0) == -1) {
				if (counter == 0) {
				ChatbotMain.print("Are you sure? There is a 10% off deal!");
				}
				else if(counter == 1) {
					ChatbotMain.print("Why!?!");
				}
				else if (counter == 2) {
					ChatbotMain.print("Will a 50% discount change your mind?");
				}
				else if (counter == 3) {
					convinced = true;
					flame();
					break;
				} 
				response = ChatbotMain.getInput();
				counter++;
				
			}else {
				convinced = true;
			}
			
		
		}
	}
	public void flame() {
		ChatbotMain.print("You think your cool!?!");
	}
}
