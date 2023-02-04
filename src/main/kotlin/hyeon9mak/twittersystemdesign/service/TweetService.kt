package hyeon9mak.twittersystemdesign.service

import hyeon9mak.twittersystemdesign.domain.Feed
import hyeon9mak.twittersystemdesign.domain.FeedRepository
import hyeon9mak.twittersystemdesign.domain.FollowRepository
import hyeon9mak.twittersystemdesign.domain.Tweet
import hyeon9mak.twittersystemdesign.domain.TweetRepository
import hyeon9mak.twittersystemdesign.domain.User
import hyeon9mak.twittersystemdesign.domain.UserRepository
import hyeon9mak.twittersystemdesign.domain.findUserById
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class TweetService(
    private val userRepository: UserRepository,
    private val followRepository: FollowRepository,
    private val tweetRepository: TweetRepository,
    private val feedRepository: FeedRepository,
) {
    fun postTweet(senderId: Long, text: String): Long {
        val user = userRepository.findUserById(id = senderId)
        val tweet = tweetRepository.save(Tweet(senderId = user.id, text = text))
        pushToFollowersFeed(user = user, tweet = tweet)
        return tweet.id
    }

    private fun pushToFollowersFeed(user: User, tweet: Tweet) {
        val feed = Feed(
            username = user.username,
            profilePic = user.profilePic,
            text = tweet.text,
            timestamp = tweet.timestamp,
        )

        followRepository.findAllByFolloweeId(followeeId = user.id)
            .map { it.getFollowerId() }
            .forEach { followerId -> feedRepository.leftPushFeed(userId = followerId, feed = feed) }
    }
}
