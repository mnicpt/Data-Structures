import static org.junit.Assert.assertEquals;
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
	@Test
	public void shouldDetermineLikenessOfStrings() {
		//permutation
		String str1 = "micro";
		String str2 = "croim";
		assertTrue(StringUtils.permutation(str1, str2));
		
		//permutation
		str1 = "moon";
		str2 = "nomo";
		assertTrue(StringUtils.permutation(str1, str2));
		
		//not permutation different lengths
		str1 = "micr";
		str2 = "croim";
		assertFalse(StringUtils.permutation(str1, str2));
		
		//not permutation same lengths
		str1 = "micrb";
		str2 = "croim";
		assertFalse(StringUtils.permutation(str1, str2));
		
		//not permutation same lengths
		str1 = "aba";
		str2 = "bab";
		assertFalse(StringUtils.permutation(str1, str2));
	}

	/**
	 * Replace all spaces with %20
	 */
	@Test
	public void shouldReplaceAllSpacesWithPercent20() {
		String str1 = "Hi, this is Steve.";
		assertEquals("Hi,%20this%20is%20Steve.", StringUtils.encodeString(str1, ' ', "%20"));
	}
	
	/**
	 * Compress string characters. aabbbcdde => a2b3cd2e
	 */
	@Test
	public void shouldCompressStringCharacters() {
		String val = "aadddfllllc";
		assertEquals("a2d3fl4c", StringUtils.compress(val));
	}
	
	@Test
	public void shouldReturnOriginalValueIfNotCompressing() {
		String val = "abcd";
		assertEquals("abcd", StringUtils.compress(val));
	}
}
