package hyeon9mak.twittersystemdesign.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FollowRepository : JpaRepository<Follow, FollowId> {

    @Query("SELECT f FROM Follow f WHERE f.id.followeeId = :followeeId")
    fun findAllByFolloweeId(followeeId: Long): List<Follow>

    @Query("SELECT COUNT(f) FROM Follow f WHERE f.id.followeeId = :followeeId")
    fun countByFolloweeId(followeeId: Long): Long
}
