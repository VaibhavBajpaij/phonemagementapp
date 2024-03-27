package com.example.contactmanagerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class second : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val name=findViewById<TextInputEditText>(R.id.name)
        val email=findViewById<TextInputEditText>(R.id.gmail)
        val dob=findViewById<TextInputEditText>(R.id.dob)
        val unid=findViewById<TextInputEditText>(R.id.uniqeid)
        val click=findViewById<CheckBox>(R.id.checkBox)
        val up=findViewById<Button>(R.id.button)
        val login=findViewById<Button>(R.id.button1)

        up.setOnClickListener {
            val nam=name.text.toString()
            val em=email.text.toString()
            val dod=dob.text.toString()
            val id=unid.text.toString()
            val signup=Signup(nam,em,dod,id)
            databaseReference=FirebaseDatabase.getInstance().getReference("Signup")
            databaseReference.child(id).setValue(signup).addOnSuccessListener {
                Toast.makeText(this,"yourData Saved",Toast.LENGTH_SHORT).show()
                name.setText("")
                email.setText("")
                dob.setText("")
                unid.setText("")



            }.addOnFailureListener{
                Toast.makeText(this,"yourData not saved",Toast.LENGTH_SHORT).show()
                name.setText("")
                email.setText("")
                dob.setText("")
                unid.setText("")

            }

            }
        login.setOnClickListener {
          val  intent= Intent(this,threid::class.java)
            startActivity(intent)


        }


    }
}