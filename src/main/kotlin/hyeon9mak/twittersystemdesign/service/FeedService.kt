package hyeon9mak.twittersystemdesign.service

import hyeon9mak.twittersystemdesign.domain.Feed
import hyeon9mak.twittersystemdesign.domain.FeedRepository
import hyeon9mak.twittersystemdesign.domain.TweetRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * http://redisgate.kr/redis/command/lists.php
 */
@Transactional(readOnly = true)
@Service
class FeedService(
    private val feedRepository: FeedRepository,
    private val tweetRepository: TweetRepository,
) {
    fun getFeeds(userId: Long): List<Feed> {
        val cachedFeeds = feedRepository.findAllByUserId(userId = userId)
        val influencerFeeds = tweetRepository.findInfluencerTweetsByFollowerId(followerId = userId)
        return cachedFeeds + influencerFeeds
    }

    fun getFeed(feedId: Long): Feed = tweetRepository.findFeedById(id = feedId)
}