import java.util.Scanner;


class bot{
	int direction;
	int x;
	int y;
	
	
	public bot(int d, int inputX, int inputY) {
		this.direction = d;
		this.x = inputX;
		this.y = inputY;
	}

}

class glitchBot {
	
	
	public static String first(String instruction) {
		if(instruction.equals("Left")) {
	        return "Right";
	    }
	    if(instruction.equals("Right")) {
	        return "Forward";
	    }
	    else {
	        return "Left";
	    }
	}
	
	public static String second(String instruction) {
		if(instruction.equals("Left")) {
			return "Forward";
		}
		
		if(instruction.equals("Right")) {
			return "Left";
		}else {
			return "Right";
		}
		
		
	}
	
	public static void turn(bot gb, String inputDirection) {
		if(inputDirection.equals("Left")) {
			gb.direction--;
		}else if(inputDirection.equals("Right")) {
			gb.direction++;
		}
		
		 if(gb.direction < 0) {
	        	gb.direction += 4;
	        }

	       if(gb.direction > 3) {
	        	gb.direction -= 4;
	        }
		
	}
	
	public static void moveBot(bot gb, String direction){
		if(direction.equals("Forward")) {
	        if(gb.direction == 0) {
	            gb.y++;
	        }
	        if(gb.direction == 1) {
	            gb.x++;
	        }
	        if(gb.direction == 2) {
	            gb.y--;
	        }
	        if(gb.direction == 3) {
	            gb.x--;
	        }
	       
	    }
	    else {
	        turn(gb, direction);
	    }
		
	}
	
	
	static boolean process(bot gb, String[] coordinates, String[] moves) {

	    for(String i : moves) {
	        moveBot(gb, i);
	    }
	    
	    int x= Integer.parseInt(coordinates[0]);

	    if( x == gb.x && Integer.parseInt(coordinates[1]) == gb.y) {
	        return true;
	    }

	    return false;
	}

	
	
	
	
	

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		String[] coordinates = obj.nextLine().split(" ");
		String num = obj.nextLine();
		int inputNum = Integer.parseInt(num);
		String[] moves = new String[inputNum];
		
		
		bot glitchBot = new bot(0, 0, 0);
		
		for(int i = 0; i < inputNum; i++) {
			String move = obj.nextLine();
			moves[i] = move;
		}
		
		for(int i = 0; i < inputNum; i++) {
			String temp = moves[i];
			moves[i] = first(temp);
			if(process(glitchBot, coordinates, moves)) {
				System.out.println(i+1+" "+ moves[i]);
				return;
			}
			
			moves[i] = second(temp);
			glitchBot = new bot(0, 0, 0);
			if(process(glitchBot, coordinates, moves)) {
				System.out.print(i+1+" "+ moves[i]);
				return;
			}
			moves[i] = temp;
			glitchBot = new bot(0, 0, 0);
			
		}
		
		
		
	}

}
