package hyeon9mak.twittersystemdesign.persistence

import hyeon9mak.twittersystemdesign.domain.Feed
import hyeon9mak.twittersystemdesign.domain.FeedRepository
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class FeedRedisRepository(
    private val redisTemplate: RedisTemplate<Long, Feed>,
) : FeedRepository {

    override fun findAllByUserId(userId: Long): List<Feed> =
        redisTemplate.opsForList().range(userId, 0, -1)
            ?: throw IllegalStateException("Redis Connection Error")
}
