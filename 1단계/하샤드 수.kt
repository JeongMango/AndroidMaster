package bw.praise.algorithmmaster


//하샤드 수

//문제 설명
//양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고,
// 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.


//제한 조건
//x는 1 이상, 10000 이하인 정수입니다.


//입출력 예
//arr	return
//10	true
//12	true
//11	false
//13	false


fun main() {
    solution7(10)
//    solution7(11)
}


fun solution7(x: Int): Boolean {
    var input = x.toString()
    var count = input.length
    var y = 0
    var c = 0
    for (i in 0 until count) {
        y = input.substring(i, i + 1).toInt()
        c += y
    }
    return x % c == 0

}

fun other2Solution(x: Int): Boolean {
    var sum = 0
    var num = x

    while (num > 0) {
        sum += num % 10
        println("sum : $sum")
        num /= 10
        println("num : $num")

    }

    return (x % sum == 0)
}

fun otherSolution(x: Int): Boolean {
    return x % x.toString().fold(0) { acc, c -> acc + c.toInt() - 48 } == 0
}
