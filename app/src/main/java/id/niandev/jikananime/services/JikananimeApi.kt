package id.niandev.jikananime.services

import id.niandev.jikananime.model.ResultJikan
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Azhar Nian on 29/12/20.
 * NIANDEV
 * azharnian@gmail.com
 */

interface JikananimeApi {
    @GET("/v3/search/anime")
    fun doSearch(
        @Query("q") q: String?
    ): Single<ResultJikan>
}