package bw.praise.algorithmmaster


//콜라츠 추측

//문제 설명
//1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다.
// 작업은 다음과 같습니다.
//1-1. 입력된 수가 짝수라면 2로 나눕니다.
//1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
//2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
//예를 들어, 주어진 수가 6이라면 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1 이 되어 총 8번 만에 1이 됩니다.
//위 작업을 몇 번이나 반복해야 하는지 반환하는 함수, solution을 완성해 주세요. 단, 주어진 수가 1인 경우에는 0을,
//작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환해 주세요.

//제한 사항
//입력된 수, num은 1 이상 8,000,000 미만인 정수입니다.

//입출력 예
//n	    result
//6	    8
//16	    4
//626331	-1


fun main() {


    solution9(626331)
}

fun solution9(num: Int): Int {
    var answer = 0
    var input = num

    while (true) {
        if (input == 1) {
            break
        } else if (answer == 500) {
            answer = -1
            break
        } else {
            answer++
            if (input % 2 == 0) {//짝수
                input /= 2
            } else { //홀수
                var long = input.toDouble()
                long = long * 3 + 1
                input = long.toInt()
            }
        }
        println("input : $input")
    }

    println("ans : $answer")


    return answer
}

//몰랐던 부분
//return에 해당값이 나올때까지 함수를 줘서 반복으로 계속 돌릴수있다.

fun ohter2Solution(num: Int): Int {
    return processor(num.toLong(), 0)
}

private fun processor(n: Long, c: Int): Int {
    if (n == 1.toLong()) {
        return c
    } else if (c == 500) {
        return -1
    }
    return processor(if (n % 2.toLong() == 0.toLong()) n / 2 else n * 3 + 1, c + 1)
}

//공부해야할부분
//tailrec 공부하기
fun otherSolution9(num: Int): Int = collatzAlgorithm(num.toLong(), 0)

tailrec fun collatzAlgorithm(n: Long, c: Int): Int =
    when {
        c > 500 -> -1
        n == 1L -> c
        else -> collatzAlgorithm(if (n % 2 == 0L) n / 2 else (n * 3) + 1, c + 1)
    }


