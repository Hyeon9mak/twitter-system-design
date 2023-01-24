package hyeon9mak.twittersystemdesign.domain

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class FollowId(
    @Column(name = "follower_id", nullable = false) val followerId: Long,
    @Column(name = "followee_id", nullable = false) val followeeId: Long,
) : Serializable {
    companion object {
        private const val serialVersionUID = -6406675375664375750L
    }
}
