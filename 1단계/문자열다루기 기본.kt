package bw.praise.algorithmmaster


//문자열 다루기 기본

//문제 설명
//문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.


//제한 사항
//s는 길이 1 이상, 길이 8 이하인 문자열입니다.
//s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.


//입출력 예
//s	        return
//"a234"	false
//"1234"	true


fun main(){
    solution20("a234")
    solution20("1234")
}

fun solution20(s: String) = (s.length == 4 || s.length == 6) && s.all{ it.isDigit() }

fun otherSolution20(s: String) = (s.length == 4 || s.length == 6) && s.toIntOrNull() != null

fun other2Solution20(s: String): Boolean
{
    val length = s.filter { it.isDigit() }.length
    return (length == 4 || length == 6) && length == s.length
}