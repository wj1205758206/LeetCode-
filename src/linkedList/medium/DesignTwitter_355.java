package linkedList.medium;

import java.util.*;

/**
 * 设计Twitter，合并 K 个有序链表
 */
public class DesignTwitter_355 {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,1);
        twitter.postTweet(2,2);
        twitter.postTweet(1,3);
        twitter.postTweet(3,4);
        twitter.postTweet(1,5);
        twitter.follow(1,3);
        List<Integer> twitterNewsFeed = twitter.getNewsFeed(1);
        for (Integer integer : twitterNewsFeed) {
            System.out.println(integer);
        }

    }

    static class Twitter {
        /*控制一个时间戳全局变量，保证每所有推文的唯一性*/
        private static int timestamp = 0;

        /*维护一个userId和user之间的映射关系*/
        private Map<Integer, User> userMap;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            userMap = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         * 用户发布一条推文
         */
        public void postTweet(int userId, int tweetId) {
            /*如果userId对应的用户不存在，则先创建一个User保存在map中*/
            if (!userMap.containsKey(userId)) {
                userMap.put(userId, new User(userId));
            }
            /*从map中取出userId对应的用户，调用user的post方法发布推文*/
            User user = userMap.get(userId);
            user.post(tweetId);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         * 返回该用户关注的人(包括自己)最近的推文id，最多10条，而且必须按照时间从新到旧排序
         * 通过合并 K 个有序链表的算法来实现，每个用户自己发布的推文已经有序了，关键是把不同用户发布的推文合并成有序排列，需要用到优先级队列
         */
        public List<Integer> getNewsFeed(int userId) {
            /*用来保存查询出该用户关注的人的最近10条推文id*/
            List<Integer> tweetIdList = new ArrayList<>();

            /*如果该用户不存在，直接返回空列表*/
            if (!userMap.containsKey(userId))
                return tweetIdList;

            /*获取该用户关注的人所有id*/
            Set<Integer> userIds = userMap.get(userId).followed;

            /*创建一个优先级队列，new一个比较器，通过time属性从大到小排序，容量为关注的人的数量*/
            PriorityQueue<Tweet> tweetPriorityQueue = new PriorityQueue<>(userIds.size(), new Comparator<Tweet>() {
                @Override
                public int compare(Tweet o1, Tweet o2) {
                    return o2.time - o1.time;
                }
            });

            /*遍历关注列表中的所有用户，取出每个用户的推文列表，此时每个用户自己的推文列表是有序的*/
            for (Integer id : userIds) {
                Tweet tweet = userMap.get(id).head;
                /*如果当前遍历的用户没有发布过推文，则直接遍历下一个用户*/
                if (tweet == null)
                    continue;

                /*将每个用户的推文列表的head添加到优先级队列中，会根据每个用户的head节点的time属性进行排序
                * 注意，优先级队列只保存在head头节点，只要获取到head头节点，也就进一步可以获取到该用户的所有推文*/
                tweetPriorityQueue.add(tweet);
            }

            while (!tweetPriorityQueue.isEmpty()){
                /*只需返回10条最近的推文*/
                if (tweetIdList.size() == 10)
                    break;
                /*弹出优先级队列中time值最大的head节点，这个head指向的推文一定是所有用户中所有推文中time值最大的，即最新发布的
                * 并且将这个head指向的推文id添加到tweetIdList中*/
                Tweet tweet = tweetPriorityQueue.poll();
                tweetIdList.add(tweet.id);

                /*可以判断每个用户head指向推文的time值的大小，但是无法判断这个head之后的节点与其它head、以及head之后其它节点time值的大小
                * 所以此时优先级队列的用处凸显出来，既然无法比较剩下的非head的节点，那么如果next不为空，就把next下一个节点添加到优先级队列中
                * 优先级队列会根据上浮、下沉调整队列中节点的顺序，始终保持从大到小的排列*/
                if (tweet.next != null)
                    tweetPriorityQueue.add(tweet.next);
            }
            /*返回排序好的推文id列表*/
            return tweetIdList;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         * follower 关注 followee
         */
        public void follow(int followerId, int followeeId) {
            /*这里的followerId和followeeId实际上就是userId，表明是谁关注了谁
             * 如果关注者不存在，就先创建出一个User对象
             * 如果被关注者不存在，也先创建出一个User对象
             * 保证关注者和被关注者都存在*/
            if (!userMap.containsKey(followerId)) {
                userMap.put(followerId, new User(followerId));
            }
            if (!userMap.containsKey(followeeId)) {
                userMap.put(followeeId, new User(followeeId));
            }
            userMap.get(followerId).follow(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            /*如果关注者存在，才进行取关操作*/
            if (userMap.containsKey(followeeId)) {
                userMap.get(followerId).unfollow(followeeId);
            }
        }

        /*Tweet类来封装每条推文
         * 属性有每条推文的id，推文发表时间，以及指向下一条推文的next指针
         * */
        static class Tweet {
            private int id;
            private int time;
            private Tweet next;

            public Tweet(int id, int time) {
                this.id = id;
                this.time = time;
                this.next = null;
            }
        }

        /*User类用来封装用户
         * 属性有用户id，用户发布的推文列表，关注列表(可以使用Set集合，即不重复又方便查找)
         * */
        static class User {
            private int id;
            public Set<Integer> followed;
            public Tweet head;

            public User(int userId) {
                followed = new HashSet<>();
                this.id = userId;
                this.head = null;
                follow(id);
            }

            /*关注方法
             * 传入想要关注的用户id，添加该用户到Set集合关注列表中*/
            public void follow(int userId) {
                followed.add(userId);
            }

            /*取关方法
             * 从关注列表中移除，不能取关自己*/
            public void unfollow(int userId) {
                if (userId != this.id) {
                    followed.remove(userId);
                }
            }

            /*每个用户都可以发布推文
             * 传入推文id，以及全局的一个推文时间，设为全局是因为需要进行推文列表的合并
             * 每个用户发送推文，添加推文列表中采用头插法，因为新发布的推文必须是排在前面的*/
            public void post(int tweetId) {
                Tweet tweet = new Tweet(tweetId, timestamp);
                timestamp++;
                tweet.next = head;
                head = tweet;
            }
        }
    }


    /**
     * 二叉堆实现优先级队列
     * @param <T>
     */
    static class MaxPQ<T extends Comparable<T>> {
        /*存储元素的数组*/
        private T[] pq = null;

        /*当前优先级队列中元素的个数*/
        private int N = 0;

        /*初始化队列，因为索引 0 不使用，索引容量+1，多分配一个空间*/
        public MaxPQ(int capacity) {
            pq = (T[]) new Comparable[capacity + 1];
        }

        /*返回当前队列中最大的元素，大顶堆，根节点就是最大的元素*/
        public T max() {
            return pq[1];
        }

        /*插入元素 e
         * 插入是先插到最后，然后上浮到正确的位置
         * */
        public void insert(T e) {
            //元素个数先加1，并把新元素插入到最后
            N++;
            pq[N] = e;
            //插入的元素可能破坏了大顶堆的性质，所以需要不断上浮，到合适的位置
            swim(N);
        }

        /*删除并返回当前队列中最大元素
         * 删除的是堆顶元素，先调换位置，把堆顶元素与堆底最后一个元素进行交换，这样删除最后一个元素不会影响其他节点，然后不断下沉交换到堆顶的那个元素
         * */
        public T delMax() {
            //堆顶是最大元素
            T max = pq[1];
            //先交换
            exchange(1,N);
            //元素个数减1
            pq[N] = null;
            N--;
            //不断下沉被交换到堆顶的那个元素
            sink(1);

            return max;
        }

        /*上浮第 k 个元素，以维护大顶堆性质*/
        private void swim(int k) {
            /*如果第 k 个元素的父节点比第 k 个元素小，那么就让第 k 个元素上浮，如果上浮的堆顶，就不应该再上浮了*/
            while (k > 1 && small(parent(k), k)) {
                exchange(parent(k), k);
                k = parent(k);
            }
        }

        /*下沉第 k 个元素，以维护大顶堆性质*/
        private void sink(int k) {
            /*如果下沉到堆底了，就不用继续调整下沉了*/
            while (leftChild(k) <= N){
                //先假设当前第k个节点的左孩子相对较小
                int bigger = leftChild(k);
                //如果存在右孩子，判断左右孩子谁更大，找出更大的那个孩子准备交换
                if (rightChild(k) <= N && small(bigger,rightChild(k))){
                    bigger = rightChild(k);
                }
                //如果左右孩子中较大的那个，都比第k个节点小，那么第k个节点满足大顶堆性质，直接break，不需要再继续交换了
                if (small(bigger,k))
                    break;
                //否则左右两个孩子中有一个比第k个节点更大，交换这两个元素
                exchange(bigger,k);
                //k向下走了一层，不断比较下沉
                k = bigger;
            }
        }

        /*交换两个元素*/
        private void exchange(int i, int j) {
            T temp = pq[i];
            pq[i] = pq[j];
            pq[j] = temp;
        }

        /*判断pq[i]是否比pq[j]小*/
        private boolean small(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }

        /*返回父节点的索引*/
        public int parent(int root) {
            return root / 2;
        }

        /*返回左孩子节点的索引*/
        public int leftChild(int root) {
            return root * 2;
        }

        /*返回右孩子节点的索引*/
        public int rightChild(int root) {
            return root * 2 + 1;
        }

    }
}
