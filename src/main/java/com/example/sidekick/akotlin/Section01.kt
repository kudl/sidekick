package com.example.sidekick.akotlin

import com.example.sidekick.akotlin.vo.Person
import kotlin.math.PI
import kotlin.math.abs

import com.example.sidekick.akotlin.vo.Person as User

fun main() {
    hello()
    mathSample()
    getPerson()
    forEach()
    chFromCode()
    nullAble()
    safeCall()
    smartCast()
}

fun smartCast() {
    // Float
    var test: Number = 12.2
    println("$test")

    // Int
    test = 12
    println("$test")

    // Long
    test = 120L
    println("$test")

    // Float
    test += 12.0f
    println("$test")

    var a: Any = 1
    a = 20L

    println("a: $a type: ${a.javaClass}")
}

fun safeCall() {
    var str1: String? = "Hello"
    str1 = null

    println("safeCall: $str1 length: ${str1?.length ?: -1}")
}

fun nullAble() {
    var str1: String? = "Hello"
    str1 = null

    println(str1)
}

fun chFromCode() {
    val code: Int = 65
    val chFromCode: Char = code.toChar()

    println(chFromCode)
}

fun forEach() {
    var num: Double = 0.1

    for (i in 0..10) {
        num += 0.1
    }

    println(num)
}

fun getPerson() {
    val user1 = Person("idAA", "NameAA")
    val user2 = User("idBB", "NameBB")

    println(user1)
    println(user1.id)
    println(user1.name)

    println(user2)
    println(user2.id)
    println(user2.name)
}

fun hello() {
    var intro: String = "Hi!!"
    var num: Int = 20

    println("intro: $intro, num: $num")
}

fun mathSample() {
    println(PI)
    println(abs(-12.5))
}

