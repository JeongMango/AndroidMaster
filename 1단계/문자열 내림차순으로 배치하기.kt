package bw.praise.algorithmmaster


//문자열 내림차순으로 배치하기

//문제 설명
//문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

//제한 사항
//str은 길이 1 이상인 문자열입니다.

//입출력 예
//s	            return
//"Zbcdefg"	    "gfedcbZ"


fun main() {
//    solution18("acbedgqAGEj")
    solution18("Zbcdefg")
    otherSolution18("acbedgqAGEj")

}

//몰랐던 부분

fun solution18(s: String): String {

    println("${String(s.toCharArray().sortedArrayDescending())}")
    return s.split("").sorted().reversed().joinToString("")

}
//알게된것
//sorted()함수를 적용시키기 위해서는 toCharArray()로 형변환 해주어야 한다.
fun otherSolution18(s: String): String = String(s.toCharArray().sortedArrayDescending())
