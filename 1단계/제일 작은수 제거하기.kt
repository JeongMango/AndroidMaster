package bw.praise.algorithmmaster


//제일 작은 수 제거하기

//문제 설명
//정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
// 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
// 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.


//제한 조건
//arr은 길이 1 이상인 배열입니다.
//인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.

//입출력 예
//arr	        return
//[4,3,2,1]	    [4,3,2]
//[10]	        [-1]


fun main() {
    solution13(intArrayOf(4, 1, 2, 1))

}

//공부해야할부분
//IntArray에서는 removeAt() 함수를 사용하지못한다. 그래서 .toMutableList()로 형변환해서 removeAt()함수를 적용했다.
fun solution13(arr: IntArray): IntArray {
    var answer = intArrayOf()

    if (arr[0] == 10) {
        answer = intArrayOf(-1)
    } else {
        var desArr = arr.toMutableList()
        var input = arr.toMutableList()
        desArr.sort()
        for (i in 0..arr.lastIndex) {

            if (desArr[0] == arr[i]) {
                input.removeAt(i)
                answer = input.toIntArray()
                break
            }
        }
    }
    println(answer.contentToString())

    return answer
}
//몰랐던부분
//배열.filter를 하면 조건에 맞는요소값이 필터된다
//배열.min()을 하면 배열에서 가장작은 배열요소를 얻을수있다.
fun otherSolution13(arr: IntArray): IntArray = if (arr.size == 1) arrayOf(-1).toIntArray()
else arr.filter { it != arr.min() }.toIntArray()