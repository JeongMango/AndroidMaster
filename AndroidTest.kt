package com.example.study

fun main() {
    val numbers = listOf(5, 2, 10, 4, 10)
    // val sum = numbers.reduce { sum, element -> sum + element }
    //println(sum)
    //val sumDoubled = numbers.fold(1) { sum, element -> sum + element }

    /*val a = numbers.reduceRight() { a, b -> a + b }
    val sumDoubled = numbers.foldRight(3) { sum, element -> sum + element}*/
    val sumEven = numbers.foldIndexed(1) { idx, sum, element -> if (idx % 2 == 0) sum + element else sum }
    val smEven = numbers.foldIndexed(0) { idx, sum, element -> if (idx % 2 == 0) sum + element else sum }
    println(sumEven)
    println(smEven)



    /* println("a :: ${a}")
     println(sumDoubled)*/



}
