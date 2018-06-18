package cubex.mahesh.gallerytest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Gallery

class MainActivity : AppCompatActivity() {
        var gal: Gallery? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gal = findViewById(R.id.gal1)
        gal?.adapter = MyAdapter(this)
    }
}
