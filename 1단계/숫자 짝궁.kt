package com.example.algorizmstudy


import java.util.*

fun main() {

}

//더공부 필요한것들
//1) .map { it.digitToInt() }.sorted()
//2) result.sortedByDescending{ it }.forEach {
//            answer.append(it)
//        }
fun solution(X: String, Y: String): String {
    var answer = StringBuilder()

    val result = mutableListOf<Int>()
    val xList = X.toCharArray().map { it.digitToInt() }.sorted()
    val yList = Y.toCharArray().map { it.digitToInt() }.sorted()

    var index = 0
    xList.forEach {
        for (i in index until yList.size) {
            if (yList[i] == it) {
                result.add(it)
                index = i + 1
                break
            }
        }
    }

    result.sortedByDescending { it }.forEach {
        answer.append(it)
    }

    if (answer.isEmpty()) return "-1"
    else if (answer[0] == '0') return "0"

    return answer.toString()
}

fun otherSolution(X: String, Y: String): String {
    var sameNums: String = ""
    var yNums = Y

    for (i in 0..9) {
        val intToChar = (i + 48).toChar()
        val xContainCount = X.filter { it == intToChar }.count()
        val yContainCount = Y.filter { it == intToChar }.count()
        val minCount = if (xContainCount >= yContainCount) yContainCount else xContainCount
        if (minCount > 0) sameNums += intToChar.toString().repeat(minCount)
    }

    if (sameNums.length == 0) return "-1"
    sameNums = String(sameNums.toCharArray().apply { sortDescending() })
    if (sameNums[0] == '0') return "0" else return sameNums
}



