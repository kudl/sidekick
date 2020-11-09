package com.example.sidekick.akotlin

import kotlin.properties.Delegates

fun main() {
    birdPrintln()
    orderPrintln()
    userPrintln()
    userObservablePrintln()
}

fun birdPrintln() {
    val bird = Bird("bird", 2, "short", "blue")
    bird.fly()
    Bird.work()
}

fun orderPrintln() {
    val order = Order(3)
    order.reservation()
    order.selling()
    order.price()
}

fun userPrintln() {
    val user = User(1, "Dam", 20)
    val name = user.name
    user.age = 30

    println("name : $name, age : ${user.age}")
}

fun userObservablePrintln() {
    val userObservable = UserObservable()
    userObservable.name = "New"
    userObservable.name = "Current"

    userObservable.max = 2
    println(userObservable.max)

    userObservable.max = 1  // Not Working
    println(userObservable.max)
}

class UserObservable {
    var name: String by Delegates.observable("None") {
        property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }

    var max: Int by Delegates.vetoable(0) {
        property, oldValue, newValue ->
        newValue > oldValue
    }
}

class User(val id: Int, var name: String, var age: Int)

class Bird {
    var name: String
    var wing: Int
    var beak: String
    var color: String

    constructor(name: String, wing: Int, beak: String, color: String) {
        this.name = name
        this.wing = wing
        this.beak = beak
        this.color = color
    }

    companion object {
        fun work() {
            println("Go Home..")
        }
    }

    fun fly() = println("Fly wing: ${wing}")
}

open class Base(var count: Int) {
    fun selling() = println("Base Selling $count")
    open fun price() = println("Base Price $count")
}
class Order(count: Int) : Base(count) {
    fun reservation() = println("Order Reservation : $count")
    override fun price() = println("Order Price $count")
}
