package hyeon9mak.twittersystemdesign.service

import hyeon9mak.twittersystemdesign.domain.User
import hyeon9mak.twittersystemdesign.domain.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun registerUser(id: Long, username: String, profilePic: String): Long {
        val user = userRepository.save(User(id = id, username = username, profilePic = profilePic))
        return user.id
    }
}
