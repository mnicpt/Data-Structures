

public class StringUtils {

	public static boolean uniqueChars(String str) {
		for(int index = 0; index < str.length(); index++) {
			if(index != str.lastIndexOf(str.charAt(index))) {
				return false;
			}
		}
		
		return true;
	}

	public static String reverse(String str) {
		char[] characters = str.toCharArray();
		StringBuffer reverseString = new StringBuffer();
		int length = str.contains("\0") ? str.length() - 2 : str.length() - 1;
		
		for(int i = length; i >= 0; i--) {
			reverseString.append(characters[i]);
		}
		return reverseString.toString();
	}

	public static boolean permutation(String str1, String str2) {
		//check length
		if(str1.length() == str2.length()) {
			//check same characters
			char[] str1Chars = str1.toCharArray();
			char[] str2Chars = str2.toCharArray();
			for(int i = 0; i < str1.length(); i++) {
				int index = str2.indexOf(str1Chars[i]);
				if(index == -1) {
					return false;
				}
				
				//remove found character
				str2Chars[index] = ' ';
				str2 = String.valueOf(str2Chars);
			}
		} else {
			return false;
		}
		return true;
	}

	public static String encodeString(String str, char characterToReplace, String encoder) {
		char[] characters = str.toCharArray();
		
		//how many characters need replacing
		int charactersToReplace = 0;
		for(char character : characters) {
			if(characterToReplace ==  character) {
				charactersToReplace ++;
			}
		}
		
		//how long is the encoder
		int encoderLength = encoder.length();
		
		int index = 0;
		char[] convertedString = new char[str.length() + (charactersToReplace * encoderLength)];
		char[] encoderCharacters = encoder.toCharArray();
		for(int i = 0; i < str.length(); i++) {
			char character = characters[i];
			if(characterToReplace == character) {
				for(int j = 0; j < encoder.length(); j++) {
					convertedString[index] = encoderCharacters[j];
					index++;
				}
			} else {
				convertedString[index] = character;
				index++;
			}
		}
		
		return String.valueOf(convertedString).trim();
	}

	public static String compress(String value) {
		StringBuffer compressedString = new StringBuffer();
		String character = "";
		int strLen = value.length();
		int newLen = 0;
		
		while(strLen != 0) {
			character = String.valueOf(value.charAt(0));
			value = value.replace(character, "");
			newLen = value.length();
			if((strLen - newLen) == 1) {
				compressedString.append(character);
			} else {
				compressedString.append(character + (strLen - newLen));
			}
			strLen = value.length();
		}
		return compressedString.toString();
	}
}
