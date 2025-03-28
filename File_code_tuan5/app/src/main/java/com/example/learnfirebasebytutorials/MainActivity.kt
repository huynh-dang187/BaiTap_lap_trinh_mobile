package com.example.learnfirebasebytutorials

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.learnfirebasebytutorials.ui.theme.LearnFireBaseByTutorialsTheme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    private val signInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)!!
            Log.d("SignIn", "ID Token: ${account.idToken}")
            firebaseAuthWithGoogle(account.idToken!!)
        } catch (e: ApiException) {
            Log.w("SignIn", "Google Sign-In Failed", e)
            Toast.makeText(this, "Google Sign-In Failed: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mAuth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        refreshUI()
    }

    private fun refreshUI() {
        setContent {
            LearnFireBaseByTutorialsTheme {
                val user = mAuth.currentUser
                if (user != null) {
                    val date = user.metadata?.creationTimestamp?.let {
                        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(it))
                    } ?: "No Date"
                    ProfileScreen(
                        profileImage = user.photoUrl ?: Uri.EMPTY,
                        name = user.displayName ?: "No Name",
                        email = user.email ?: "No Email",
                        date = date ,
                        onSignOut = {
                            signOut()
                        }
                    )
                } else {
                    GoogleSignInButton {
                        signIn()
                    }
                }
            }
        }
    }

    fun signIn() {
        Log.d("GoogleSignIn", "signIn() function called")
        val signInIntent = googleSignInClient.signInIntent
        signInLauncher.launch(signInIntent)
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    val db = Firebase.firestore
                    user?.let {
                        db.collection("users").document(it.uid).set(
                            mapOf(
                                "isOnline" to true,
                                "lastUpdated" to System.currentTimeMillis(),
                                "email" to it.email
                            )
                        )
                    }
                    refreshUI()
                } else {
                    Log.e("FirebaseAuth", "Sign-In Failed", task.exception)
                    Toast.makeText(applicationContext, "Sign-In Failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun signOut() {
        mAuth.signOut()
        googleSignInClient.signOut().addOnCompleteListener {
            val db = Firebase.firestore
            val user = mAuth.currentUser
            if (user != null) {
                db.collection("users").document(user.uid).update("isOnline", false)
            }
            refreshUI()
            Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show()
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        LearnFireBaseByTutorialsTheme {
            GoogleSignInButton {}
        }
    }
}
