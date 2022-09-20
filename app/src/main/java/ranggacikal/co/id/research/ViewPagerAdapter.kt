package ranggacikal.co.id.research

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ScaleGestureDetector
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import java.lang.Float.max
import java.lang.Float.min
import java.util.*

class ViewPagerAdapter(
    val context: Context,
    val imageList: List<Int>,
    val onItemClickListener: List<Int>
) : PagerAdapter() {

    private var scaleGestureDetector: ScaleGestureDetector? = null
    private var scaleFactor = 1.0f
    private var imageView: ImageView? = null

    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj as ConstraintLayout
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView: View = mLayoutInflater.inflate(R.layout.item_view_pager, container, false)
        imageView = itemView.findViewById<View>(R.id.iv_item_view_pager) as ImageView
        imageView!!.setImageResource(imageList[position])
        imageView!!.setOnClickListener {

        }
        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, objDestroy: Any) {
        container.removeView(objDestroy as ConstraintLayout)
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            scaleFactor *= scaleGestureDetector.scaleFactor
            scaleFactor = max(0.1f, min(scaleFactor, 10.0f))
            imageView?.scaleX = scaleFactor
            imageView?.scaleY = scaleFactor
            return true
        }
    }
}