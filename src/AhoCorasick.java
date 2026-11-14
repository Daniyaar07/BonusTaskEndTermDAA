import java.util.*;
public class AhoCorasick {
    static class Node {
        Map<Character , Node> next = new HashMap<>();
        Node fail;
        int count;
    }
    Node root = new Node();
    AhoCorasick(List<String> patterns){
        for(String word : patterns){
            Node node = root;
            for (char c : word.toCharArray()){
                node.next.putIfAbsent(c , new Node());
                node = node.next.get(c);
            }
            node.count++;
        }
        Queue<Node> q = new LinkedList<>();
        root.fail = root;

        for(Node child : root.next.values()){
            child.fail = root;
            q.add(child);
        }
        while(!q.isEmpty()){
            Node node = q.poll();
            for(char c : node.next.keySet()){
                Node child = node.next.get(c);
                Node f = node.fail;

                while(f!= root && !f.next.containsKey(c)){
                    f = f.fail;
                }
                child.fail = f.next.getOrDefault(c , root);
                child.count += child.fail.count;
                q.add(child);
            }
        }
    }
    int search(String text){
        Node node = root;
        int result =0;
        for (char c : text.toCharArray()){
            while(node != root && !node.next.containsKey(c)){
                node = node.fail;
            }
            node = node.next.getOrDefault(c , root);
            result += node.count;
        }
        return result;
    }
}
