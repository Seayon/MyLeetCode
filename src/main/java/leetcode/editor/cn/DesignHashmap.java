//不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
//
// 实现 MyHashMap 类：
//
//
// MyHashMap() 用空映射初始化对象
// void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，
//则更新其对应的值 value 。
// int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
// void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
//
//
//
//
// 示例：
//
//
//输入：
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//输出：
//[null, null, null, 1, -1, null, 1, null, -1]
//
//解释：
//MyHashMap myHashMap = new MyHashMap();
//myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
//myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
//myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
//myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
//myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
//
//
//
//
// 提示：
//
//
// 0 <= key, value <= 10⁶
// 最多调用 10⁴ 次 put、get 和 remove 方法
//
// Related Topics 设计 数组 哈希表 链表 哈希函数 👍 253 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class DesignHashmap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new DesignHashmap().new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        Assertions.assertEquals(1, myHashMap.get(1));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        Assertions.assertEquals(-1, myHashMap.get(3));    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        Assertions.assertEquals(1, myHashMap.get(2));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        Assertions.assertEquals(-1, myHashMap.get(2));    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]

        myHashMap.put(12, 12);
        Assertions.assertEquals(12, myHashMap.get(12));

        myHashMap.put(18, 18);
        Assertions.assertEquals(18, myHashMap.get(18));

        myHashMap.put(2, 2);
        Assertions.assertEquals(2, myHashMap.get(2));

        myHashMap.put(34, 34);
        Assertions.assertEquals(34, myHashMap.get(34));
        test2();
        test3();
    }

    public static void test2() {
        MyHashMap map = new DesignHashmap().new MyHashMap();

        map.remove(14);
        map.get(4);
        map.put(7, 3);
        map.put(11, 1);
        map.put(12, 1);
        map.get(7);
        map.put(1, 19);
        map.put(0, 3);
        map.put(1, 8);
        map.put(2, 6);
    }

    public static void test3() {
        // ["MyHashMap","get","put","put","put","remove","put","put","put","get","put","put","put","put","get","put","get","put","put","put","put","remove","put","put","put","put","put","put","put","get","put","put","put","put","put","put","put","put","put","put","put","put","put","remove","put","remove","put","remove","put","remove","put","put","put","remove","put","put","put","put","get","put","put","put","get","remove","put","put","put","put","remove","put","put","put","get","put","put","get","get","put","put","put","put","put","put","put","put","get","put","put","put","get","get","remove","remove","put","get","get","put","get","put","put","get"]
        MyHashMap map = new DesignHashmap().new MyHashMap();
        int[][] c = new int[][]{{}, {79}, {72, 7}, {77, 1}, {10, 21}, {26}, {94, 5}, {53, 35}, {34, 9}, {94}, {96, 8}, {73, 79}, {7, 60}, {84, 79}, {94}, {18, 13}, {18}, {69, 34}, {21, 82}, {57, 64}, {23, 60}, {0}, {12, 97}, {56, 90}, {44, 57}, {30, 12}, {17, 10}, {42, 13}, {62, 6}, {34}, {70, 16}, {51, 39}, {22, 98}, {82, 42}, {84, 7}, {29, 32}, {96, 54}, {57, 36}, {85, 82}, {49, 33}, {22, 14}, {63, 8}, {56, 8}, {94}, {78, 77}, {51}, {20, 89}, {51}, {9, 38}, {20}, {29, 64}, {92, 69}, {72, 25}, {73}, {6, 90}, {1, 67}, {70, 83}, {58, 49}, {79}, {73, 2}, {56, 16}, {58, 26}, {53}, {7}, {27, 17}, {55, 40}, {55, 13}, {89, 32}, {49}, {75, 75}, {64, 52}, {94, 74}, {81}, {39, 82}, {47, 36}, {57}, {66}, {3, 7}, {54, 34}, {56, 46}, {58, 64}, {22, 81}, {3, 1}, {21, 96}, {6, 19}, {77}, {60, 66}, {48, 85}, {77, 16}, {78}, {23}, {72}, {27}, {20, 80}, {30}, {94}, {74, 85}, {49}, {79, 59}, {15, 15}, {26}};
        for (int[] ints : c) {
            if (ints.length == 1) {
                map.get(ints[0]);
            }
            if (ints.length == 2) {
                map.put(ints[0], ints[1]);
            }
        }
        System.out.println(map);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {

        private Node[] r = new Node[4096];

        public MyHashMap() {
        }

        public void put(int key, int value) {
            int index = computeIndex(key);
            if (r[index] == null) {
                r[index] = new Node(key, value);
                return;
            }
            // 如果当前这个 key 已经有了内容,且 key 的值等于本次传入的值,就覆盖一下 value 值
            if (r[index].key == key) {
                r[index].value = value;
                return;
            }
            //    否则的话,就是这个 index 已经有内容,但是内容的 key 和传入的不一致,只不过 hash 算出来的位置一致,这种情况下把他通过链表连接到后面,中间如果遇到 key 一致的,要替换一下
            Node tmp = r[index];
            while (tmp.next != null) {
                //如果发现有 key 一样的,就替换一下 value,然后直接返回不再进行其他处理
                if (tmp.key == key) {
                    tmp.value = value;
                    return;
                }
                tmp = tmp.next;

            }
            tmp.next = new Node(key, value);
        }

        public int get(int key) {
            int index = computeIndex(key);
            Node node = r[index];
            while (node != null && node.next != null) {
                if (node.key == key) {
                    //找到一样的就返回
                    return node.value;
                } else {
                    node = node.next;
                }
            }
            if (node == null) {
                return -1;
            }
            if (node.key != key) {
                return -1;
            }
            return node.value;
        }

        public void remove(int key) {
            int index = computeIndex(key);
            Node node = r[index];
            if (node == null) {
                return;
            }
            if (node != null && node.key == key) {
                r[index] = node.next;
                return;
            }
            Node prev = node;
            Node next = node.next;
            while (next != null) {
                //    在链表中迭代找到合适的节点移除
                if (next.key == key) {
                    prev.next = next.next;
                } else {
                    prev = next;
                    next = next.next;
                }

            }
            return;
        }

        private int computeIndex(int key) {
            return key % r.length;
            /**
             * 11 % 8 = 5
             *
             * 11 = 00000111
             * 8  = 00000100
             * 00000111 ^ 00000100 -1 = 00000011 = 5,但是要保证 后面被与的数是 2 的 n 次方
             */
            //    00000000
        }

        class Node {
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            int key;
            int value;
            Node next;
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
