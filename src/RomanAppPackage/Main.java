package RomanAppPackage;

public class Main {

	public static void main(String[] args) {
		
		
		//test the thing
		testNumberToRomanNumeral();
		System.out.println("\n");
		testRomanNumeralToNumber();
		
		
	}
		
	//this method displays all numbers from 1 to 3999 followed by the same value in Roman numeral form
	private static void testNumberToRomanNumeral(){
		
		int number = 0;
		String romanNumeral = "";
		
		for(int i = 1; i <4000; i++){					
			
			number = i;
			romanNumeral = Methods.numberToRomanNumeral(i);
			
			System.out.println(number + "\t" + romanNumeral);
			
		}
		
	}
	
	//this method displays all roman numerals from 1 to 3999 followed by the same value in numeric form
	private static void testRomanNumeralToNumber(){
	    
	    int number = 0;
	    String romanNumeral = "";
	    
	    for(int i = 1; i <4000; i++){					
			
			romanNumeral = Methods.numberToRomanNumeral(i);
			
			number = Methods.romanNumeralToNumber(romanNumeral);
			
			System.out.print(romanNumeral + "\t");
			if(romanNumeral.length()<8){
			    System.out.print("\t");
			}
			System.out.println(number);
		}
	    
	}
	
}
