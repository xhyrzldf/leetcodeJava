package test

import domain.UnionFind

/**
 * Description : UnionFindTest Example
 *
 *
 *
 * Author : Matrix [xhyrzldf@foxmail.com]
 *
 *
 *
 * Date : 2017/10/7 18:28
 */
object UnionFindTest {
    @JvmStatic
    fun main(args: Array<String>) {
        testUF(1000000)
    }

    fun testUF(n: Int) {

        val uf = UnionFind(n)

        val startTime = System.currentTimeMillis()

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for (i in 0 until n) {
            val a = (Math.random() * n).toInt()
            val b = (Math.random() * n).toInt()
            uf.unionElements(a, b)
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for (i in 0 until n) {
            val a = (Math.random() * n).toInt()
            val b = (Math.random() * n).toInt()
            uf.isConnected(a, b)
        }
        val endTime = System.currentTimeMillis()

        // 打印输出对这2n个操作的耗时
        println("UF4, " + 2 * n + " ops, " + (endTime - startTime) + "ms")
    }
}
