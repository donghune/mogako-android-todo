package com.namu.todo.bindinAdapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("bind:verticalRecyclerviewAdapter")
fun verticalRecyclerviewAdapter(recyclerView: RecyclerView,adapter:ListAdapter<*,*>?){

    adapter?.let {
        LinearLayoutManager(recyclerView.context).apply {
            orientation=RecyclerView.VERTICAL
            recyclerView.layoutManager=this
            recyclerView.adapter=it
        }
    }
}

@BindingAdapter("bind:horizonRecyclerviewAdapter")
fun horizonRecyclerviewAdapter(recyclerView: RecyclerView,adapter:ListAdapter<*,*>?){

    adapter?.let {
        LinearLayoutManager(recyclerView.context).apply {
            orientation=RecyclerView.HORIZONTAL
            recyclerView.layoutManager=this
            recyclerView.adapter=it
        }
    }
}