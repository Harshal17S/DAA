import java.util.PriorityQueue;

class HuffmanNode {
    char c;
    int data;
    HuffmanNode left, right;

    HuffmanNode(char c, int data) {
        this.c = c;
        this.data = data;
        left = right = null;
    }
}

class Compare implements java.util.Comparator<HuffmanNode> {
    public int compare(HuffmanNode l, HuffmanNode r) {
        return l.data - r.data;
    }
}
/**
 * _1huffman
 */
public class _1huffman {

    public static void printCode(HuffmanNode root, String str) {
        if (root == null)
            return;

        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + str);
        }

        printCode(root.left, str + "0");
        printCode(root.right, str + "1");
    }

    public static void main(String[] args) {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};

        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>(n, new Compare());

        for (int i = 0; i < n; ++i) {
            minHeap.add(new HuffmanNode(charArray[i], charFreq[i]));
        }

        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();

            int sum = left.data + right.data;
            HuffmanNode newNode = new HuffmanNode('-', sum);
            newNode.left = left;
            newNode.right = right;

            minHeap.add(newNode);
        }

        HuffmanNode root = minHeap.peek();

        System.out.println("Huffman Codes are : ");
        printCode(root, "");
    }
}