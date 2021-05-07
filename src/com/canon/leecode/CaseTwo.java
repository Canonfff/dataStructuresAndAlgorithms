package com.canon.leecode;

/**
 * @ClassName CaseTwo
 * @Description:
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 *
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 *
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Canon
 * @Date 2021/4/1 17:04
 */
public class CaseTwo {

    public static void main(String[] args) {
        System.out.println();
        //System.out.println(superEggDrop(2, 6));
    }

    public static int superEggDrop(int k, int n) {
        int tmp = k<<1;
        if (tmp > n) {
            return k;
        } else {
            return 1 + superEggDrop(tmp, n);
        }
    }
}
