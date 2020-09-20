public class Codec {
    final String base = "http://tinyurl.com/";
    final String chars = "1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
    Map<String, String> l2s;
    Map<String, String> s2l;
    Random r;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (l2s == null) {
            l2s = new HashMap<String, String>();
            s2l = new HashMap<String, String>();
            r = new Random();
        }
        if (l2s.containsKey(longUrl)) {
            return base + l2s.get(longUrl);
        }
        String hash = genHash();
        while (s2l.containsKey(hash)) {
            hash = genHash();
        }
        s2l.put(hash, longUrl);
        l2s.put(longUrl, hash);
        return base + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String offset = shortUrl.substring(19);
        if (s2l.containsKey(offset)) {
            return s2l.get(offset);
        }
        return "";
    }
    private String genHash() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(r.nextInt(chars.length())));
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));