class Tweet {
    int uid;
    int tid;
    public Tweet(int uid, int tid) {
        this.uid = uid;
        this.tid = tid;
    }
}
class Twitter {
    Map<Integer, Set<Integer>> map;
    List<Tweet> tList;
    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<Integer, Set<Integer>>();
        tList = new ArrayList<Tweet>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new HashSet<Integer>());
        }
        tList.add(new Tweet(userId, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        if (!map.containsKey(userId)) {
            return res;
        }
        int index = tList.size() - 1;
        while (index >= 0 && res.size() < 10) {
            if (userId == tList.get(index).uid || map.get(userId).contains(tList.get(index).uid)) {
                res.add(tList.get(index).tid);
            }
            index--;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new HashSet<Integer>());
        }
        map.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (map.containsKey(followerId) && map.get(followerId).contains(followeeId)) {
            map.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */