package hyeon9mak.twittersystemdesign.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TweetRepository : JpaRepository<Tweet, Long> {

    @Query(
        """
        SELECT new hyeon9mak.twittersystemdesign.domain.Feed(
            u.username,
            u.profilePic,
            t.text,
            t.timestamp
            )
        FROM Tweet t
        JOIN User u ON t.senderId = u.id
        JOIN Follow f ON f.id.followeeId = u.id
        WHERE f.id.followerId = :userId
        ORDER BY t.timestamp DESC
        """
    )
    fun findAllFeeds(userId: Long): List<Feed>

    @Query(
        """
        SELECT new hyeon9mak.twittersystemdesign.domain.Feed(
            u.username,
            u.profilePic,
            t.text,
            t.timestamp
            )
        FROM Tweet t
        JOIN User u ON t.senderId = u.id
        WHERE t.id = :id
        """
    )
    fun findFeedById(id: Long): Feed
}
