import java.util.Scanner;

public class PassWordValidator 
{

	public static void main(String[] args) 
	{
		// Initialize variables
		String userName;
		String password;
		
		boolean isValid = false;
		
		// Create a new scanner object
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("|| Create an Account ||");
		System.out.print("Please enter a Username: ");
		
		userName = keyboard.nextLine();
		
		// Create a new password validator object
		PassWordValidator pv = new PassWordValidator();
		
		do
		{
			System.out.println("Your password must contain" + "\n"
					+ "1. 8 - 16 characters" + "\n"
					+ "2. At least one uppercase value" + "\n"
					+ "3. At least one special character: !@#$%" + "\n"
					+ "4. Your password may not have any spaces or contain the word password in any case.");
			System.out.print("Please enter a password: ");
			
			password = keyboard.nextLine();
			
			isValid = pv.isPasswordValid(password);
			
		}while(!isValid);	// Loop until password is valid.
		
		System.out.println("Your password is valid. Thank you.");
		
		getAscii(password);
	}
	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean isPasswordValid(String password)
	{
		// Initialize variables
		boolean isValid = false;
		boolean lengthValid, upperCase, specialChar, containsPass, spaceIn;
		
		// Call methods
		lengthValid = isLengthValid(password);
		upperCase = hasUpperCase(password);
		specialChar = hasSpecialChar(password);
		containsPass = containsPassword(password);
		spaceIn = hasSpace(password);
		
		if(lengthValid && upperCase && specialChar && !containsPass && !spaceIn)
		{
			isValid = true;
		}
		else 
		{
			if(!lengthValid)
				System.out.println("Your password does not meet the length criteria.");
			if(!upperCase)
				System.out.println("Your password must contain at least one uppercase character.");
			if(!specialChar)
				System.out.println("Your password must contain at least one of the viable special characters.");
			if(containsPass)
				System.out.println("Your password must not contain the word password in any case.");
			if(spaceIn)
				System.out.println("Your password must not contain any spaces.");
		}
		
		if(!isValid)
			System.out.println("Your password is invalid please try again." );
		
		return isValid;
	}
	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean isLengthValid(String password)
	{
		if(password.length() >= 8 && password.length() <= 16)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean hasUpperCase(String password)
	{
		// Initialize variables
		char currentChar;
		boolean isUpperCase = false;
		
		// Converts string to char array
		char[] stringAsChars = password.toCharArray();
		
		for(int charAt = 0; charAt < stringAsChars.length; charAt++)
		{
			currentChar = stringAsChars[charAt];
			
			if(Character.isUpperCase(currentChar))
			{
				isUpperCase = true;
				break;
			}
		}
		
		return isUpperCase;
	}
	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean hasSpecialChar(String password)
	{
		// Initialize variables
		Character currentSpecialChar, currentChar;
		boolean isSpecialChar = false;
		
		// Array containing viable special characters
		char[] specialChars = {'!', '@', '#', '$', '%'}; 
		
		// Converts string to char array
		char[] stringAsChars = password.toCharArray();
		
		for(int specialCharAt = 0; specialCharAt < specialChars.length; specialCharAt++)
		{
			for(int charAt = 0; charAt < stringAsChars.length; charAt++)
			{
				currentSpecialChar = new Character(specialChars[specialCharAt]);
				currentChar = new Character(stringAsChars[charAt]);
				
				if(currentSpecialChar.equals(currentChar))
				{
					isSpecialChar = true;
					break;
				}
			}
			
			if(isSpecialChar)
			{
				break;
			}
		}
		
		return isSpecialChar;
	}
	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean containsPassword(String password)
	{
		// Initialize variables
		String asLowerCase;
		boolean doesContain = true;
		
		// Convert string to lowercase to ignore case
		asLowerCase = password.toLowerCase();
		
		// check if string contains the word password
		doesContain = asLowerCase.contains("password");
		
		return doesContain;
	}
	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean hasSpace(String password)
	{
		// Initialize variables
		int indexSpace;
		boolean spaceIn = true;
		
		indexSpace = password.indexOf(" ");
		
		if(indexSpace == -1)
		{
			spaceIn = false;
		}
		
		return spaceIn;
		
	}
	
	public static void getAscii(String password)
	{
		char hashToChar;
		int ascii;
        
        // Create a new int array
        int[] asciiHash = new int[password.length()];
        
        // Converts string to char array
        char[] stringAsChars = password.toCharArray();
        char[] hashAsChars = new char[password.length()];
        
        for(int charAt = 0; charAt < stringAsChars.length; charAt++)
		{
        	ascii = stringAsChars[charAt];
        	
        	asciiHash[charAt] = ascii + 1;
		}
        
        System.out.print("Hash: ");
        
        for (int i = 0; i < asciiHash.length; i++) 
        {
        	hashToChar = (char) asciiHash[i];
        	
        	hashAsChars[i] = hashToChar;
        }
        
        String str = new String(hashAsChars);
        System.out.println(str);
        
	}
		
}
