package hyeon9mak.twittersystemdesign.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import java.lang.IllegalArgumentException

interface UserRepository : JpaRepository<User, Long>

fun UserRepository.findUserById(id: Long): User = findByIdOrNull(id = id)
    ?: throw IllegalArgumentException("User(id=$id) does not exist.")
