class Solution {

    Map<String, List<String>> wordMap = new HashMap<>();
    int L ;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord) || !wordList.contains(endWord)) {
            return 0;
        }

        L = beginWord.length();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations =
                                this.wordMap.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        this.wordMap.put(newWord, transformations);
                    }
                });

        Queue<Pair<String, Integer>> firstQ = new LinkedList<>();
        Queue<Pair<String, Integer>> endQ = new LinkedList<>();
        firstQ.add(new Pair<>(beginWord, 1));
        endQ.add(new Pair<>(endWord, 1));
        Map<String, Integer> visitedFirstMap = new HashMap<>();
        Map<String, Integer> visitedEndMap = new HashMap<>();
        visitedFirstMap.put(beginWord, 1);
        visitedEndMap.put(endWord, 1);

        while (!firstQ.isEmpty() && !endQ.isEmpty()) {
            int ans = visitWordNode(firstQ, visitedFirstMap, visitedEndMap);
            if (ans > -1) {
                return ans;
            }
            int ans1 = visitWordNode(endQ, visitedEndMap, visitedFirstMap);
            if (ans1 > -1) {
                return ans1;
            }
        }
        return 0;
    }

    private int visitWordNode(Queue<Pair<String, Integer>> q, Map<String, Integer> visitedFirstMap, Map<String, Integer> visitedEndMap) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            Pair<String, Integer> wordPair = q.remove();
            String word = wordPair.getKey();
            int level = wordPair.getValue();
            for (int k = 0; k < L; k++) {
                String key = word.substring(0, k) + "*" + word.substring(k + 1, L);
                for (String w : wordMap.getOrDefault(key, new ArrayList<>())) {
                    if (visitedEndMap.containsKey(w)) {
                        return level + visitedEndMap.get(w);
                    }
                    if (!visitedFirstMap.containsKey(w)) {
                        visitedFirstMap.put(w, level + 1);
                        q.add(new Pair<>(w, level + 1));
                    }
                }
            }
        }
        return -1;
    }
}