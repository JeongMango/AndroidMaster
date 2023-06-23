package com.example.algorizmstudy

import java.util.*

//덧칠하기
//
//문제 설명
//
//어느 학교에 페인트가 칠해진 길이가 n미터인 벽이 있습니다. 벽에 동아리 · 학회 홍보나 회사 채용 공고 포스터 등을 게시하기 위해 테이프로 붙였다가 철거할 때 떼는 일이 많고 그 과정에서 페인트가 벗겨지곤 합니다. 페인트가 벗겨진 벽이 보기 흉해져 학교는 벽에 페인트를 덧칠하기로 했습니다.
//넓은 벽 전체에 페인트를 새로 칠하는 대신, 구역을 나누어 일부만 페인트를 새로 칠 함으로써 예산을 아끼려 합니다. 이를 위해 벽을 1미터 길이의 구역 n개로 나누고, 각 구역에 왼쪽부터 순서대로 1번부터 n번까지 번호를 붙였습니다. 그리고 페인트를 다시 칠해야 할 구역들을 정했습니다.
//벽에 페인트를 칠하는 롤러의 길이는 m미터이고, 롤러로 벽에 페인트를 한 번 칠하는 규칙은 다음과 같습니다.
//롤러가 벽에서 벗어나면 안 됩니다.
//구역의 일부분만 포함되도록 칠하면 안 됩니다.
//즉, 롤러의 좌우측 끝을 구역의 경계선 혹은 벽의 좌우측 끝부분에 맞춘 후 롤러를 위아래로 움직이면서 벽을 칠합니다. 현재 페인트를 칠하는 구역들을 완전히 칠한 후 벽에서 롤러를 떼며, 이를 벽을 한 번 칠했다고 정의합니다.
//한 구역에 페인트를 여러 번 칠해도 되고 다시 칠해야 할 구역이 아닌 곳에 페인트를 칠해도 되지만 다시 칠하기로 정한 구역은 적어도 한 번 페인트칠을 해야 합니다. 예산을 아끼기 위해 다시 칠할 구역을 정했듯 마찬가지로 롤러로 페인트칠을 하는 횟수를 최소화하려고 합니다.
//정수 n, m과 다시 페인트를 칠하기로 정한 구역들의 번호가 담긴 정수 배열 section이 매개변수로 주어질 때 롤러로 페인트칠해야 하는 최소 횟수를 return 하는 solution 함수를 작성해 주세요.
//제한사항
//1 ≤ m ≤ n ≤ 100,000
//1 ≤ section의 길이 ≤ n
//1 ≤ section의 원소 ≤ n
//section의 원소는 페인트를 다시 칠해야 하는 구역의 번호입니다.
//section에서 같은 원소가 두 번 이상 나타나지 않습니다.
//section의 원소는 오름차순으로 정렬되어 있습니다.
//입출력 예
//n	    m	    section	            result
//8	    4	    [2, 3, 6]	        2
//5	    4	    [1, 3]	            1
//4	    1	    [1, 2, 3, 4]	    4

fun main() {
    solution16(8, 4, intArrayOf(2, 3, 6))
//    solution16(5, 4, intArrayOf(1, 3))
//    solution16(4, 1, intArrayOf(1, 2, 3, 4))
}

//공부할것
//toCollection
//LinkedList<Int>()
//LinkedList는 삽입삭제가 빈번하거나 순회 작업이 주로 발생하는 경우 유용
//중간에 요소를 삭제하거나 삽입하는 경우에 성능이 우수
//ArrayList 데이터 접근이 빈번하고 요소의 순서가 중요한 경우에 데이터의 추가 조회 작업이 주로 발생하는 경우에 성능이 우수
//크기가 고정되어 있거나 크기 변경이 빈번하지 않을경우에 적합합니다.
fun solution16(n: Int, m: Int, section: IntArray): Int {
    val queue = LinkedList<Int>()
    var answer = 0
    section.toCollection(queue)
    var currentPoint = Int.MIN_VALUE

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        if (currentPoint + m - 1 < node) {
            answer++
            currentPoint = node
        }
    }

    return answer
}

//다른사람 풀이
fun otherSolution17(n: Int, m: Int, section: IntArray): Int {
    var answer: Int = 0
    var dq1 = ArrayDeque<Int>()
    var dq2 = ArrayDeque<Int>()
    for(i in section.first() .. n){
        dq1.add(i)
    }
    section.forEach {
        dq2.add(it)
    }

    while(!dq2.isEmpty()){
        while(dq1.peekFirst() != dq2.peekFirst()){
            dq1.poll()
        }
        repeat(m){
            if (dq1.peekFirst() == dq2.peekFirst()){
                dq1.poll()
                dq2.poll()
            } else {
                dq1.poll()
            }
        }
        answer++
    }

    return answer
}
