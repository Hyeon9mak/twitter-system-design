package hyeon9mak.twittersystemdesign.web

import hyeon9mak.twittersystemdesign.service.TweetService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RequestMapping("/api/v1/tweets")
@RestController
class TweetController(
    private val tweetUseCase: TweetService,
) {
    @PostMapping
    fun postTweet(@RequestBody request: TweetRequest): ResponseEntity<Void> {
        val tweetId = tweetUseCase.postTweet(
            senderId = request.senderId,
            text = request.text,
        )
        return ResponseEntity.created(URI.create("/api/v1/feeds/$tweetId")).build()
    }
}
