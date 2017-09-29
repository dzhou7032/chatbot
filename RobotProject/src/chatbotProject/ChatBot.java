package chatbotProject;

public class ChatBot {
	private String userName;
	private Topic David;
	private boolean chatting;
	
	public ChatBot() {
		David = new ChatBotDavid();
		userName = "unknown user";
		chatting = true;
	}
	public void startTalking() {
		ChatbotMain.print("Welcome to our chatbot! What is your name?");
		userName = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What do you want to talk about?");
			String response = ChatbotMain.getInput();
			if (David.isTriggered(response)) {
				chatting = false;
				David.startChatting(response);
			}
			else {
				ChatbotMain.print("I'm sorry. I don't understand.");
			}
		}
	}

}
