package chatbotProject;

public class ChatBot {
	private String userName;
	private int happiness;
	private int happinessMeter;
	private Topic David;
	private Topic Remington;
	private Topic Jason;
	private boolean chatting;
	private boolean HiS;
	
	public ChatBot() {
		David = new ChatBotDavid();
		Remington = new ChatbotRemington();
		Jason = new ChatbotJason();
		userName = "unknown user";
		chatting = true;
		happiness = 1;
		HiS = false;
	}
	public void startTalking() {
		
		ChatbotMain.print("My name is Salesbot. What's your name?");
		userName = ChatbotMain.getInput();
		ChatbotMain.print("Hey " + userName + "!");
		String response;
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if (Remington.isTriggered(response)&&(HiS==false)) {
				chatting = false;
				Remington.startChatting(response, happiness);
			}
			else if(Jason.isTriggered(response)) {
				chatting = false;
				Jason.startChatting(response, happiness);
			}
			else if(David.isTriggered(response)) {
				chatting = false;
				David.startChatting(response, happiness);
			}
			else {
				chatting = true;
				ChatbotMain.print("I'm sorry. I don't understand.");
			}
		}
	}
	public void increaseHappiness() {
		happinessMeter++;
		if (happinessMeter >5) {
			happiness = 2;
		}
	}
	public void decreaseHappiness() {
		happinessMeter--;
		if (happinessMeter < -5) {
			happiness = 0;
		}
	}
	public int getHappiness() {
		return happiness;
	}
	public void Toggletalk() {
		HiS = true;
	}
}
