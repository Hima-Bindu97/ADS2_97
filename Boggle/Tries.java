public class Tries {
    private static final int R = 26;        
    private Node root = new Node();
    private static class Node {
        private Object end;
        private Node[] next = new Node[R];
    }
    public boolean contains(String key) {
        Node x = get(key);
        if(x== null) return false;
        return (boolean)x.end == true;
    }
    public boolean isPrefix(String key) {
        return get(key) != null;
    }
    public Node get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return  x;
    }
    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c-'A'], key, d+1);
    }
    public void put(String key) {
        root = put(root, key, 0);
    }
    private Node put(Node x, String key, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.end = true;
            return x;
        }
        char c = key.charAt(d);
        if(x.end == null) x.end = false;
        x.next[c-'A'] = put(x.next[c-'A'], key, d+1);
        return x;
    }
    public void delete(String key) {
        root = delete(root, key, 0);
    }
    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) x.end = null;
        else {
            char c = key.charAt(d);
            x.next[c-'A'] = delete(x.next[c-'A'], key, d+1);
        }
        if (x.end != null) return x;
        for (int c = 0; c < R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }
}