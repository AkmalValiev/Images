package uz.evkalipt.sevenmodullesson131.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import uz.evkalipt.sevenmodullesson131.photoModel.MyPhoto
import uz.evkalipt.sevenmodullesson131.photoModel2.MyAllPhotos

interface ApiService {

    @GET("search/photos?")
    suspend fun getPhotos(@Query("page") page:Int, @Query("client_id") client_id:String, @Query("query") query:String, @Query("per_page") per_page:Int):MyAllPhotos

    @GET("photos/random?")
    suspend fun getRandomPhotos(@Query("client_id") client_id: String, @Query("count") count:Int):List<MyPhoto>
}