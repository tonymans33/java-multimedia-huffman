class Leaf extends Node {
    private char character;

    Leaf(char character, int freq){
        super(freq);
        this.character = character;
    }

    char getCharacter() {
        return character;
    }
}
