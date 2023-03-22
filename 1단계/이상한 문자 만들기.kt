package bw.praise.algorithmmaster

//이상한 문자 만들기

//문제 설명
//문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

//제한 사항
//문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
//첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.

//입출력 예
//s	                    return
//"try hello world"	    "TrY HeLlO WoRlD"

//입출력 예 설명
//"try hello world"는 세 단어 "try", "hello", "world"로 구성되어 있습니다. 각 단어의 짝수번째 문자를 대문자로,
// 홀수번째 문자를 소문자로 바꾸면 "TrY", "HeLlO", "WoRlD"입니다. 따라서 "TrY HeLlO WoRlD" 를 리턴합니다.

fun main() {
    solution22("try hello world")
    solution22("try abcd efghijk m")
    solution22("abcahday")
}

//몰랐던 부분
//소문자 대문자 만들기
//소문자로 변경 -> .lowercase()
//대문자로 변경 -> .uppercase()
//split는 문자열 ()안에 있는값 제외 하고 배열로 나눔
//ex)
// [try hello world].split(" ")  ->  [try, hello, world]
// [abcahday].split("a")         ->  [,bc, hd, y]
fun solution22(s: String): String {
    var answer = ""
    var strArray = s.split(" ")

    println("strArray -> $strArray")
    strArray.forEach {
        var size = it.length
        for (i in 0 until size) {
            if (i % 2 == 0) {
                answer += it[i].uppercase()
            } else {
                answer += it[i].lowercase()
            }
        }
        if (answer.length == s.length) {
            answer += ""
        } else {
            answer += " "
        }
    }

    println("answer ->  ${answer}")
    return answer
}


//공부했는데 잊어버린부분
//1. jointoString <- 이 함수는 목록이나 배열을 콤마로 구분된 문자열로 바꿔줍니다
//ex)
//[try hello world].joinToString(" "){ word ->
//   println(word).toString
//}
//결과값
//try
//hello
//world

//2. mapIndexed{index, char}일때 index는 배열몇번째인지, char은 index번째에 배열요소값이다

fun otherSolution22(s: String) =
    s.split(" ").joinToString(" ") { word ->
        word
            .mapIndexed { index, char ->
                if (index % 2 == 0) char.uppercase() else char.lowercase()
            }
            .joinToString("")
    }