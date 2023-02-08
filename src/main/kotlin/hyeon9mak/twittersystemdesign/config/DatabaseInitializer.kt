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
        register100users()
        initUserA()
        initUserB()
        initObama()
        tweet100Users()
        initUserC()
        initUserD()
    }

    private fun register100users() {
        for (i: Long in 1L..100L) {
            userService.registerUser(id = i, username = "user$i", profilePic = "user$i.png")
        }
    }

    private fun initUserA() {
        userService.registerUser(id = 101L, username = "userA", profilePic = "userA.png")
        for (i: Long in 1L..100L) {
            followService.follow(followerId = 101L, followeeId = i)
        }
    }

    private fun initUserB() {
        userService.registerUser(id = 102L, username = "userB", profilePic = "userB.png")
        followService.follow(followerId = 102L, followeeId = 1L)
    }

    private fun initObama() {
        userService.registerUser(id = 103L, username = "obama", profilePic = "obama.png")
        for (i: Long in 1L..102L) {
            followService.follow(followerId = i, followeeId = 103L)
        }
    }

    private fun tweet100Users() {
        for (i: Long in 1L..100L) {
            tweetService.postTweet(senderId = i, text = "user$i's tweet")
        }
    }

    private fun initUserC() {
        userService.registerUser(id = 104L, username = "userC", profilePic = "userC.png")
        followService.follow(followerId = 104L, followeeId = 103L)
    }

    private fun initUserD() {
        userService.registerUser(id = 105L, username = "userD", profilePic = "userD.png")
        followService.follow(followerId = 105L, followeeId = 103L)
    }
}
