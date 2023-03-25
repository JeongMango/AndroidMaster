package bw.praise.algorithmmaster

//삼총사

//문제 설명
// 한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다.
// 이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 합니다.
// 예를 들어, 5명의 학생이 있고, 각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때,
// 첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로 세 학생은 삼총사입니다.
// 또한, 두 번째, 네 번째, 다섯 번째 학생의 정수 번호를 더해도 0이므로 세 학생도 삼총사입니다.
// 따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.

// 한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때,
// 학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록 solution 함수를 완성하세요.

//제한사항
//3 ≤ number의 길이 ≤ 13
//-1,000 ≤ number의 각 원소 ≤ 1,000
//서로 다른 학생의 정수 번호가 같을 수 있습니다.

//입출력 예
//number	                    result
//[-2, 3, 0, 2, -5]	            2
//[-3, -2, -1, 0, 1, 2, 3]	    5
//[-1, 1, -1, 1]	            0

fun main() {
//    solution24(intArrayOf(-2, 3, 0, 2, -5))
//    solution24(intArrayOf(-3, -2, -1, 0, 1, 2, 3))
//    solution24(intArrayOf(-1, 1, -1, 1))

    ohterSolution24(intArrayOf(-2, 3, 0, 2, -5))
}

fun solution24(number: IntArray): Int {
    var answer = 0

    for (i in 0 until number.size - 2) {
        for (j in i + 1 until number.size - 1) {
            var inx = number.size - 1
            while (j < inx) {
                if(number[i] + number[j] + number[inx] == 0){
                    answer++
                }
                inx--
            }
        }
    }

    println("answer :: $answer")
    return answer
}

//알게된것들
//for문 사용할때 배열일경우 변수 두개를 줘서 배열번째, 요소값을 가져올수있다.
//ex)
//val array = intarrayOf(3,2,4,5,1)
//for((i,n) in array){
//  prit("i::$i n::$n")
//}
//-> -> (0,3) (1,2) (2,4) (3,5) (4,1)
//
fun ohterSolution24(number: IntArray): Int {
    var answer: Int = 0

    var threeMusketeersCount = 0
    for ((i,n) in number.withIndex()) {
        println("i::$i n::$n")
        for ((j, m) in number.withIndex()) {
            for ((k, l) in number.withIndex()) {
                if ((i < j) && (j < k)) {
                    if (n + m + l == 0) {
                        threeMusketeersCount++
                    }
                }
            }
        }
    }
    return threeMusketeersCount
}