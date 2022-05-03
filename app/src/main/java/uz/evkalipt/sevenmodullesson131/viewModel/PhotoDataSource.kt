package uz.evkalipt.sevenmodullesson131.viewModel

import androidx.paging.PagingSource
import androidx.paging.PagingState
import uz.evkalipt.sevenmodullesson131.photoModel.MyPhoto
import uz.evkalipt.sevenmodullesson131.retrofit.ApiService
import java.lang.Exception

class PhotoDataSource(private val apiService: ApiService, var page:Int, var query:String): PagingSource<Int, MyPhoto>() {
    override fun getRefreshKey(state: PagingState<Int, MyPhoto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MyPhoto> {
        return try {
            val nextPageNumber = params.key?:1
            val myAllPhotos = apiService.getPhotos(page,"GbhyRrDD7A_AIOe4p79_Z07X5OWETiWva9BkgMaUXrc", query, nextPageNumber)
            LoadResult.Page(myAllPhotos.results, null, nextPageNumber+1)
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}