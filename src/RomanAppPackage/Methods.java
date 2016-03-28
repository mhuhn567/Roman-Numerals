
package RomanAppPackage;

public class Methods {

	//--------------------------------------------------------------------
	// Number To Roman Numeral
	//--------------------------------------------------------------------
	
	public static String numberToRomanNumeral(int numericValue){
		
                //declare some variables and objects
		String result = "!";
		String valueString = "!";
                StringBuilder resultBuilder = new StringBuilder();
                char digit = '!';
                
                //prepare a string that is the reverse of the number input - this is for easily pulling digits from smallest to biggest
                valueString = String.valueOf(numericValue);
		String reverseString = new StringBuffer(valueString).reverse().toString();

		if(numericValue > 0 && numericValue < 4000){

			for(int i = 0; i < reverseString.length(); i++){    //here i is the unit, i.e. ones, tens, hundreds, or thousands

				digit = reverseString.charAt(i);	    //grabs the digit that corresponds to i
                                
				resultBuilder.insert(0, digitToRomanNumeral(digit, i));  //builds result by sending digit and unit to digitToRomanNumeral
			

			}

		}else{
			result = "Invalid entry. Number must lie between 0 and 4000.";	 //just in case
		}
		
                result = resultBuilder.toString();
		return result;
		
	}
	
	//--------------------------------------------------------------------
	// Digit To Roman Numeral
	//--------------------------------------------------------------------
	
	public static String digitToRomanNumeral(char digit, int unit){
		
		//declare variables, objects
		StringBuilder resultBuilder = new StringBuilder();
		String result = "";
		char one = '!';
		char five = '!';
		char ten = '!';
		
		//make an integer from the digit character
		int intDigit = Character.getNumericValue(digit);
		
		
	    //if you are not familiar with switches - think of this as a series of if/else statements
	    //asking whether unit is equal to 0, 1, 2, or 3
            switch (unit) {
                case 0:
                    one = 	'I';		//depending on what unit we are converting to Roman numerals,
                    five = 	'V';		//the symbols we use to represent one, five and ten will vary
                    ten = 	'X';
                    break;
                case 1:
                    one = 	'X';		//when dealing in units of 10, X represents one unit
                    five = 	'L';		//when dealing in units of 10, L represents five units
                    ten = 	'C';		//when dealing in units of 10, C represents ten units
                    break;
                case 2:
                    one = 	'C';		//when dealing in units of 100, C represents one unit
                    five = 	'D';		//when dealing in units of 100, D represents five units
                    ten = 	'M';		//when dealing in units of 100, M represents ten units
                    break;
                case 3:
                    one =	'M';		//when dealing in units of 1000, M represents one unit
                    five =      '!';		//is not used under 4000 - if an '!' is printed there is a problem
                    ten = 	'!';		//is not used under 4000 - if an '!' is printed there is a problem
                    break;
                default:
                    break;
            }
		
		//now we build the Roman numeral for the digit - all inserts are at the BEGINNING of the resultBuilder
		if(intDigit <4){
			
			for(int i=0; i<intDigit; i++){			//this loop inserts the appropriate number of ones
			    
				resultBuilder.insert(0, one);		//insert a one (this could be I, X, C, or M)
				
			}
			
		}else if(intDigit == 4){
			
			resultBuilder.insert(0, five);			//insert a five (this could be a V, L, or D)
			resultBuilder.insert(0, one);			//insert a one (this could be I, X, C or M)
			
		}else if(intDigit == 5){
			
			resultBuilder.insert(0, five);			//insert a five (this could be a V, L, or D)
			
		}else if(intDigit <= 8){
			
			for(int i=0; i<(intDigit-5); i++){

				resultBuilder.insert(0, one);		//this loop inserts the appropriate number of ones

			}
			resultBuilder.insert(0, five);			//insert a five (this could be a V, L, or D)
			
		}else{
			resultBuilder.insert(0, ten);			//insert a ten (this could be an X, C, or M)
			resultBuilder.insert(0, one);
		}
		
		
		result = resultBuilder.toString();
		return result;
		
	}
	
	//--------------------------------------------------------------------
	// Roman Numeral To Number
	//--------------------------------------------------------------------
	public static int romanNumeralToNumber(String romanString){
	    
	    int result = 0;
	    StringBuilder roman = new StringBuilder(romanString);
	    
	    while(roman.toString().contains("M") == true){
		if(roman.charAt(0)=='M'){
		    result+=1000;
		    roman.deleteCharAt(0);
		}else if(roman.charAt(0)=='C'){
		    result+=900;
		    roman.deleteCharAt(0);
		    roman.deleteCharAt(0);
		}
	    }
	    
	    while(roman.toString().contains("D") == true){
		if(roman.charAt(0)=='D'){
		    result+=500;
		    roman.deleteCharAt(0);
		}else if(roman.charAt(0)=='C'){
		    result+=400;
		    roman.deleteCharAt(0);
		    roman.deleteCharAt(0);
		}
	    }
	    
	    while(roman.toString().contains("C") == true){
		if(roman.charAt(0)=='C'){
		    result+=100;
		    roman.deleteCharAt(0);
		}else if(roman.charAt(0)=='X'){
		    result+=90;
		    roman.deleteCharAt(0);
		    roman.deleteCharAt(0);
		}
	    }
	    
	    while(roman.toString().contains("L") == true){
		if(roman.charAt(0)=='L'){
		    result+=50;
		    roman.deleteCharAt(0);
		}else if(roman.charAt(0)=='X'){
		    result+=40;
		    roman.deleteCharAt(0);
		    roman.deleteCharAt(0);
		}
	    }
	    
	    while(roman.toString().contains("X") == true){
		if(roman.charAt(0)=='X'){
		    result+=10;
		    roman.deleteCharAt(0);
		}else if(roman.charAt(0)=='I'){
		    result+=9;
		    roman.deleteCharAt(0);
		    roman.deleteCharAt(0);
		}
	    }
	    
	    while(roman.toString().contains("V") == true){
		if(roman.charAt(0)=='V'){
		    result+=5;
		    roman.deleteCharAt(0);
		}else if(roman.charAt(0)=='I'){
		    result+=4;
		    roman.deleteCharAt(0);
		    roman.deleteCharAt(0);
		}
	    }
	    
	    while(roman.toString().contains("I") == true){
		if(roman.charAt(0)=='I'){
		    result+=1;
		    roman.deleteCharAt(0);
		}
	    }
	    
	    return result;
	    
	}
}