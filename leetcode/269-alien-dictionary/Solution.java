class Solution {
    public String alienOrder(String[] words) {
        Set<Character> chars = new HashSet<Character>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                chars.add(words[i].charAt(j));
            }
        }
        Map<Character, Set<Character>> dep = new HashMap<Character, Set<Character>>();
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words[i].length() && j < words[i - 1].length(); j++) {
                if (words[i].charAt(j) != words[i - 1].charAt(j)) {
                    if (dep.containsKey(words[i - 1].charAt(j)) && dep.get(words[i - 1].charAt(j)).contains(words[i].charAt(j))) {
                        return "";
                    }
                    if (!dep.containsKey(words[i].charAt(j))) {
                        dep.put(words[i].charAt(j), new HashSet<Character>());
                    }
                    dep.get(words[i].charAt(j)).add(words[i - 1].charAt(j));
                    break;
                }
                if (j == words[i].length() - 1 && j < words[i - 1].length() - 1) {
                    return "";
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!chars.isEmpty()) {
            char charToRemove = '0';
            for (Character c : chars) {
                boolean hasDep = false;
                if (dep.containsKey(c)) {
                    for (Character depC : dep.get(c)) {
                        if (chars.contains(depC)) {
                            hasDep = true;
                            break;
                        }
                    }
                }
                if (!hasDep) {
                    charToRemove = c;
                    break;
                }
            }
            if (charToRemove == '0') {
                return "";
            }
            sb.append(charToRemove);
            chars.remove(charToRemove);
        }
        return sb.toString();
    }
}