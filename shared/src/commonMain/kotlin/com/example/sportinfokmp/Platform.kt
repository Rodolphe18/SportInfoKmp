package com.example.sportinfokmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform