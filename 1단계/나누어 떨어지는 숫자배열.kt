package bw.praise.algorithmmaster


//나누어 떨어지는 숫자 배열

//문제 설명
//array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
//divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.


//제한사항
//arr은 자연수를 담은 배열입니다.
//정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
//divisor는 자연수입니다.
//array는 길이 1 이상인 배열입니다.


//입출력 예
//arr	            divisor	    return
//[5, 9, 7, 10]	    5	        [5, 10]
//[2, 36, 1, 3]	    1	        [1, 2, 3, 36]
//[3,2,6]	        10	        [-1]


fun main() {
//    solution11(intArrayOf(5, 9, 7, 10), 5)
//    solution11(intArrayOf(2, 36, 1, 3), 1)
//    solution11(intArrayOf(3, 2, 3), 10)


}

fun solution11(arr: IntArray, divisor: Int): IntArray {
    var count = 0

    for (i in 0 until arr.size) {
        if (arr[i] % divisor == 0) {
            count++
        }
    }

    if (count == 0) {
        val intArr = intArrayOf(-1)

        return intArr
    } else {
        var count2 = 0
        var intArr = IntArray(count)
        for (i in 0 until arr.size) {

            if (arr[i] % divisor == 0) {

                intArr[count2] = arr[i]
                count2++
            }

        }
        intArr.sort()
        return intArr
    }

}
//몰랐던부분
//array += 값 <- 이렇게하면 배열에 스택처럼 뒤에 쌓인다
//ex)
// var array = intArrayof()
// array += 3
// array += 2
// array += 1
// array -> array{3, 2, 1}
fun otherSolution11(arr: IntArray, divisor: Int): IntArray {
    var answer = intArrayOf()

    arr.forEach { if (it % divisor == 0) answer += it }
    answer.sort()

    if (answer.size == 0) answer += -1

    return answer

}


