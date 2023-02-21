package bw.praise.algorithmmaster


//문제설명
//자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
//예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

//제한사항
//N의 범위 : 100,000,000 이하의 자연수
fun main() {

//    solution2(123)

    other(987)
}

//생각해야할 부분
//자릿수를 구하는걸 고민했다
fun solution2(n: Int): Int {
    var answer = 0
    var num = n.toString()

    for (i in 0 until num.length) {

        var digits = num.substring(i..i).toInt()
        answer += digits
    }

    return answer
}
//다른방법
//while 문으로 n값이 0일때까지 10으로 n값을 나눠서 나머지값을 계속 더하기
//ex) 987 -> 987 % 10 = 7
fun other(n: Int): Int{
    var input = n
    var answer = 0

    while (input != 0) {

        answer += input % 10
        input /= 10

    }
    println("answer :: $answer")
    return answer
}

//map 개념 공부하기
fun studySolution(n: Int): Int {
    return n.toString().toSingleDigitList().sum()
}

fun String.toSingleDigitList() = map {
    "$it".toIntOrNull()
}.filterNotNull()


