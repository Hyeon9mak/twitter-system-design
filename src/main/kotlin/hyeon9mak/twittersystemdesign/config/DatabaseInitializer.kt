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
        register10_000users()
        initObama()
        initUserA()
        initUserB()
        tweet10_000Users()
        obamaTweet()
    }

    private fun register10_000users() {
        for (i: Long in 1L..10_000L) {
            userService.registerUser(id = i, username = "user$i", profilePic = "user$i.png")
        }
    }

    private fun initObama() {
        userService.registerUser(id = 10_001L, username = "obama", profilePic = "obama.png")
        for (i: Long in 1L..10_000L) {
            followService.follow(followerId = i, followeeId = 10_001L)
        }
    }

    private fun initUserA() {
        userService.registerUser(id = 10_002L, username = "userA", profilePic = "userA.png")
        for (i: Long in 1L..10_001L) {
            followService.follow(followerId = 10_002L, followeeId = i)
        }
    }

    private fun initUserB() {
        userService.registerUser(id = 10_003L, username = "userB", profilePic = "userB.png")
        followService.follow(followerId = 10_003L, followeeId = 1L)
        followService.follow(followerId = 10_003L, followeeId = 10_001L)
    }

    private fun tweet10_000Users() {
        for (i: Long in 1L..10_000L) {
            tweetService.postTweet(senderId = i, text = "user$i's tweet")
        }
    }

    private fun obamaTweet() {
        tweetService.postTweet(senderId = 10_001L, text = "obama's tweet")
    }
}
