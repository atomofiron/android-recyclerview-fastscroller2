package lib.atomofiron.recyclerview.fastscroller2

import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat.Type
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView

class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ConcatAdapter(LabelAdapter(), ItemAdapter(), LabelAdapter())
        FastScroller2(
            recyclerView,
            ContextCompat.getDrawable(this, R.drawable.scroll_thumb) as StateListDrawable,
            ContextCompat.getDrawable(this, R.drawable.scroll_track) as Drawable,
            ContextCompat.getDrawable(this, R.drawable.scroll_thumb) as StateListDrawable,
            ContextCompat.getDrawable(this, R.drawable.scroll_track) as Drawable,
            resources.getDimensionPixelSize(R.dimen.fastscroll_thickness),
            resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range),
            resources.getDimensionPixelSize(R.dimen.fastscroll_area),
            resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_size),
            inTheEnd = false,
        )

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { _, insets ->
            val systemBars = insets.getInsets(Type.systemBars() or Type.displayCutout())
            recyclerView.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}