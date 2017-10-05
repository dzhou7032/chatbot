package chatbotProject;

public class ChatbotJason implements Topic {
	private String[]keywords;
	private String goodbyeWord;
	private String[] negativeWords;
	private String secretWord;
	private boolean chatting;

	
	public ChatbotJason() {
		String[] temp = {"no","don't","not"};
		String[] temp2 = {"no" , "don't"};
		negativeWords = temp2;
		keywords = temp;
		goodbyeWord = "bye";
		secretWord = "cloth";
	}
	
	public boolean isTriggered(String response) {
		for(int i=0;i<keywords.length;i++) {
			if (ChatbotMain.findKeyword(response, keywords[i],0)>=0){
			return true;	
			} //s
		}
		return false;
	}
	public void startChatting(String response, int happiness) {
		ChatbotMain.print("But our products are the best! What types of clothing do you like?");
		String preferredItem = ChatbotMain.getInput();
		ChatbotMain.print("Do you want to buy it?");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			} else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever. We are friends now.");	
			}
			else {
					boolean understand = false;
					for (int i=0; i<= negativeWords.length-1; i++ ) {
						if(ChatbotMain.findKeyword(response, negativeWords[i], 0) != -1) {
							convincePerson(preferredItem);
							understand = true;
							break;
						}
					}
					if (!understand) {
						ChatbotMain.print("Huh. I don't really get you. Tell me something else?");
					}
				
		
			}
			/*else {
				ChatbotMain.print("Huh. I don't really get you. Tell me something else?"); */
			}
		}

	public void convincePerson(String item) {
		boolean convinced = false;
		int counter = 0;
		String response = "";
		if (ChatbotMain.findKeyword(response, "yes", 0) == -1) {
		
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
						ChatbotMain.print("Fine! Do you want " + item.toLowerCase() + " then?");
					}
					else if (counter == 4) {
						ChatbotMain.print("But you said you liked " + item.toLowerCase() +  ". Im confused! >:(");
					}
					else if (counter == 5) {
						flame();
						break;
					} 
					response = ChatbotMain.getInput();
					counter++;
					
				}else {
					convinced = true;
					ChatbotMain.print("That's amazing!");
				}
			}
		}
	}
	public void flame() {
		ChatbotMain.print("You think your cool!?!");
	}
}
