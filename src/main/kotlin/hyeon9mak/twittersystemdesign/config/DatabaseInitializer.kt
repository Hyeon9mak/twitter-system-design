package hyeon9mak.twittersystemdesign.config

import hyeon9mak.twittersystemdesign.domain.Follow
import hyeon9mak.twittersystemdesign.domain.FollowRepository
import hyeon9mak.twittersystemdesign.domain.Tweet
import hyeon9mak.twittersystemdesign.domain.TweetRepository
import hyeon9mak.twittersystemdesign.domain.User
import hyeon9mak.twittersystemdesign.domain.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@Component
class DatabaseInitializer(
    private val userRepository: UserRepository,
    private val followRepository: FollowRepository,
    private val tweetRepository: TweetRepository,
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        cleanUp()
        initialize()
    }

    private fun cleanUp() {
        tweetRepository.deleteAllInBatch()
        followRepository.deleteAllInBatch()
        userRepository.deleteAllInBatch()
    }

    private fun initialize() {
        val 최현구 = userRepository.save(User(username = "최현구", profilePic = "최현구.png"))
        val 홍길동 = userRepository.save(User(username = "홍길동", profilePic = "홍길동.png"))
        val 김태희 = userRepository.save(User(username = "김태희", profilePic = "김태희.png"))

        followRepository.save(Follow(followerId = 최현구.id, followeeId = 홍길동.id))
        followRepository.save(Follow(followerId = 최현구.id, followeeId = 김태희.id))

        tweetRepository.save(Tweet(senderId = 홍길동.id, text = "안녕하세요. 길동이입니다."))
        tweetRepository.save(Tweet(senderId = 김태희.id, text = "안녕하세요. 김태희입니다. 깡은 용서가 안되네요."))
    }
}
