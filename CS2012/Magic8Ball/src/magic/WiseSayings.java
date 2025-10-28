package magic;

import java.util.ArrayList;
import java.util.Random;

public class WiseSayings {
		
		
    private String[] sayings = {
            "As I see \n it, yes.",
            "Ask again \n later.",
            "Better not \n tell \nyou now.",
            "Cannot \n predict \n now.",
            "Concentrate \n and \n ask again.",
            "Don't \n count \n on it.",
            "It is certain.",
            "It is \n decidedly \n so.",
            "Most likely.",
            "My reply is no.",
            "My sources \n say no.",
            "Outlook \n not \n so good.",
            "Outlook good.",
            "Reply hazy,\n try again.",
            "Signs point \n to yes.",
            "Very doubtful.",
            "Without \n a \n doubt.",
            "Yes.",
            "Yes - \n definitely.",
            "You may \n rely on it."
    };
    
	
	String getRandomSaying() {
		
		Random ran = new Random();
        return sayings[ran.nextInt(sayings.length)];
        
	}
	
	

}
