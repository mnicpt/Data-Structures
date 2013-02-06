import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class StringUtilsTest {

	/**
	 * Algorithm to determine if string has all unique characters.
	 * Cannot use additional data structures.
	 */
	@Test
	public void shouldDetermineUniqueCharactersInString() {
		//unique
		assertTrue(StringUtils.uniqueChars("abcd"));
		
		//not unique
		assertFalse(StringUtils.uniqueChars("abcda"));
	}

	/**
	 * Reverses a null terminated string.
	 */
	@Test
	public void shouldReverseNullTermineatedString() {
		char[] characters = {'J', 'a', 'v','a', '\0'};
		String str = String.valueOf(characters);
		assertEquals("avaJ", StringUtils.reverse(str));
	}
	
	/**
	 * Determine if one string is a permutation of the other.
	 */
	public void shouldDetermineLikenessOfStrings() {
		//permutation
		String str1 = "micro";
		String str2 = "croim";
		assertTrue(StringUtils.permutation(str1, str2));
		
		//permutation
		str1 = "moon";
		str2 = "nomo";
		assertTrue(StringUtils.permutation(str1, str2));
		
		//not permutation
		str1 = "micr";
		str2 = "croim";
		assertFalse(StringUtils.permutation(str1, str2));
	}

}
