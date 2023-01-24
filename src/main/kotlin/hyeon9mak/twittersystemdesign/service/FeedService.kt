package hyeon9mak.twittersystemdesign.service

import hyeon9mak.twittersystemdesign.domain.Feed
import hyeon9mak.twittersystemdesign.domain.TweetRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class FeedService(
    private val tweetRepository: TweetRepository,
) {
    fun getFeeds(userId: Long): List<Feed> = tweetRepository.findAllFeeds(userId = userId)

    fun getFeed(feedId: Long): Feed = tweetRepository.findFeedById(id = feedId)
}
