package hyeon9mak.twittersystemdesign.web

import hyeon9mak.twittersystemdesign.service.FeedService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/feeds")
@RestController
class FeedController(
    private val feedUseCase: FeedService,
) {
    @GetMapping
    fun getFeeds(@RequestParam(name = "user-id") userId: Long): ResponseEntity<List<FeedResponse>> {
        val feeds = feedUseCase.getFeeds(userId = userId)
        val responses = feeds.map { FeedResponse.from(feed = it) }
        return ResponseEntity.ok(responses)
    }

    @GetMapping("/{id}")
    fun getFeed(@PathVariable id: Long): ResponseEntity<FeedResponse> {
        val feed = feedUseCase.getFeed(feedId = id)
        val response = FeedResponse.from(feed = feed)
        return ResponseEntity.ok(response)
    }
}
