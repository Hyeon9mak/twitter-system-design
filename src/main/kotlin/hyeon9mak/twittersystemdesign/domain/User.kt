package hyeon9mak.twittersystemdesign.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "user")
@Entity
class User(
    id: Long,
    username: String,
    profilePic: String,
    influencer: Boolean = false,
) {
    @Id
    val id: Long = id

    @Column(name = "username", nullable = false)
    var username: String = username
        protected set

    @Column(name = "profile_pic", nullable = false)
    var profilePic: String = profilePic
        protected set

    @Column(nullable = false)
    var influencer: Boolean = influencer
        protected set

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
