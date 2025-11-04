/**
 * 
 * 
 * Referenced the Following Scrabble Tile Distribution Information
 * Source: https://en.wikipedia.org/wiki/Scrabble_letter_distributions
 * "English (original)
 *  English-language editions of Scrabble contain 100 letter tiles, in the following distribution:
 *  2 blank tiles (scoring 0 points)
 *  1 point: E ×12, A ×9, I ×9, O ×8, N ×6, R ×6, T ×6, L ×4, S ×4, U ×4
 *  2 points: D ×4, G ×3
 *  3 points: B ×2, C ×2, M ×2, P ×2
 *  4 points: F ×2, H ×2, V ×2, W ×2, Y ×2
 *  5 points: K ×1
 *  8 points: J ×1, X ×1
 *  10 points: Q ×1, Z ×1
 *  The total number of points is 187. Diacritical marks (such as "ñ" in words borrowed from Spanish) 
 *  are ignored."
 * 
 * NOTE: in official Scrabble, tiles are always uppercase letters.
 * 
 * 
 */

public class Scrabble {
    // List of all possible tiles with Scrabble values
    private static final char[] LETTERS = {
        'A','B','C','D','E','F','G','H','I','J','K','L','M',
        'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    };
    private static final int[] VALUES = {
        1,3,3,2,1,4,2,4,1,8,5,1,3,
        1,1,3,10,1,1,1,1,4,4,8,4,10
    };

    


}
