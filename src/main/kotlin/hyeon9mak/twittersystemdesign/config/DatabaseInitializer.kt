package hyeon9mak.twittersystemdesign.config

import hyeon9mak.twittersystemdesign.domain.Follow
import hyeon9mak.twittersystemdesign.domain.FollowRepository
import hyeon9mak.twittersystemdesign.service.TweetService
import hyeon9mak.twittersystemdesign.service.UserService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@Component
class DatabaseInitializer(
    private val userService: UserService,
    private val followRepository: FollowRepository,
    private val tweetService: TweetService,
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        initUser1()
        initObama()
    }

    private fun initUser1() {
        userService.registerUser(id = 1L, username = "user1", profilePic = "user1.png")
        for (i: Long in 2L..100L) {
            userService.registerUser(id = i, username = "user$i", profilePic = "user$i.png")
            followRepository.save(Follow(followerId = 1L, followeeId = i))
            tweetService.postTweet(senderId = i, text = "user$i's first tweet")
            tweetService.postTweet(senderId = i, text = "user$i's second tweet")
            tweetService.postTweet(senderId = i, text = "user$i's third tweet")
        }
    }

    private fun initObama() {
        userService.registerUser(id = 101L, username = "obama", profilePic = "obama.png")
        for (i: Long in 102L..13_102L) {
            userService.registerUser(id = i, username = "user$i", profilePic = "user$i.png")
            followRepository.save(Follow(followerId = i, followeeId = 101L))
        }
    }
}
