package ranggacikal.co.id.research

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var imageList: List<Int> = emptyList()

    fun getImageList(){
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.imagea
        imageList = imageList + R.drawable.imageb
    }
}