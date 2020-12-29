package id.niandev.jikananime.ui

import id.niandev.jikananime.extentions.BaseView
import id.niandev.jikananime.model.Result


/**
 * Created by Azhar Nian on 29/12/20.
 * NIANDEV
 * azharnian@gmail.com
 */

interface MainView {
    interface View: BaseView.progressView {
        fun setListAnime(listAnime: List<Result>)
    }

    interface logic{
        fun setupView(view: View)
        fun searchAnime(q: String?)
    }
}