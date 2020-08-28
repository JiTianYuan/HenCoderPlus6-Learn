package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

/**
 * @author jty
 * @date 2020-08-26
 */
class LessonPresenter {
    companion object {
        private const val LESSON_PATH = "lessons"
    }

    private var activity: LessonActivity

    constructor(activity: LessonActivity) {
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList<Lesson>()

    private val type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity.runOnUiThread(object : Runnable {
                    override fun run() {
                        activity.showResult(lessons)
                    }
                })

            }

            override fun onFailure(message: String?) {
                activity.runOnUiThread { Utils.toast(message!!) }
            }

        })
    }

    fun showPlayback() {
        /*val playbackLessons: MutableList<Lesson> = ArrayList()
        for (lesson in lessons) {
            if (lesson.state === Lesson.State.PLAYBACK) {

            }
        }*/

        //for循环可以这么写
        /* lessons.forEach{
             if (it.state == Lesson.State.PLAYBACK) {
                 playbackLessons.add(it)
             }
         }*/


        activity.showResult(lessons.filter { it.state == Lesson.State.PLAYBACK })
    }


}