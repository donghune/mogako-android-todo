package com.nanum.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namu.domain.PostWriteUsecase
import com.namu.domain.usecase.SharedUseCase
import com.nanum.presentation.base.BaseViewModel
import com.nanum.presentation.base.SingleLiveEvent
import com.nanum.presentation.base.isNotOrEmpty
import com.nanum.presentation.mapper.mapTo
import com.nanum.presentation.model.PresentPostModel
import com.nanum.presentation.utils.SHARED_TAG_USERNAME
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.joda.time.DateTime
import java.lang.Exception

class PostWriteViewModelImpl @ViewModelInject constructor(
    private val usecase: PostWriteUsecase,
    private val nickNameUsecase: SharedUseCase
) : BaseViewModel(), InputTextChaneListener, PostWriteViewModel {


    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    private val _contents = MutableLiveData<String>()
    val contents: LiveData<String>
        get() = _contents


    private val _postRegistResult = SingleLiveEvent<PresentPostModel>()
    val postRegistResult: LiveData<PresentPostModel>
        get() = _postRegistResult


    private val dateTime: DateTime by lazy {
        DateTime.now()
    }

    fun setContents(msg: String?) {
        msg?.let {
            _contents.value = it
        }
    }

    fun setTitle(msg: String) {
        msg?.let {
            _title.value = it
        }
    }

    override fun setPostRegistResult(item: PresentPostModel?) {
        item?.let {
            _postRegistResult.value = item
        }
    }


    override fun onChange(type: ChangeType, data: String) {
        when (type) {
            ChangeType.POST_WRITE_TITLE -> {
                setTitle(data)
            }
            ChangeType.POST_WRITE_CONTENTS -> {
                setContents(data)
            }
            else -> {

            }
        }

    }

    override fun onClickRegistBtn() {
        var item: PresentPostModel? = null
        this(
            checkValueNotOrEmptyAndCreateModel()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map {
                    item = it
                    it.mapTo()
                }
                .flatMap {
                    usecase.savePost(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        setMsgForShow("${it}행 삽입 성공")
                        setPostRegistResult(item)
                        setInitVariable()

                    },
                    onError = {
                        setMsgForShow(it.localizedMessage)
                    }
                )
        )
    }

    override fun checkValueNotOrEmptyAndCreateModel(): Single<PresentPostModel> {

        val title = title.value
        val contenst = contents.value
        val registedDate = createCurrentRegistDate()
        val modifyDated = createCurrentRegistDate()
        val author = "익명 사용자"
        try {
            isNotOrEmpty(title, contenst, registedDate, modifyDated, author)
            return Single.just(
                createPresentPostModel(
                    title!!,
                    contenst!!,
                    registedDate,
                    modifyDated,
                    author
                )
            )
                .map { model ->
                    nickNameUsecase.getUserNickName(SHARED_TAG_USERNAME)
                        .subscribe { model.author = it }
                    model
                }
        } catch (e: Exception) {
            setMsgForShow(e.localizedMessage)
        }
        return Single.just(null)
    }


    override fun createPresentPostModel(
        title: String, contents: String,
        registedDate: String, updatedDate: String, author: String
    ): PresentPostModel {
        return PresentPostModel(
            title = title,
            contents = contents,
            registDate = registedDate,
            modifyDate = updatedDate,
            author = author,
        )
    }

    override fun createCurrentRegistDate(): String {
        return dateTime.toString("yyyy-MM-dd hh:mm:ss")

    }

    override fun setInitVariable() {
        _title.value=""
        _contents.value=""
    }
}

interface PostWriteViewModel {
    fun onClickRegistBtn()
    fun checkValueNotOrEmptyAndCreateModel(): Single<PresentPostModel>
    fun createPresentPostModel(
        title: String, contents: String,
        registedDate: String, updatedDate: String, author: String,
    ): PresentPostModel

    fun createCurrentRegistDate(): String
    fun setPostRegistResult(item: PresentPostModel?)
    fun setInitVariable()
}

