package bw.praise.algorithmmaster

//문제설명
//*약수의 합*
//정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

//제한사항
//n은 0 이상 3000이하인 정수입니다.

// n        return
// 12         28
// 5           6

//입출력 예 설명
//입출력 예 #1
//12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.

//입출력 예 #2
//5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.

//생각해야할 요점
//약수는 나머지가 0인경우이다
fun main() {

    solution(12)

}

fun solution(n: Int): Int {
    var answer = 0

    for (i in 1..n) {
        if (n % i == 0) {
            answer += i
        }
    }
    println("answer :: $answer")
    return answer
}