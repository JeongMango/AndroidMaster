package com.example.algorizmstudy


import java.util.*


//더공부 필요한것들
//1) .map { it.digitToInt() }.sorted()
//2) result.sortedByDescending{ it }.forEach {
//            answer.append(it)
//        }
class Solution {
    fun solution(X: String, Y: String): String {
        var answer = StringBuilder()

        val result = mutableListOf<Int>()
        val xList = X.toCharArray().map { it.digitToInt() }.sorted()
        val yList = Y.toCharArray().map { it.digitToInt() }.sorted()

        var index = 0
        xList.forEach {
            for(i in index until yList.size) {
                if(yList[i] == it) {
                    result.add(it)
                    index = i + 1
                    break
                }
            }
        }

        result.sortedByDescending{ it }.forEach {
            answer.append(it)
        }

        if(answer.isEmpty()) return "-1"
        else if(answer[0] == '0') return "0"

        return answer.toString()
    }
}