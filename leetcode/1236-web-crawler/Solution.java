/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> res = new ArrayList<String>();
        Queue<String> q = new LinkedList<String>();
        Set<String> vis = new HashSet<String>();
        q.offer(startUrl);
        vis.add(startUrl);
        while (!q.isEmpty()) {
            String temp = q.poll();
            String tempHost = getHost(temp);
            res.add(temp);
            List<String> nextUrls = htmlParser.getUrls(temp);
            for (String nextUrl : nextUrls) {
                if (!vis.contains(nextUrl) && getHost(nextUrl).equals(tempHost)) {
                    vis.add(nextUrl);
                    q.offer(nextUrl);
                }
            }
        }
        return res;
    }
    private String getHost(String s) {
        int index = 7;
        while (index < s.length() && s.charAt(index) != '/') {
            index++;
        }
        return s.substring(7, index);
    }
}