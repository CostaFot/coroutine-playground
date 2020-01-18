package com.feelsokman.coroutineplayground.extensions

fun String.onlyDigits(): String = replace(Regex("\\D*"), "")

fun String.removeAllSpecialCharacters(): String = replace("[^a-zA-Z]+".toRegex(), "")
