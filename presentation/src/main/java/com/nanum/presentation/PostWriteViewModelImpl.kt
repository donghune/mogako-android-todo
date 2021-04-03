package com.nanum.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namu.domain.PostWriteUsecase
import com.nanum.presentation.base.BaseViewModel
import com.nanum.presentation.base.SingleLiveEvent

class PostWriteViewModelImpl @ViewModelInject constructor(
    private val usecase : PostWriteUsecase
) : BaseViewModel(),InputTextChaneListener,PostWriteViewModel {

    val postLiveDataCollection = PostLiveDataCollection()




    override fun onChange(type: ChangeType, data: String) {
        when(type){
            ChangeType.POST_WRITE_TITLE->{
                postLiveDataCollection.setTitle(data)
            }
            ChangeType.POST_WRITE_CONTENTS->{
                postLiveDataCollection.setContents(data)
            }
            else->{

            }
        }

    }

    override fun onClickRegistBtn() {
        postLiveDataCollection.setPostRegistResult(true)
    }


}


interface PostWriteViewModel{
    fun onClickRegistBtn()
}


class PostLiveDataCollection {
    private val _title = MutableLiveData<String>()
    val title : LiveData<String>
    get() = _title

    private val _contents = MutableLiveData<String>()
    val contents : LiveData<String>
    get() = _contents


    private val _postRegistResult = SingleLiveEvent<Boolean>()
    val postRegistResult : LiveData<Boolean>
        get() = _postRegistResult


    fun setTitle(msg:String?){
        msg?.let {
            _title.value=it
        }
    }

    fun setContents(msg:String?){
        msg?.let {
            _contents.value=it
        }
    }

    fun setPostRegistResult(state :Boolean){
        _postRegistResult.value=state
    }

}