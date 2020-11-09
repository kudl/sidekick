package com.example.sidekick.akotlin

fun main() {
    sealedPrintln()
    interfacePrintln()
}

fun interfacePrintln() {
    println(MemberType.GOLD.getScore())
    println(MemberType.NORMAL.prio)
    println(MemberType.valueOf("NORMAL"))
}

interface Score {
    fun getScore(): Int
}

enum class MemberType(var prio: String) : Score {
    NORMAL("Normal") {
        override fun getScore(): Int = 100
    },
    GOLD("Gole") {
        override fun getScore(): Int = 200
    }
}

fun sealedPrintln() {
    println(eval(Result.Success("Success Message")))
    println(eval(Result.Error(500, "Error Message")))
}

fun eval(result: Result): String = when(result) {
    is Result.Status -> "in progress"
    is Result.Success -> result.message
    is Result.Error -> result.message
}

sealed class Result {
    open class Success(val message: String): Result()
    class Error(val code: Int, val message: String): Result()
    class Status: Result()
}
