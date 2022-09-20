package ranggacikal.co.id.research

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ScaleGestureDetector
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import ranggacikal.co.id.research.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getImageList()
        viewPagerAdapter = ViewPagerAdapter(this, viewModel.imageList)
        binding.vpResearch.adapter = viewPagerAdapter
        binding.btnNext.setOnClickListener {
            binding.vpResearch.setCurrentItem(getItem(+1), true)
        }
        binding.btnPrevious.setOnClickListener {
            binding.vpResearch.setCurrentItem(getItem(-1), true)
        }
    }

    private fun getItem(i: Int): Int {
        return binding.vpResearch.currentItem + i
    }
}