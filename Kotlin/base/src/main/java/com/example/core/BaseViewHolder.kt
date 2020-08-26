package com.example.core

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**
 * @author jty
 * @date 2020-08-25
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val viewHashMap: MutableMap<Int, View?> = HashMap()

    protected fun <T : View> getView(@IdRes id: Int): T? {
        var view: View? = viewHashMap.get(id)
        if (view == null) {
            view = itemView.findViewById(id);
            viewHashMap.put(id, view)
        }
        return view as T?
    }

    protected fun setText(@IdRes id: Int, text: String?) {
        (getView<View>(id) as TextView).text = text
    }

}