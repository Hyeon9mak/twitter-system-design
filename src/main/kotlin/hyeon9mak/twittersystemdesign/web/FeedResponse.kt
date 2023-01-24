package hyeon9mak.twittersystemdesign.web

import hyeon9mak.twittersystemdesign.domain.Feed
import java.time.LocalDateTime

data class FeedResponse(
    val username: String,
    val profilePic: String,
    val text: String,
    val timestamp: LocalDateTime,
) {
    companion object {
        fun from(feed: Feed): FeedResponse = FeedResponse(
            username = feed.username,
            profilePic = feed.profilePic,
            text = feed.text,
            timestamp = feed.timestamp,
        )
    }
}
