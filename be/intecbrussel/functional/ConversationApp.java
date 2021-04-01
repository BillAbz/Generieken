package be.intecbrussel.functional;

public class ConversationApp {

    public static void main(String[] args) {

        IConversation conversation1 = new IConversation() {
            @Override
            public String printMessage(String message) {
                System.out.println("Message: " + message);
                if(message.contains("Hello")){
                    return "No more hello world examples please";
                } else {
                    return "Thank you for another world!";
                }
            }
        };

        String messageResult1 = conversation1.printMessage("RoboVoice..");
        System.out.println(messageResult1);

        IConversation conversation2 = message -> {
            System.out.println("Message: " + message);
            if(message.contains("Hello")){
                return "No more hello world examples please";
            } else {
                return "Thank you for another world!";
            }
        };

        System.out.println("---------------------------------------");

        String messageResult2 = conversation2.printMessage("Hello world!");
        System.out.println(messageResult2);



    }

}
