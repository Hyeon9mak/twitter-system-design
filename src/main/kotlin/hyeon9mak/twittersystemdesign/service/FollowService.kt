package hyeon9mak.twittersystemdesign.service

import hyeon9mak.twittersystemdesign.domain.Follow
import hyeon9mak.twittersystemdesign.domain.FollowRepository
import hyeon9mak.twittersystemdesign.domain.UserRepository
import hyeon9mak.twittersystemdesign.domain.findUserById
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class FollowService(
    private val followRepository: FollowRepository,
    private val userRepository: UserRepository,
) {
    fun follow(followerId: Long, followeeId: Long) {
        followRepository.save(Follow(followerId = followerId, followeeId = followeeId))
        if (followRepository.countByFolloweeId(followeeId = followeeId) == INFLUENCER_COUNT) {
            val user = userRepository.findUserById(id = followeeId)
            user.becomeInfluencer()
            userRepository.save(user)
        }
    }

    companion object {
        private const val INFLUENCER_COUNT = 10_000L
    }
}
