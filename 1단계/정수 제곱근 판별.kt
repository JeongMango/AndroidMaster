package bw.praise.algorithmmaster

import kotlin.math.sqrt


//문제설명
//임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
//n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

//제한 사항
//n은 1이상, 50000000000000 이하인 양의 정수입니다.


//입출력 예
//n	    return
//121	144
//3	    -1

//몰랐던부분
//sqrt 제곱근 구하는문법

fun main() {
//    solution5(5)
//    solution5(3)
    solution5(121)
}

fun solution5(n: Long): Long {

    val a = Math.sqrt(n.toDouble()).toLong()

    return if(a * a == n) (a+1)*(a+1) else -1
}