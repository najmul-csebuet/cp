package mylib.SuffixTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SuffixTree {

    private static final String LAST_CHAR_OF_WORD = "$";
    private static final int INVALID_POS = -1;
    private Node root;
    private String completeData;

    public SuffixTree(String text) {
        root = new Node("", INVALID_POS);
        for (int i = 0; i < text.length(); i++) {
            addSuffix(text.substring(i) + LAST_CHAR_OF_WORD, i);
        }
        completeData = text;
    }

    public List<String> searchText(String pattern) {

        List<String> result = new ArrayList<>();
        List<Node> nodes = getAllNodesInTraversePath(pattern, root, false);

        if (nodes.size() > 0) {
            Node lastNode = nodes.get(nodes.size() - 1);
            if (lastNode != null) {
                List<Integer> positions = getPositions(lastNode);
                positions = positions.stream()
                        .sorted()
                        .collect(Collectors.toList());
                positions.forEach(m -> result.add((markPatternInText(m, pattern))));
            }
        }
        return result;
    }

    private void addSuffix(String suffix, int position) {
        List<Node> nodes = getAllNodesInTraversePath(suffix, root, true);
        if (nodes.size() == 0) {
            addChildNode(root, suffix, position);
        } else {
            Node lastNode = nodes.remove(nodes.size() - 1);
            String newText = suffix;
            if (nodes.size() > 0) {
                String existingSuffixUptoLastNode = nodes.stream()
                        .map(a -> a.getData())
                        .reduce("", String::concat);

                // Remove prefix from newText already included in parent
                newText = newText.substring(existingSuffixUptoLastNode.length());
            }
            extendNode(lastNode, newText, position);
        }
    }

    private List<Integer> getPositions(Node node) {
        List<Integer> positions = new ArrayList<>();
        if (node.getData()
                .endsWith(LAST_CHAR_OF_WORD)) {
            positions.add(node.getPos());
        }
        for (int i = 0; i < node.getBranches()
                .size(); i++) {
            positions.addAll(getPositions(node.getBranches()
                    .get(i)));
        }
        return positions;
    }

    private String markPatternInText(Integer startPosition, String pattern) {
        String matchingTextLHS = completeData.substring(0, startPosition);
        String matchingText = completeData.substring(startPosition, startPosition + pattern.length());
        String matchingTextRHS = completeData.substring(startPosition + pattern.length());
        return matchingTextLHS + "[" + matchingText + "]" + matchingTextRHS;
    }

    private void addChildNode(Node parentNode, String text, int position) {
        parentNode.getBranches()
                .add(new Node(text, position));
    }

    private void extendNode(Node node, String newText, int position) {
        String currentText = node.getData();
        String commonPrefix = getLongestCommonPrefix(currentText, newText);

        if (commonPrefix != currentText) {
            String parentText = currentText.substring(0, commonPrefix.length());
            String childText = currentText.substring(commonPrefix.length());
            splitNodeToParentAndChild(node, parentText, childText);
        }

        String remainingText = newText.substring(commonPrefix.length());
        addChildNode(node, remainingText, position);
    }

    private void splitNodeToParentAndChild(Node parentNode, String parentNewText, String childNewText) {
        Node childNode = new Node(childNewText, parentNode.getPos());

        if (parentNode.getBranches().size() > 0) {
            while (parentNode.getBranches().size() > 0) {
                childNode.getBranches().add(parentNode.getBranches().remove(0));
            }
        }

        parentNode.getBranches().add(childNode);
        parentNode.setData(parentNewText);
        parentNode.setPos(INVALID_POS);
    }

    private String getLongestCommonPrefix(String str1, String str2) {
        int compareLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < compareLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, compareLength);
    }

    private List<Node> getAllNodesInTraversePath(String pattern, Node startNode, boolean isAllowPartialMatch) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < startNode.getBranches()
                .size(); i++) {
            Node currentNode = startNode.getBranches()
                    .get(i);
            String nodeText = currentNode.getData();
            if (pattern.charAt(0) == nodeText.charAt(0)) {
                if (isAllowPartialMatch && pattern.length() <= nodeText.length()) {
                    nodes.add(currentNode);
                    return nodes;
                }

                int compareLength = Math.min(nodeText.length(), pattern.length());
                for (int j = 1; j < compareLength; j++) {
                    if (pattern.charAt(j) != nodeText.charAt(j)) {
                        if (isAllowPartialMatch) {
                            nodes.add(currentNode);
                        }
                        return nodes;
                    }
                }

                nodes.add(currentNode);
                if (pattern.length() > compareLength) {
                    List<Node> nodes2 = getAllNodesInTraversePath(pattern.substring(compareLength), currentNode, isAllowPartialMatch);
                    if (nodes2.size() > 0) {
                        nodes.addAll(nodes2);
                    } else if (!isAllowPartialMatch) {
                        nodes.add(null);
                    }
                }
                return nodes;
            }
        }
        return nodes;
    }

    public void printTree() {
        root.printTree("");
    }

    public static void main(String[] args) {
        SuffixTree suffixTree = new SuffixTree("abcdefabc");
        suffixTree.printTree();
        List<String> matches = suffixTree.searchText("abc");
        boolean equals = Arrays.equals(new String[]{"[abc]defabc", "abcdef[abc]"}, matches.toArray());
        if (equals) {
            System.out.println("All matches found.");
        }
    }

    static class Node {
        private String data;
        private List<Node> branches;
        private int pos;

        public Node(String word, int pos) {
            this.data = word;
            this.pos = pos;
            this.branches = new ArrayList<>();
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public List<Node> getBranches() {
            return branches;
        }

        public void setBranches(List<Node> branches) {
            this.branches = branches;
        }

        public String printTree(String depthIndicator) {
            StringBuilder str = new StringBuilder();
            String positionStr = pos > -1 ? "[" + pos + "]" : "";
            str.append(depthIndicator).append(data).append(positionStr).append("\n");

            for (Node branch : branches) {
                str.append(branch
                        .printTree(depthIndicator + "\t"));
            }
            return str.toString();
        }

        @Override
        public String toString() {
            return printTree("");
        }
    }
}