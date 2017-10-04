package chatbotProject;

public class ChatBotDavid implements Topic {
	private String[]keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ChatBotDavid() {
		String[] temp = {"fun","games","bored","videogames"};
		keywords = temp;
		goodbyeWord = "let's talk about something else";
		secretWord = "pug";
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
	public void startPlaying() {
		
	}
}

