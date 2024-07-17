package com.example.madone

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.ref.Reference
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var  databaseReference: DatabaseReference
    lateinit var  firebaseDatabase:FirebaseDatabase
    lateinit var email:EditText;
    lateinit var pass:EditText;
    lateinit var btn:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        btn=findViewById(R.id.submit)
        pass=findViewById(R.id.pass)
        email=findViewById(R.id.email)

        firebaseDatabase=FirebaseDatabase.getInstance()
        databaseReference=firebaseDatabase.getReference().child("user")


        btn.setOnClickListener {

            val em:String=email.text.toString().trim()
            val pass:String=pass.text.toString().trim()


            val hashMap=HashMap<String,String>();

            hashMap.put("email",em)
            hashMap.put("password",pass)

            databaseReference.push().setValue(hashMap)







        }

    }
}