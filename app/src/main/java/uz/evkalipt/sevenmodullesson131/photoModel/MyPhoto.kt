package uz.evkalipt.sevenmodullesson131.photoModel

data class MyPhoto(
    var alt_description: String,
    var blur_hash: String,
    var categories: List<Any>,
    var color: String,
    var created_at: String,
    var current_user_collections: List<Any>,
    var description: Any,
    var downloads: Int,
    var exif: Exif,
    var height: Int,
    var id: String,
    var liked_by_user: Boolean,
    var likes: Int,
    var links: Links,
    var location: Location,
    var promoted_at: String,
    var sponsorship: Any,
    var topic_submissions: TopicSubmissions,
    var updated_at: String,
    var urls: Urls,
    var user: User,
    var views: Int,
    var width: Int
)