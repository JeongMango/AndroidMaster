package bw.praise.algorithmmaster

//문제설명
//자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

//제한 조건
//n은 10,000,000,000이하인 자연수입니다.

//입출력 예
//n         return
//12345     [5,4,3,2,1]

fun main() {

    solution3(1234567890)
}

fun solution3(n: Long): IntArray {
    var answer = intArrayOf()
    var input = n
    val count = n.toString().length
    var dap = IntArray(count)
    var result = IntArray(count)
    var a = count - 1
    for (i in 0 until count) {
        val num = input.toString()
        dap[i] = num.substring(i,i+1).toInt()
        result[a] = dap[i]
        a--
    }

    answer = result

    return answer
}

//다른방법
fun other(n: Long): IntArray {
    return n.toString().reversed().map { it.toString().toInt() }.toIntArray()
}