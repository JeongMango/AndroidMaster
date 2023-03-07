package bw.praise.algorithmmaster

//수박수박수박수박수박수?

//문제 설명
//길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.


//제한 조건
//n은 길이 10,000이하인 자연수입니다.


//입출력 예
//n	return
//3	"수박수"
//4	"수박수박"

fun main() {
//    solution16(1)
//    solution16(2)
//    solution16(3)
//    solution16(4)
//    solution16(5)
//    solution16(6)
//    solution16(7)
//    solution16(8)
//    solution16(9)


}

fun solution16(n: Int): String {
    var answer = ""

    var su = "수"
    var subak = "수박"
    var count = n / 2
    for (i in 0 until count) {

        if (n % 2 == 0) {
            answer += subak
        } else {
            answer += subak
            if (i == count - 1) {
                answer += su

            }
        }
    }
    if (n == 1) {
        answer = su

    }
    println(answer)
    return answer
}


fun otherSolution16(n: Int): String = String(CharArray(n) { i -> if (i % 2 == 0) '수' else '박' })



