package com.example.algoritnmmaster

//시저 암호

//문제 설명
//어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

//제한 조건
//공백은 아무리 밀어도 공백입니다.
//s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
//s의 길이는 8000이하입니다.
//n은 1 이상, 25이하인 자연수입니다.

//입출력 예
//s	        n	    result
//"AB"	    1	    "BC"
//"z"	    1	    "a"
//"a B z"	4	    "e F d"


fun main() {
//    solution4("AsBc", 1)

}

//알게된것들
//아스크 코드
//a~z 97~122
//A~Z 65~90

fun solution4(s: String, n: Int): String {
    return s.toCharArray().map {
        println("it :: $it")
        when (it) {
            in 'A'..'Z' -> {
                if (it + n > 'Z') it + n - 26 else it + n
            }
            in 'a'..'z' -> {
                if (it + n > 'z') it + n - 26 else it + n
            }
            else -> {
                it
            }
        }
    }.joinToString("")
}

fun otherSolution(s: String, n: Int): String {
    var answer = ""

    for (c in s) {
        if (c == ' ') {
            answer += ' '
        } else {
            answer += getAlphabet(c, n)
        }
    }
    return answer
}

fun getAlphabet(c: Char, n: Int): Char {
    var isUpper = false
    var ascii = c.toInt()
    if (ascii >= 65 && ascii <= 90) isUpper = true
    ascii += n
    if (isUpper) {
        if (ascii > 90) ascii = ascii - 90 + 65 - 1
    } else {
        if (ascii > 122) ascii = ascii - 122 + 97 - 1
    }

    return ascii.toChar()
}