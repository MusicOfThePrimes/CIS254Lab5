/**
 * 
 * Scrabble.java
 * 
 * <p>The Scrabble class simulates a simplified version of the
 * Scrabble game. A player receives a random set of seven tiles and attempts
 * to form words using those tiles. The game validates each entered word,
 * calculates the Scrabble score, and replaces any used tiles so that the
 * player always maintains a full set of seven tiles.</p>
 *
 * <p>This program demonstrates the use of java.util.ArrayList,
 * random number generation, user input handling, and object manipulation
 * through the Tile class from Homework 13.</p>
 *
 * <p>In the first round of the game, the program randomly generates an
 * ArrayList containing seven Tile objects. The player is
 * shown their current set of tiles and prompted to create a word using
 * those tiles. If the word can be formed, the program calculates and displays
 * the total Scrabble score based on the tile values, removes the used tiles,
 * and replaces them with new random ones.</p>
 *
 * <p>This process repeats, allowing the player to continue forming words
 * until they choose to quit the game.</p>
 *
 * <p><b>Reference:</b> The Scrabble letter distribution and point values were
 * adapted from the English-language edition of Scrabble as described on
 * <a href="https://en.wikipedia.org/wiki/Scrabble_letter_distributions">
 * Wikipedia: Scrabble letter distributions</a>.</p>
 * 
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
 * <p><b>Note:</b> In official Scrabble rules, all tiles are uppercase letters.</p>
 *
 * 
 * @author Huilin Reid
 * @since 11-09-2025
 * 
 */

 import java.util.ArrayList;
 import java.util.Random;
 import java.util.Scanner;

public class Scrabble {

    /**
     * Builds the full pool of 100 Scrabble tiles according to the
     * official English-language Scrabble letter distribution.
     *
     * @return an ArrayList containing all 100 Tile objects.
     */
    private static ArrayList<Tile> buildTilePool() {
        ArrayList<Tile> pool = new ArrayList<>();

        // 1-point letters
        addTiles(pool, 'E', 12, 1);
        addTiles(pool, 'A', 9, 1);
        addTiles(pool, 'I', 9, 1);
        addTiles(pool, 'O', 8, 1);
        addTiles(pool, 'N', 6, 1);
        addTiles(pool, 'R', 6, 1);
        addTiles(pool, 'T', 6, 1);
        addTiles(pool, 'L', 4, 1);
        addTiles(pool, 'S', 4, 1);
        addTiles(pool, 'U', 4, 1);

        // 2-point letters
        addTiles(pool, 'D', 4, 2);
        addTiles(pool, 'G', 3, 2);

        // 3-point letters
        addTiles(pool, 'B', 2, 3);
        addTiles(pool, 'C', 2, 3);
        addTiles(pool, 'M', 2, 3);
        addTiles(pool, 'P', 2, 3);

        // 4-point letters
        addTiles(pool, 'F', 2, 4);
        addTiles(pool, 'H', 2, 4);
        addTiles(pool, 'V', 2, 4);
        addTiles(pool, 'W', 2, 4);
        addTiles(pool, 'Y', 2, 4);

        // 5-point letter
        addTiles(pool, 'K', 1, 5);

        // 8-point letters
        addTiles(pool, 'J', 1, 8);
        addTiles(pool, 'X', 1, 8);

        // 10-point letters
        addTiles(pool, 'Q', 1, 10);
        addTiles(pool, 'Z', 1, 10);

        // 0-point blanks
        addTiles(pool, ' ', 2, 0);

        return pool;
    }

    /**
     * Helper method to add multiple copies of the same letter to the pool.
     *
     * @param pool   the ArrayList of Tile objects to add to.
     * @param letter the letter to add.
     * @param count  how many copies of the letter to add.
     * @param value  the point value for that letter.
     */
    private static void addTiles(ArrayList<Tile> pool, char letter, int count, int value) {
        for (int i = 0; i < count; i++) {
            pool.add(new Tile(letter, value));
        }
    }

    /**
     * Generates a tile set for a player.
     * Draws a set of randomly selected tiles from the main Scrabble tile pool.
     * This simulates a player's draw in an actual Scrabble game.
     * Each drawn tile is removed from the pool to ensure that no tile
     * can be reused, maintaining the correct letter distribution.
     *
     * @param pool   the current pool of available Scrabble tiles.
     * @param number the number of tiles to draw (typically 7).
     * @return an ArrayList containing 7 randomly drawn Tile objects from the tile pool.
     */
    private static ArrayList<Tile> generateTileSet(ArrayList<Tile> pool) {
        ArrayList<Tile> hand = new ArrayList<>();
        Random rand = new Random();

        // Get 7 random tiles from the tile pool
        for (int i = 0; (i < 7) && (!pool.isEmpty()); i++) {
            int index = rand.nextInt(pool.size());
            hand.add(pool.remove(index)); // remove so it can't be drawn again
        }
        return hand;
    }

