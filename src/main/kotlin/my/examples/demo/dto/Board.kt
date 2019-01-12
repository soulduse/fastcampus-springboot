package my.examples.demo.dto

import java.time.LocalDateTime

data class Board (
        val id: Long = 0L,
        val title: String,
        val name: String,
        val content: String,
        val createDate: LocalDateTime = LocalDateTime.now(),
        val readCount: Int = 0
)
