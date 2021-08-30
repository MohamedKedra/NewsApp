package com.example.newsapp.ui.main

import android.net.ConnectivityManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.app.BaseViewModel
import com.example.newsapp.data.model.HeadlinesResponse
import com.example.newsapp.data.model.state.LiveDataState
import com.example.newsapp.data.repository.NewsRepository
import com.example.newsapp.utils.EndPoints
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineDispatcher

class MainViewModel(
    private val newsRepository: NewsRepository,
    connectivityManager: ConnectivityManager
) :
    BaseViewModel(connectivityManager) {

    private var newsList = LiveDataState<HeadlinesResponse>()
    private val disposable = CompositeDisposable()

    fun getTopHeadlines(): LiveDataState<HeadlinesResponse> {

        if (!isNetworkAvailable) {
            publishNoInternet(newsList)
            return newsList
        }

        publishLoading(newsList)

        disposable.add(
            newsRepository.getTopHeadlines().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(
                    object : DisposableSingleObserver<HeadlinesResponse>() {
                        override fun onSuccess(it: HeadlinesResponse) {
                            publishResult(newsList, it)
                        }

                        override fun onError(error: Throwable) {
                            publishError(newsList, error)
                        }
                    }
                )
        )

        return newsList
    }
}