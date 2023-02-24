package bw.praise.algorithmmaster

//문제 설명
//함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

//제한 조건
//n은 1이상 8000000000 이하인 자연수입니다.


//입출력 예
//n	    return
//118372	873211

fun main(){
    solution6(1234567890)

}
//고려사항
//toCharArray()에서 바로 내림차순을 할수있었다
//sortedArrayDescending()와 sortDescending() 차이를 공부해보자
fun solution6(n: Long): Long {

    var input = n.toString()
    var count = input.length
    println("$count")
    var a = LongArray(count)
    for(i in 0 until count){
        a[i] = input.substring(i, i+1).toLong()
    }
    a.sortDescending()
    var answer = ""
    for(i in 0 until count){
        answer += a[i]
    }
    return answer.toLong()
    println("answer :: $answer")

}

fun other2(n: Long): Long = String(n.toString().toCharArray().sortedArrayDescending()).toLong()