class Solution {

    static class Node {
        Node[] arr = new Node[26];
        boolean[] flag = new boolean[26];
    }

    static String[] ans;

    static String[] findPrefixes(String[] arr, int N) {
        ans = new String[N];
        Node node = new Node();

        for (int i = 0; i < N; i++) {
            putNode(arr[i], node);
        }

        // print(node);

        for (int i = 0; i < N; i++) {
            String s = arr[i];
            fun(node.arr[s.charAt(0) - 'a'], s, 1, i);
        }

        return ans;
    }

    static void fun(Node node, String s, int si, int index) {
        Node temp = node;
        int count = 0;
        int ind = 0;

        for (int i = 0; i < 26; i++) {
            if (temp.arr[i] != null) {
                ind = i;
                count++;
            }
            if (count > 1)
                break;
        }

        if (count == 1 && !temp.flag[ind]) {
            ans[index] = s.substring(0, si);
            return;
        } else {
            if (si < s.length()) {
                fun(node.arr[s.charAt(si) - 'a'], s, si + 1, index);
            } else
                ans[index] = s;
        }
    }

    static void print(Node node) {
        for (int i = 0; i < 26; i++) {
            if (node.arr[i] != null)
                System.out.println(node.arr[i]);
        }
    }

    static void putNode(String s, Node node) {
        Node temp = node;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);

            if (temp.arr[c - 'a'] == null) {
                temp.arr[c - 'a'] = new Node();
                temp = temp.arr[c - 'a'];
            } else {
                temp.flag[c - 'a'] = true;
                temp = temp.arr[c - 'a'];
            }

        }
    }
};
