import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HuffmanTester {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String inputText = bufferedReader.readLine();
        Huffman huffman = new Huffman(inputText);

        FileWriter fileWriter = new FileWriter("encoded.txt");

        String encodedText = huffman.encode();
        System.out.println("Encoded Text : " + encodedText + "\n");
        fileWriter.write("Encoded Text : " + encodedText + "\n");

        String decodedText = huffman.decode(encodedText);
        System.out.println("Decoded Text : " + decodedText + "\n");
        fileWriter.write("Decoded Text : " + decodedText + "\n");

        fileWriter.close();


    }

}