    /**
     * Checks if a given word can be formed using the player's current tiles.
     * Each tile can only be used once.
     *
     * @param word  the word entered by the user.
     * @param tiles the current set of tiles the player has.
     * @return true if the word can be formed from the tiles; false otherwise.
     */
    private static boolean canMakeWord(String word, ArrayList<Tile> tiles) {
        ArrayList<Character> temp = new ArrayList<>();
        for (Tile t : tiles) {
            temp.add(t.getLetter());
        }

        for (char c : word.toUpperCase().toCharArray()) {
            if (temp.contains(c)) {
                temp.remove((Character) c);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Displays the player's current set of tiles in the console.
     *
     * @param tiles the ArrayList of Tile objects representing the player's tiles.
     */
    public static void displayTiles(ArrayList<Tile> tiles) {
        System.out.print("Here is your tile set: ");
        for (Tile t : tiles) {
            System.out.print(t.getLetter() + " ");
        }
        System.out.println();
    }

    /**
     * Calculates the total Scrabble score of a given word.
     * Each letter's score is determined by the value assigned 
     * to that letter in the Scrabble tile pool. 
     *
     * @param word the word entered by the player.
     * @return the total Scrabble score of the word.
     */
    private static int getWordValue(String word) {
        int score = 0;
        for (char c : word.toUpperCase().toCharArray()) {
            switch (c) {
                case 'A': case 'E': case 'I': case 'O': case 'N': 
                case 'R': case 'T': case 'L': case 'S': case 'U':
                    score += 1; break;
                case 'D': case 'G':
                    score += 2; break;
                case 'B': case 'C': case 'M': case 'P':
                    score += 3; break;
                case 'F': case 'H': case 'V': case 'W': case 'Y':
                    score += 4; break;
                case 'K':
                    score += 5; break;
                case 'J': case 'X':
                    score += 8; break;
                case 'Q': case 'Z':
                    score += 10; break;
                default:
                    score += 0; // for blanks or invalid chars
            }
        }
        return score;
    }

    /**
     * Updates the player's tile set after they play a valid word.
     * Removes the used tiles from the player's hand and replaces them with 
     * new random tiles drawn from the remaining tile pool to restore a full 
     * set of 7 tiles.
     *
     * @param word  the valid word formed by the player.
     * @param tiles the player's current tile set.
     * @param pool the remaining Scrabble tile pool (shared across the game).
     */
    private static void updateTiles(String word, ArrayList<Tile> tiles, ArrayList<Tile> pool) {
        // Remove used tiles from player's hand
        for (char c : word.toUpperCase().toCharArray()) {
            for (int i = 0; i < tiles.size(); i++) {
                if (tiles.get(i).getLetter() == c) {
                    tiles.remove(i);
                    break;
                }
            }
        }
        // Draw new tiles from the remaining pool to refill the hand
        Random rand = new Random();
        while (tiles.size() < 7 && !pool.isEmpty()) {
            int index = rand.nextInt(pool.size());
            tiles.add(pool.remove(index));
        }
    }

    /**
     * The main method executes the Scrabble game.
     * It initializes the player's tile set, prompts the user to create words,
     * validates input, computes scores, updates tiles, and continues
     * until the player chooses to quit.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tile> tilePool = buildTilePool();
        ArrayList<Tile> playerTiles = generateTileSet(tilePool); 
        String continuePlay;

        System.out.println("\nWelcome to Scrabble Game!\n");

        do {
            displayTiles(playerTiles);
            
            System.out.print("Enter a word: ");
            String word = scanner.nextLine().trim();

            if (canMakeWord(word, playerTiles)) {
                System.out.println("Yes, can spell " + word);
                int score = getWordValue(word);
                System.out.println("Word score = " + score);
                updateTiles(word, playerTiles, tilePool);
            } else {
                System.out.println("No, cannot spell " + word);
            }

            System.out.print("Do you want to continue? (Y/N): ");
            continuePlay = scanner.nextLine().trim();
            System.out.println();
        } while (continuePlay.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing! \nGood bye!");
        scanner.close();
    }
}

/**
 
    MIT 10,000 word list:
        https://www.mit.edu/~ecprice/wordlist.10000 

    Angel Fire word list from different languages:
        English
        Latin
        Japanese
        Sanskrit
        Proto-Germanic
        Navajo
        Pamir languages

        https://www.angelfire.com/extreme4/safer_sephiroth/EVERY_WORD_EVER.htm 

    To check a word in dictionary:
        https://en-word.net/lemma/PC
        https://scrabblewordfinder.org/solver
        https://scrabblecheck.com/pc

*/

