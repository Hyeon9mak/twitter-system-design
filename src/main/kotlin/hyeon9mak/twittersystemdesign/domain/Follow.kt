package hyeon9mak.twittersystemdesign.domain

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "follow")
@Entity
class Follow(
    followerId: Long,
    followeeId: Long,
) {
    @EmbeddedId
    val id: FollowId = FollowId(followerId = followerId, followeeId = followeeId)

    fun getFollowerId(): Long = id.followerId

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Follow

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
