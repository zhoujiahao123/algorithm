package algorithm.top100medium.PrefixTree;

public class TrieNode {
    //26¸ö×ÖÄ¸
    public TrieNode[] links = new TrieNode[26];
    public boolean isEnd = false;

    public TrieNode() {

    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean getEnd() {
        return isEnd;
    }
}
