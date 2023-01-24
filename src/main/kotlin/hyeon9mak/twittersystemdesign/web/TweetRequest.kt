package hyeon9mak.twittersystemdesign.web

data class TweetRequest(
    val senderId: Long,
    val text: String,
)
