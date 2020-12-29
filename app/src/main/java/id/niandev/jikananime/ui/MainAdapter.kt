package id.niandev.jikananime.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.niandev.jikananime.databinding.ItemListAnimeBinding
import id.niandev.jikananime.model.Result


/**
 * Created by Azhar Nian on 29/12/20.
 * NIANDEV
 * azharnian@gmail.com
 */

class MainAdapter(
    private val itemAnime: List<Result>,
    private val mContext: Context,
    private val listener: (Result) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolderAnime>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderAnime {
        val binding = ItemListAnimeBinding.inflate(
            LayoutInflater.from(mContext),
            parent,
            false
        )
        return ViewHolderAnime(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderAnime, position: Int) {
        with(holder){
            with(itemAnime[position]){
                binding.tvTitle.text = title
                Glide.with(mContext).load(image_url).into(binding.imgBeaner)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemAnime.size
    }

    class ViewHolderAnime(val binding: ItemListAnimeBinding) : RecyclerView.ViewHolder(binding.root)
}