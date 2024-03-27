package com.example.contactmanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity4 : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val name=findViewById<TextInputEditText>(R.id.name)
        val email=findViewById<TextInputEditText>(R.id.email)
        val phone=findViewById<TextInputEditText>(R.id.phone)
        val btn=findViewById<Button>(R.id.button3)
        btn.setOnClickListener {
            val num=name.text.toString()
            val ema=email.text.toString()
            val phon=phone.text.toString()
            val calladd=CallAdd(num,ema,phon)
            databaseReference= FirebaseDatabase.getInstance().getReference("CallAdd")
            databaseReference.child(phon).setValue(calladd).addOnSuccessListener {
                Toast.makeText(this,"yourData Saved", Toast.LENGTH_SHORT).show()
                name.setText("")
                email.setText("")
                phone.setText("")



            }.addOnFailureListener{
                Toast.makeText(this,"yourData not saved", Toast.LENGTH_SHORT).show()
                name.setText("")
                email.setText("")
                phone.setText("")


            }

        }

    }
}