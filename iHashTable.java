public interface iHashTable {
    boolean search(String word); //returns true if the word searched is found
    String[] retrieve(String word); //returns a series of words that is similar to the given word
    String[] synonyms(String word); //searches a series of synonyms of a given word
}