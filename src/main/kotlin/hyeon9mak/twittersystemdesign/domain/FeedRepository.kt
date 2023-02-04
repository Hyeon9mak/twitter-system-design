package hyeon9mak.twittersystemdesign.domain

interface FeedRepository {

    fun findAllByUserId(userId: Long): List<Feed>
}
