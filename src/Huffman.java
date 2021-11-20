import java.util.*;

class Huffman {

    private Node root;
    private String inputText;
    private Map<Character, Integer> charFreq;
    private Map<Character, String> huffmanCodes;

    Huffman(String inputText){
        this.inputText = inputText;
        createFreqMap();
    }

    private void createFreqMap(){
        charFreq = new HashMap<>();
        for(char character : inputText.toCharArray()){
            Integer freq = charFreq.get(character);
            charFreq.put(character, freq != null ? freq + 1 : 1);
            // charFreq = {c=2, d=4, b=7, a=8}
        }
    }

    String encode(){
        Queue<Node> queue = new PriorityQueue<>();
        charFreq.forEach(((character, freq) -> queue.add(new Leaf(character, freq))));

        while (queue.size() > 1){
            queue.add(new Node(queue.poll(), queue.poll()));
        }

        //   HuffmanTree
        //      (21)
        //      /   \
        //    (8)  (13)
        //         /  \
        //       (6)  (7)
        //       /  \
        //     (2)  (4)

        huffmanCodes = new HashMap<>();
        generateHuffmanCodes(root = queue.poll(), "");
        // huffmanCodes = {a=0, b=11, c=101, d=100}

        StringBuilder encodedText = new StringBuilder();
        for(char character : inputText.toCharArray()){
            encodedText.append(huffmanCodes.get(character));
        }

        return encodedText.toString();
    }

    String decode(String encoded){
        StringBuilder decodedText = new StringBuilder();
        Node cur = root;

        for(char character : encoded.toCharArray()){
            cur = character == '0' ? cur.getLeft() : cur.getRight();
            if(cur instanceof Leaf){
                decodedText.append(((Leaf) cur).getCharacter());
                cur = root;
            }
        }
        return decodedText.toString();
    }

    private void generateHuffmanCodes(Node node, String code){
        if(node instanceof Leaf){
            huffmanCodes.put(((Leaf) node).getCharacter(), code);
            return;
        }
        generateHuffmanCodes(node.getLeft(), code.concat("0"));
        generateHuffmanCodes(node.getRight(), code.concat("1"));
    }

}
