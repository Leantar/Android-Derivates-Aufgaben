package com.example.basictv

import java.util.Timer

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.leanback.app.BackgroundManager
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.OnItemViewSelectedListener
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.Row
import androidx.leanback.widget.RowPresenter
import androidx.core.content.ContextCompat
import android.util.DisplayMetrics
import android.widget.Toast

import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition

/**
 * Loads a grid of cards with movies to browse.
 */
class MainFragment : BrowseSupportFragment() {

    private lateinit var mBackgroundManager: BackgroundManager
    private var mDefaultBackground: Drawable? = null
    private lateinit var mMetrics: DisplayMetrics
    private var mBackgroundTimer: Timer? = null
    private var mBackgroundUri: Int = 0

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        prepareBackgroundManager()
        setupUIElements()
        loadRows()
        setupEventListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        mBackgroundTimer?.cancel()
    }

    private fun prepareBackgroundManager() {
        mBackgroundManager = BackgroundManager.getInstance(activity)
        mBackgroundManager.attach(activity!!.window)
        mDefaultBackground = ContextCompat.getDrawable(activity!!, R.drawable.default_background)
        mMetrics = DisplayMetrics()
        activity!!.windowManager.defaultDisplay.getMetrics(mMetrics)
    }

    private fun setupUIElements() {
        title = "Mobile Engineering"
        headersState = BrowseSupportFragment.HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true
        brandColor = ContextCompat.getColor(activity!!, R.color.gray)
        searchAffordanceColor = ContextCompat.getColor(activity!!, R.color.selected_background)
    }

    private fun loadRows() {
        val list = MovieList.list

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        val cardPresenter = CardPresenter()
        var incrementer = 0
        for (i in 0 until NUM_ROWS) {
            val listRowAdapter = ArrayObjectAdapter(cardPresenter)
            for (j in 0 until NUM_COLS) {

                listRowAdapter.add(list[incrementer])
                incrementer++
            }
            val header = HeaderItem(i.toLong(), MovieList.MOVIE_CATEGORY[i])
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }
        adapter = rowsAdapter
    }

    private fun setupEventListeners() {
        setOnSearchClickedListener {
            Toast.makeText(activity!!, "Nich Implementiert", Toast.LENGTH_LONG)
                .show()
        }
        onItemViewClickedListener = ItemViewClickedListener()
        onItemViewSelectedListener = ItemViewSelectedListener()
    }

    private inner class ItemViewClickedListener : OnItemViewClickedListener {
        override fun onItemClicked(
            itemViewHolder: Presenter.ViewHolder,
            item: Any,
            rowViewHolder: RowPresenter.ViewHolder,
            row: Row
        ) {
            if (item is Movie) {
                Toast.makeText(activity!!, "Nicht Implementiert", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private inner class ItemViewSelectedListener : OnItemViewSelectedListener {
        override fun onItemSelected(
            itemViewHolder: Presenter.ViewHolder?, item: Any?,
            rowViewHolder: RowPresenter.ViewHolder, row: Row
        ) {
            if (item is Movie) {
                mBackgroundUri = item.backgroundImg
                updateBackground(item.backgroundImg)
            }
        }
    }

    private fun updateBackground(image: Int?) {
        val width = mMetrics.widthPixels
        val height = mMetrics.heightPixels
        Glide.with(activity!!)
            .load(image)
            .centerCrop()
            .error(mDefaultBackground)
            .into<SimpleTarget<Drawable>>(
                object : SimpleTarget<Drawable>(width, height) {
                    override fun onResourceReady(
                        drawable: Drawable,
                        transition: Transition<in Drawable>?
                    ) {
                        mBackgroundManager.drawable = drawable
                    }
                })
        mBackgroundTimer?.cancel()
    }




    companion object {
        private val TAG = "MainFragment"
        private val NUM_ROWS = 2
        private val NUM_COLS = 2
    }
}