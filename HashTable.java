//using separate chaining to prevent collision detection
//TODO make the hash function 

public class HashTable implements iHashTable{
    private Chain[] table;
    private static final int DICTIONARY_CAPACITY = 100; //TODO idk about this

    private class Chain{ //using singly LL as there's no need to loop around anywhere
        private Node top;

        private class Node{
            String word;
            Node next;

            Node(String word, Node next){
                this.word = word;
                this.next = next;
            }

            Node(String word){
                this(word, null);
            }
        }
    }

    public HashTable(){
        table = new Chain[DICTIONARY_CAPACITY];
    }
    //everytime wanna store smth, dont forget to initialize/declare the Linkedlist of each cell in table

    @Override
    public boolean search(String word) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public String[] retrieve(String word) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retrieve'");
    }

    @Override
    public String[] synonyms(String word) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'synonyms'");
    }
    
}