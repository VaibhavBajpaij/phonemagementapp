package com.example.contactmanagerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class threid : AppCompatActivity() {
    companion object{
        const val KEY1="com.example.myapplication.mail"
        const val KEY2="com.example.myapplication.name"
        const val KEY3="com.example.myapplication.ID"
    }
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_threid)
        val text1=findViewById<TextInputEditText>(R.id.text)
        val button=findViewById<Button>(R.id.button2)

        button.setOnClickListener {
            val un=text1.text.toString()
            if(un.isNotEmpty()){
                readdata(un)

            }else{
                Toast.makeText(this,"please enter your ID",Toast.LENGTH_SHORT).show()
            }
        }




    }
    private fun readdata(id:String){
        databaseReference=FirebaseDatabase.getInstance().getReference("Signup")
        databaseReference.child(id).get().addOnSuccessListener {
            if(it.exists()){
                val email = it.child("email").value
                val name = it.child("name").value
                val unid = it.child("unid").value

                val intent = Intent(this, MainActivity4::class.java)
                // Use correct constant KEY instead of Key
                intent.putExtra(KEY1, email.toString())
                intent.putExtra(KEY2, name.toString())
                intent.putExtra(KEY3, unid.toString())
                startActivity(intent)

            } else {
                // Correct typo: Toast.makeText instead of oast.makeText
                Toast.makeText(this, "This ID does not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener() {
            // Correct typo: Toast.makeText instead of oast.makeText
            Toast.makeText(this, "Some failure happened, try again", Toast.LENGTH_SHORT).show()

        }
    }
}