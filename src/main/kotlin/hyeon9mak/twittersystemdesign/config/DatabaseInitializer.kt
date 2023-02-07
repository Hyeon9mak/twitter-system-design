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
        register100users()
        initUserA()
        initUserB()
        initObama()
        tweet100Users()
    }

    private fun register100users() {
        for (i: Long in 1L..100L) {
            userService.registerUser(id = i, username = "user$i", profilePic = "user$i.png")
        }
    }

    private fun initUserA() {
        userService.registerUser(id = 101L, username = "userA", profilePic = "userA.png")
        for (i: Long in 1L..100L) {
            followRepository.save(Follow(followerId = 101L, followeeId = i))
        }
    }

    private fun initUserB() {
        userService.registerUser(id = 102L, username = "userB", profilePic = "userB.png")
        followRepository.save(Follow(followerId = 102L, followeeId = 1L))
    }

    private fun initObama() {
        userService.registerUser(id = 103L, username = "obama", profilePic = "obama.png")
        for (i: Long in 1L..102L) {
            followRepository.save(Follow(followerId = i, followeeId = 103L))
        }
    }

    private fun tweet100Users() {
        for (i: Long in 1L..100L) {
            tweetService.postTweet(senderId = i, text = "user$i's tweet")
        }
    }
}
