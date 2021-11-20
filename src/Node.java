public class Node implements Comparable<Node> {
    private int freq;
    private Node left;
    private Node right;

    Node(Node left, Node right){
        this.freq = left.getFreq() + right.getFreq();
        this.left = left;
        this.right = right;
    }

    Node(int freq){
        this.freq = freq;
    }

    private int getFreq() {
        return freq;
    }

    Node getLeft() {
        return left;
    }

    Node getRight() {
        return right;
    }

    @Override
    public int compareTo(Node node){
        return Integer.compare(freq, node.getFreq());
    }
}
