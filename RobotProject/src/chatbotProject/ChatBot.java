package chatbotProject;

public class ChatBot {
	private String userName;
	private int happiness;
	private Topic David;
	private Topic Remington;
	private Topic Jason;
	private boolean chatting;
	
	public ChatBot() {
		David = new ChatBotDavid();
		Remington = new ChatbotRemington();
		userName = "unknown user";
		chatting = true;
		happiness = 1;
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
