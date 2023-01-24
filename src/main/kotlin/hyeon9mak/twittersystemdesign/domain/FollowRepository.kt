package hyeon9mak.twittersystemdesign.domain

import org.springframework.data.jpa.repository.JpaRepository

interface FollowRepository : JpaRepository<Follow, FollowId>
