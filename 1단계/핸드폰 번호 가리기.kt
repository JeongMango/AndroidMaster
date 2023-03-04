package bw.praise.algorithmmaster


//핸드폰 번호 가리기


//문제 설명
//프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
//전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.


//제한 조건
//phone_number는 길이 4 이상, 20이하인 문자열입니다.

//입출력 예
//phone_number	    return
//"01033334444"	    "*******4444"
//"027778888"	    "*****8888"


fun main() {

    solution12("01048555601")
}

//다시 공부하면 좋은것
//substring(0, 2)은 문자열 0~2번째에 문자열을 뽑아내는것이다
//slice(0, 2)도 문자열 0~2번째에 문자열을 뽑아내는것이다
//차이점 확인법 -> https://velog.io/@ktseo41/TIL-6%EC%9B%94-24%EC%9D%BC-slice-substring-%EB%B9%84%EA%B5%90

//slice, substring 차이점

//slice
//start가 stop보다 크면 empty string 반환
//start가 음수이면 string의 가장 뒤에서 음수만큼 내려온 index로 취급한다.
//stop이 음수이면 역시 string의 가장 뒤에서 음수만큼 내려온 index로 취급한다.
//(음수만큼 내려왔다는 표현이 추상적이다. 예를들어 'abcde'에서 'abcde'.slice(-3) 이면 'cde'이다.)

//substring
//start가 stop보다 크면 자리를 바꾼다.
//start나 stop이 음수이거나 NaN이면 0을 사용한다.

fun solution12(phone_number: String): String {
    var num = phone_number
    var answer = ""
    var count = num.length
    count -= 4

    for (i in 0 until count) {
        answer += "*"
    }

    num = num.substring(count until num.length)
    answer += num


    return answer
}

//몰랐던 문법
//Ex)
//padStart는 문자열로부터 부족한 부분을 원하는 문자열로 채워주는 문법이다
//val padWithSpace = "125".padStart(5)
//println("'$padWithSpace'") // '  125'
//val padWithChar = "a".padStart(5, '.')
//println("'$padWithChar'") // '....a'
//// 문자열의 길이가 지정된 것보다 크면있는 그대로 반환됩니다.
//val noPadding = "abcde".padStart(3)
//println("'$noPadding'") // 'abcde'

fun otherSolution12(phone_number: String): String {
    return "${"".padStart(phone_number.length - 4, '*')}${phone_number.takeLast(4)}"
}