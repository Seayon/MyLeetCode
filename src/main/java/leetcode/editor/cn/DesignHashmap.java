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

import java.util.Iterator;
import java.util.LinkedList;

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
        private class Pair {
            private int key;
            private int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        private static final int BASE = 769;
        private LinkedList[] data;

        /** Initialize your data structure here. */
        public MyHashMap() {
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; ++i) {
                data[i] = new LinkedList<Pair>();
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int h = hash(key);
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    pair.setValue(value);
                    return;
                }
            }
            data[h].offerLast(new Pair(key, value));
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int h = hash(key);
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    return pair.value;
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int h = hash(key);
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.key == key) {
                    data[h].remove(pair);
                    return;
                }
            }
        }

        private int hash(int key) {
            return key % BASE;
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
