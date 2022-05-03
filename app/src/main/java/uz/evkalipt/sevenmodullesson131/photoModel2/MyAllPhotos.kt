package uz.evkalipt.sevenmodullesson131.photoModel2

import uz.evkalipt.sevenmodullesson131.photoModel.MyPhoto

data class MyAllPhotos(
    var results: List<MyPhoto>,
    var total: Int,
    var total_pages: Int
)