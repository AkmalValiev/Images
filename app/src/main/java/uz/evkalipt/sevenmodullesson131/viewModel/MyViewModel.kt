package uz.evkalipt.sevenmodullesson131.viewModel

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import uz.evkalipt.sevenmodullesson131.photoModel.MyPhoto
import uz.evkalipt.sevenmodullesson131.retrofit.ApiClient

class MyViewModel: ViewModel() {

    fun getPhotos(page:Int, query: String): LiveData<PagingData<MyPhoto>> {

        return Pager(PagingConfig(pageSize = 2)) {
            PhotoDataSource(ApiClient.apiService, page, query)
        }.flow.cachedIn(viewModelScope).asLiveData()
    }

    fun getRandomPhotos():LiveData<PagingData<MyPhoto>>{

        return Pager(PagingConfig(pageSize = 1)){
            RandomDataSource(ApiClient.apiService)
        }.flow.cachedIn(viewModelScope).asLiveData()

    }

}