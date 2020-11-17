package com.kudl.sidekick.akotlin

import java.lang.Integer.sum

fun main() {
    sumary()
    funcPrint()
    lambdaEx()
    highOrderPrint()
}

fun highOrderPrint() {
    var result: Int
    result = highOrder({ x, y -> x + y }, 10, 20)
    println(result)
}

fun highOrder(sum: (Int,Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}

fun lambdaEx() {
    val square = { x: Int -> x * x }
    println(square)
}

fun funcPrint() {
    println("funcFunc : ${funcFunc()}")
}

fun funcFunc(): Int {
    return sum(2, 2)
}

fun sumary() {
    var res1 = sum(3,2)

    println(res1)
}
