package hyeon9mak.twittersystemdesign.service

import hyeon9mak.twittersystemdesign.domain.Tweet
import hyeon9mak.twittersystemdesign.domain.TweetRepository
import hyeon9mak.twittersystemdesign.domain.UserRepository
import hyeon9mak.twittersystemdesign.domain.findUserById
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class TweetService(
    private val userRepository: UserRepository,
    private val tweetRepository: TweetRepository,
) {
    fun postTweet(senderId: Long, text: String): Long {
        val user = userRepository.findUserById(id = senderId)
        val tweet = tweetRepository.save(Tweet(senderId = user.id, text = text))
        return tweet.id
    }
}
