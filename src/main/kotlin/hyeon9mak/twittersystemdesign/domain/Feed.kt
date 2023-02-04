package hyeon9mak.twittersystemdesign.domain

import java.io.Serializable
import java.time.LocalDateTime

data class Feed(
    val username: String,
    val profilePic: String,
    val text: String,
    val timestamp: LocalDateTime,
) : Serializable
