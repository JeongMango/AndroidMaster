package com.example.study

import android.icu.number.IntegerWidth
//오답노트
//https://soeun-87.tistory.com/26
//1. Comparable
//-  클래스의 인스턴스를 비교하는 방법으로 자바에서는 Comparable 인터페이스가 compareTo() 함수를 제공한다. 코틀린에서는 이걸  Comparable 인터페이스로 제공하고, 함수 extension도 가능하다.

/*문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5,       1, 2, 3, 4, 5, ...                             12345
2번 수포자가 찍는 방식: 2, 1, 2, 3,  2, 4, 2, 5 , 2, 1, 2, 3, 2, 4, 2, 5, ...               21232425
3번 수포자가 찍는 방식: 3, 3,  1, 1,  2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...   31245

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.

가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

모든 사람이 2문제씩을 맞췄습니다.*/


fun main(){
    var answer = intArrayOf(1, 2, 3, 4, 5)


    println(solution(answer))
    //println(solution1(answer))
}
/*12345
21232425
31245*/
//answers = 답
fun solution(answers: IntArray): IntArray {


    var one = intArrayOf(1, 2, 3, 4, 5)//5 * 2000 = 10000
    var two = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)//8 * 1250 = 10000
    var three = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)//10 * 1000 = 10000
    var oneCount = 0
    var twoCount = 0
    var threeCount = 0


    for (i in 0..answers.size-1){
        var array1 = i % one.size
        var array2 = i % two.size
        var array3 = i % three.size

        if(answers[i] == one[array1]){
            oneCount++
        }
        if(answers[i] == two[array2]){
            twoCount++
        }
        if(answers[i] == three[array3]){
            threeCount++
        }
    }



    var answer = intArrayOf(oneCount, twoCount, 1)


    val max = answer[0].coerceAtMost(answer[1].coerceAtMost(answer[2]))

    println(max)

  /*  //println("max =${max}")
    println("answer[o] =${answer[0]}")
    println("answer[o] =${answer[1]}")
    println("answer[o] =${answer[2]}")
    var min = answer.min()

    var a = answer.max()
*/

    return answer

}


fun solution1(answers: IntArray): IntArray {
    val score = IntArray(3)
    val a = intArrayOf(1, 2, 3, 4, 5)
    val b = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val c = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    for (i in answers.indices) {
        if (answers[i] == a[i % a.size]) score[0]++
        if (answers[i] == b[i % b.size]) score[1]++
        if (answers[i] == c[i % c.size]) score[2]++

    }

    val max = score[0].coerceAtLeast(score[1].coerceAtLeast(score[2]))

    val list: MutableList<Int> = ArrayList()
    if (max == score[0]) {
        list.add(1)
    }
    if (max == score[1]) {
        list.add(2)
    }
    if (max == score[2]) {
        list.add(3)
    }
    val answer = IntArray(list.size)
    for (i in list.indices) {
        answer[i] = list[i]

    }

    return answer
}
