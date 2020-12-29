package id.niandev.jikananime.ui

import android.annotation.SuppressLint
import android.util.Log.d
import id.niandev.jikananime.services.JikananimeApi
import id.niandev.jikananime.services.getApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by Azhar Nian on 29/12/20.
 * NIANDEV
 * azharnian@gmail.com
 */

class MainPresenter : MainView.logic{
    private val TAG = this::class.java.simpleName
    private lateinit var view: MainView.View
    private var api: JikananimeApi = getApi().create(JikananimeApi::class.java)

    override fun setupView(view: MainView.View) {
        this.view = view
    }

    @SuppressLint("CheckResult")
    override fun searchAnime(q: String?) {
        view.showProgress()
        api.doSearch(q)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(
                        {
                            view.hideProgress()
                            view.setListAnime(it.results)
                        },
                        { d(TAG, "error: ${it.localizedMessage}") }
                )
    }

}