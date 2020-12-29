package id.niandev.jikananime.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.niandev.jikananime.databinding.ActivityMainBinding
import id.niandev.jikananime.extentions.gone
import id.niandev.jikananime.extentions.visible
import id.niandev.jikananime.model.Result

class MainActivity : AppCompatActivity(), MainView.View {

    private val TAG = this::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter
    private var listAnime: MutableList<Result> = mutableListOf()
    private lateinit var adapterAnime:MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        presenter = MainPresenter()
        presenter.setupView(this)

        val mLayoutManager = LinearLayoutManager(this)
        adapterAnime = MainAdapter(listAnime,this){
            Toast.makeText(this@MainActivity, it.title, Toast.LENGTH_SHORT).show()
        }

        binding.rvAnime.apply {
            this.layoutManager = mLayoutManager
            this.setHasFixedSize(true)
            this.adapter = adapterAnime
        }


        presenter.searchAnime("boruto")
    }

    override fun setListAnime(resultlistAnime: List<Result>) {
        binding.apply {
            rvAnime.visible()
        }
        listAnime.clear()
        listAnime.addAll(resultlistAnime)

        adapterAnime.notifyDataSetChanged()
    }

    override fun showProgress() {
        binding.apply {
            this.rvAnime.gone()
            this.viewLoading.visible()
        }
    }

    override fun hideProgress() {
        binding.apply {
            this.rvAnime.visible()
            this.viewLoading.gone()
        }
    }
}