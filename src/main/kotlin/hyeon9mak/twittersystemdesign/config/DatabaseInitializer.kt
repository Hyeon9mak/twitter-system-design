package hyeon9mak.twittersystemdesign.config

import hyeon9mak.twittersystemdesign.service.FollowService
import hyeon9mak.twittersystemdesign.service.TweetService
import hyeon9mak.twittersystemdesign.service.UserService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@Component
class DatabaseInitializer(
    private val userService: UserService,
    private val followService: FollowService,
    private val tweetService: TweetService,
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        register13000users()
        tweet99Users()
        initUser1()
        initUser2()
        initObama()
    }

    private fun register13000users() {
        for (i: Long in 1L..13_000L) {
            userService.registerUser(id = i, username = "user$i", profilePic = "user$i.png")
        }
    }

    private fun tweet99Users() {
        for (i: Long in 2L..100L) {
            tweetService.postTweet(senderId = i, text = "user$i's first tweet")
            tweetService.postTweet(senderId = i, text = "user$i's second tweet")
            tweetService.postTweet(senderId = i, text = "user$i's third tweet")
        }
    }

    private fun initUser1() {
        for (i: Long in 2L..100L) {
            followService.follow(followerId = 1L, followeeId = i)
        }
    }

    private fun initUser2() {
        followService.follow(followerId = 2L, followeeId = 3L)
    }

    private fun initObama() {
        userService.registerUser(id = 13_001L, username = "obama", profilePic = "obama.png")
        tweetService.postTweet(senderId = 13_001L, text = "obama's first tweet")

        for (i: Long in 1L..13_000L) {
            followService.follow(followerId = i, followeeId = 13_001L)
        }
    }
}
