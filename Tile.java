/**
 * Tile.java
 * 
 * This Tile class represents a Scrabble tile containing a single letter and its associated point value.
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
 * <p>
 * Each Tile object stores a character (the letter) and an integer (the value).
 * It provides methods to get and set these values, print a tile in a readable format,
 * compare two tiles for equality, and display tile information as a string.
 * <p>
 * The main method demonstrates creating Tile objects for the letters in name "Huilin",
 * calculates the total Scrabble score for the name, and compares tiles.
 * <p>
 * 
 * To compile: javac Tile.java
 * To run: java Tile
 * 
 * Example output:
 * <pre> 
 * Tiles for Huilin:
 * Tile (letter = H, value = 4)
 * Tile (letter = U, value = 1)
 * Tile (letter = I, value = 1)
 * Tile (letter = L, value = 1)
 * Tile (letter = I, value = 1)
 * Tile (letter = N, value = 1)
 * 
 * Total Scrabble value for Huilin = 9
 * 
 * Compare tiles:
 * Tile 1 (H, 4) equals tile 2 (U, 1): false
 * Tile 3 (I, 1) equals tile 5 (I, 1): true
 * </pre>
 * 
 * @author Huilin Reid
 * @since 11-02-2025
 */

public class Tile {  
    // Instance variables
    private char letter;
    private int value;

    /**
     * Contructor to initialize a new Tile object with the given letter and 
     * its Scrablle value.
     * The letter is automatically converted to uppercase.
     *
     * @param letter The letter on the tile.
     * @param value  The point (Scrabbble score) value of the tile (letter).
     */
    public Tile(char letter, int value) {
        this.letter = Character.toUpperCase(letter); 
        this.value = value;
    }

    /**
     * Getter for letter
     * Returns the letter of this tile.
     *
     * @return The letter.
     */
    public char getLetter() {
        return letter;
    }

    /**
     * Getter for value
     * Returns the value (score) of this tile.
     *
     * @return The tile's value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter for letter
     * Sets the letter for this tile (converted to uppercase).
     *
     * @param letter The new letter.
     */
    public void setLetter(char letter) {
        this.letter = Character.toUpperCase(letter);
    }

    /**
     * Setter for value
     * Sets the value (score) for this tile.
     *
     * @param value The new value.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Prints the information of a Tile object in a reader-friendly format.
     *
     * @param tile The Tile object to print.
     */
    public static void printTile(Tile tile) {
        System.out.println(tile);
    }

    /**
     * Returns a string representation of the Tile
     * in the format: Tile (letter = H, value = 4)
     *
     * @return A string describing this tile.
     */
    @Override 
    public String toString() {
        return "Tile (letter = " + letter + ", value = " + value + ")"; 
    }

    /**
     * Compares this Tile to another tile for equality.
     * Two Tiles are equal if they have the same letter and value.
     *
     * @param that The tile to compare with.
     * @return true if both Tiles are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // same object
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // if null, or different class (not a Tile)
        }
        Tile that = (Tile) obj;
        return (this.letter == that.letter) && (this.value == that.value);
    }

    /**
     * The main method creates Tile objects for each letter of Huilin,
     * prints them, and calculates the total Scrabble score.
     */
    public static void main(String[] args) {       
        // Example using name "Huilin" => Scrabble values: H=4, I=1, L=1, N=1, U=1
        Tile t1 = new Tile('H', 4);
        Tile t2 = new Tile('u', 1);
        Tile t3 = new Tile('i', 1);
        Tile t4 = new Tile('l', 1);
        Tile t5 = new Tile('i', 1);
        Tile t6 = new Tile('n', 1);

        System.out.println("\nTiles for Huilin:");
        printTile(t1);
        printTile(t2);
        printTile(t3);
        printTile(t4);
        printTile(t5);
        printTile(t6);

        int totalValue = t1.getValue() + t2.getValue() + t3.getValue() + t4.getValue() + t5.getValue() + t6.getValue();
        System.out.println("\nTotal Scrabble value for Huilin = " + totalValue);

        System.out.println("\nCompare tiles:");
        System.out.println("Tile 1 (H, 4) equals tile 2 (U, 1): " + t1.equals(t2));
        System.out.println("Tile 3 (I, 1) equals tile 5 (I, 1): " + t3.equals(t5) + "\n");
    }  
}


