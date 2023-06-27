package com.example.algorizmstudy

import java.util.*
import kotlin.collections.ArrayDeque

//옹알이 (2)
//
//문제 설명
//
//머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다.
//조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서
//같은 발음을 하는 것을 어려워합니다. 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를
//return하도록 solution 함수를 완성해주세요.

//제한사항
//1 ≤ babbling의 길이 ≤ 100
//1 ≤ babbling[i]의 길이 ≤ 30
//문자열은 알파벳 소문자로만 이루어져 있습니다.

//입출력 예
//babbling	result
//["aya", "yee", "u", "maa"]	1
//["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]	2

//입출력 예 설명

//입출력 예 #1
//["aya", "yee", "u", "maa"]에서 발음할 수 있는 것은 "aya"뿐입니다. 따라서 1을 return합니다.

//입출력 예 #2
//["ayaye", "uuuma", "yeye", "yemawoo",
//"ayaayaa"]에서 발음할 수 있는 것은
//"aya" + "ye" = "ayaye", "ye" + "ma" + "woo" = "yemawoo"로 2개입니다.
// "yeye"는 같은 발음이 연속되므로 발음할 수 없습니다. 따라서 2를 return합니다.


fun main() {
//    solution(arrayOf("aya", "yee", "u", "maa"))
//    solution(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"))
//    solution(arrayOf("ayeyea", "ayaayayeyeye", "yeaye"))
//        solution(arrayOf("yayae", "yayae", "yayae"))

//    otherSolution(arrayOf("aya", "yee", "u", "maa"))
//    otherSolution(arrayOf("ayeyea", "ayaayayeyeye", "yeaye"))
//    otherSolution(arrayOf("yayae", "yayae", "yayae"))
}

//공부한것들
//반복문에서 continue를 사용하면 다음회차로 넘어가는것 반복문을 멈추고 싶을때는 break를 쓰면 된다
//a.contains(b)는 a문자열에서 b가 포함되어있는지 true false로 알려주는 함수이다.
//
fun solution(babbling: Array<String>): Int {
    var answer: Int = 0
    val ableList = arrayOf("aya", "ye", "woo", "ma")

    for (i in babbling) {
        var temp = i
        for (j in ableList.indices) {
            if (temp.contains(ableList[j] + ableList[j])) {
                continue
            } else {
                //yayae같은 문제일경우 aya를 replace로 ""처리 했을경우 ye로 뭉치게 되며
                // ye가 발음할수있는 단어로 되므로 뛰어쓰기를 준다
                temp = temp.replace(ableList[j], " ")
            }
        }
        //뛰어쓰기를 한것들 공백처리 하고 합치고 나서 문자열이 공백일경우 answer를 증가해준다
        if (temp.replace(" ", "") == "") answer++
    }
    return answer
}

//split 응용법
//split로 배열로 설정하면 배열에 속해 있는 요소기준으로 배열로 나눠준다.
fun otherSolution(babbling: Array<String>): Int {
    var answer = 0
    val ableList = arrayOf("aya", "ye", "woo", "ma")
    for (i in babbling) {
        var temp = i
        var status = true
        val splitList = temp.split("aya", "ye", "woo", "ma")
        //split로 나눈 배열을 하나씩 검토해서 값이 있을경우 구분을 해준다.
        splitList.forEach {
            if (it.isNotEmpty()) {
                status = false
            }
        }
        if (status) answer++
    }
    return answer
}