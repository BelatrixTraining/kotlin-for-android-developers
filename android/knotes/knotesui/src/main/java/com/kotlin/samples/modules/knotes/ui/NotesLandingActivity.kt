package com.kotlin.samples.modules.knotes.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.modules.kcoresupport.ui.BaseActivity
import com.kotlin.samples.modules.knotes.model.NoteEntity
import com.kotlin.samples.modules.knotes.ui.data.ApiClient
import kotlinx.android.synthetic.main.activity_notes_landing.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotesLandingActivity : BaseActivity() {

    private var currentCall:Call<List<NoteEntity>>?=null
    private var notes:List<NoteEntity> =  emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_landing)

        retrieveNotes()
    }

    private val notesCallback: Callback<List<NoteEntity>> = object: Callback<List<NoteEntity>> {
        override fun onResponse(call: Call<List<NoteEntity>>?, response: Response<List<NoteEntity>>?) {
            //hideLoading()
            //log({"onResponse $response.body()"})
            response?.body()?.let {
                renderNotes(response.body())
            }
        }
        override fun onFailure(call: Call<List<NoteEntity>>?, t: Throwable?) {
            /*if(!call?.isCanceled){
                hideLoading()
            }*/
            //log({"onFailure $t"})
        }
    }

    private fun renderNotes(mNotes:List<NoteEntity>){
        notes=mNotes
        listView.adapter= NoteAdapter(this,notes)
    }

    private fun  retrieveNotes(){
        currentCall = ApiClient.getMyApiClient().notes()
        currentCall!!.enqueue(notesCallback)
    }
}
