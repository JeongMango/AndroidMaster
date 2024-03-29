package com.example.study

/*
[2016년]
문제 설명
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT

입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.

제한 조건
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)*/
fun main() {
    var a = 5
    var b = 24
    println(solution(a, b))
}


fun solution(a: Int, b: Int): String {
    var answer = ""
    var sumDay = 0
    var rest = 0
    var dayWeek = arrayListOf<String>("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")
    var day = arrayListOf<Int>(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    for (i in 0..a - 1) {
        sumDay = sumDay + day[i]
    }
    sumDay = sumDay + b
    if (sumDay % 7 - 1 == -1) {
        answer = "THU"
    } else {
        rest = sumDay % 7 - 1
        println(rest)
        println("${dayWeek[rest]} 요일")
        println(" :: ${sumDay}")
        answer = dayWeek[rest]
    }
    return answer
}

fun otherSolutions(a: Int, b: Int): String {
    var monthToDay = arrayOf(0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335);
    var charDays = arrayOf("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU");
    var days = (b - 1 + monthToDay.get(a)) % 7;

    return charDays.get(days);
}