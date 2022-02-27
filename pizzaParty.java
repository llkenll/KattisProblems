package CompetitiveProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class pizzaParty {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		
		int len = Integer.parseInt(obj.nextLine());
		
		ArrayList<String> toppings = new ArrayList<String>();
		ArrayList<HashSet<String>> andAntecedents = new ArrayList<>();
		ArrayList<HashSet<String>> orAntecedents = new ArrayList<>();
		ArrayList<String> andConsequent =new ArrayList<>();
		ArrayList<String> orConsequent =new ArrayList<>();
		
		HashMap<String, String> general = new HashMap<>();
		ArrayList<String> generalAntecdent =new ArrayList<>();
		ArrayList<String> generalConsequent =new ArrayList<>();
		
		
		for(int i = 0; i < len; i++) {
			String current = obj.nextLine();
			String[] currentArray = current.split(" ");
			if(currentArray[0].equals("if") && currentArray[2].equals("or")) {
				String[] currentArr = current.split("or");
				String temp = currentArr[0].substring(3);
				currentArr[0] = temp;
				HashSet<String> antecedents = new HashSet<String>();
				for(int a = 0; a < currentArr.length-1; a++) {
					currentArr[a] = currentArr[a].replaceAll("\\s", "");
					antecedents.add(currentArr[a]);
				}
				String[] last = currentArr[currentArr.length-1].split("then");
				last[0] = last[0].replaceAll("\\s", "");
				last[1] = last[1].replaceAll("\\s", "");
				antecedents.add(last[0]);
				orConsequent.add(last[1]);
				orAntecedents.add(antecedents);
				
			}else if(currentArray[0].equals("if") && currentArray[2].equals("and")) {
				String[] currentArr = current.split("and");
				
				String temp = currentArr[0].substring(3);
				currentArr[0] = temp;
				HashSet<String> antecedents = new HashSet<String>();
				for(int a = 0; a < currentArr.length-1; a++) {
					currentArr[a] = currentArr[a].replaceAll("\\s", "");
					antecedents.add(currentArr[a]);
				}
				
				String[] last = currentArr[currentArr.length-1].split("then");
				last[0] = last[0].replaceAll("\\s", "");
				last[1] = last[1].replaceAll("\\s", "");
				antecedents.add(last[0]);
				andConsequent.add(last[1]);
				andAntecedents.add(antecedents);
			}else if(currentArray[0].equals("if")){
				String[] currentArr = current.split(" ");
				generalAntecdent.add(currentArr[1]);
				generalConsequent.add(currentArr[3]);
				
			}else {
				toppings.add(current);
				
				
			}
		}
		
		
		for(int i = 0; i < toppings.size(); i++) {
		
			String topping = toppings.get(i);
			
			
			for(int a = 0 ; a < generalAntecdent.size(); a++) {
				if(generalAntecdent.get(a).equals(topping)) {
					toppings.add(generalConsequent.get(a));
				}
			}
			
				
				for(int j = 0; j < andAntecedents.size(); j++) {
					if(!andAntecedents.get(j).isEmpty()) {
						
						HashSet<String> currentAntecedents = andAntecedents.get(j);
						if(currentAntecedents.contains(topping)) {
							andAntecedents.get(j).remove(topping);
							
							if(andAntecedents.get(j).isEmpty()) {
								String consequent = andConsequent.get(j);
								toppings.add(consequent);
							}
							
						}
						
					}
					
					
					
				}
				
				
			
				for(int k = 0; k < orAntecedents.size(); k++) {
					if(!orAntecedents.get(k).isEmpty()) {
						HashSet<String> currentAntecedents = orAntecedents.get(k);
						if(currentAntecedents.contains(topping)) {
							String consequent = orConsequent.get(k);
							toppings.add(consequent);
						}
						
					}
				}

				
		}
		
		
		
		HashSet<String> result = new HashSet<String>();
		
		for(int i = 0; i < toppings.size(); i++) {
			result.add(toppings.get(i));
		}
		 long size = result.size();
		System.out.println(size);
		
	
		
	}
	
	
		
		
}
