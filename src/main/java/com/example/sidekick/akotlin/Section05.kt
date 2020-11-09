package com.example.sidekick.akotlin

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {
    threadPool()
}

fun threadPool() {
    val customService:ExecutorService = Executors.newFixedThreadPool(2)
    var i = 0

    val items = listOf(1,2,3,4,5,6,7,8,9)

    while (i < items.size) {
        val item = items[i]
        customService.submit {
            processItem(item)
        }

        i += 1
    }
}

fun processItem(item: Int) {
    println("processItem ${item}")
}
