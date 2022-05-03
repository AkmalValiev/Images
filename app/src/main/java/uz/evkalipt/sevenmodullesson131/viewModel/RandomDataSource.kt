package uz.evkalipt.sevenmodullesson131.viewModel

import androidx.paging.PagingSource
import androidx.paging.PagingState
import uz.evkalipt.sevenmodullesson131.photoModel.MyPhoto
import uz.evkalipt.sevenmodullesson131.retrofit.ApiService

class RandomDataSource(private val apiService: ApiService):PagingSource<Int, MyPhoto>() {
    override fun getRefreshKey(state: PagingState<Int, MyPhoto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MyPhoto> {
        return try {
            val nextPageNumber = params.key ?:1
            val randomPhotos = apiService.getRandomPhotos("GbhyRrDD7A_AIOe4p79_Z07X5OWETiWva9BkgMaUXrc", nextPageNumber)
            LoadResult.Page(randomPhotos, null, nextPageNumber+1)
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}