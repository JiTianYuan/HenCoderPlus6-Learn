package com.example.lesson

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toolbar

import com.example.core.BaseView
import com.example.lesson.entity.Lesson
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.core.utils.CacheUtils
import kotlin.reflect.KProperty

class LessonActivity : AppCompatActivity(), BaseView<LessonPresenter>, Toolbar.OnMenuItemClickListener {

    private val lessonAdapter = LessonAdapter()

    private lateinit var refreshLayout: SwipeRefreshLayout

    //委托对象 lazy 的作用：1、只创建一次对象 2、懒加载
    override val presenter: LessonPresenter by lazy {
        LessonPresenter(this)
    }


    //将token属性的set和get操作委托给saver对象
    var token: String by Saver("token")

    class Saver constructor(var key: String) {
        operator fun getValue(lessonActivity: LessonActivity, property: KProperty<*>): String {
            return CacheUtils.get(key)!!
        }

        operator fun setValue(lessonActivity: LessonActivity, property: KProperty<*>, value: String) {
            CacheUtils.save(key, value)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_lesson)
        toolbar.setOnMenuItemClickListener(this)

        findViewById<RecyclerView>(R.id.list).run {
            layoutManager = LinearLayoutManager(this@LessonActivity)
            adapter = lessonAdapter
            addItemDecoration(DividerItemDecoration(this@LessonActivity, LinearLayout.VERTICAL))
        }

        findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout).run {
            refreshLayout = this
            setOnRefreshListener { presenter.fetchData() }
            isRefreshing = true
        }
        presenter.fetchData()
    }

    internal fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout.isRefreshing = false
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        presenter.showPlayback()
        return false
    }
}
