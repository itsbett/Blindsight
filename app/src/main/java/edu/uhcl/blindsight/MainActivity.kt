package edu.uhcl.blindsight

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.Manifest
import android.view.MotionEvent
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import edu.uhcl.blindsight.diceroller.DiceRoller

class MainActivity : AppCompatActivity(), RecognitionListener {

    //Initializing variables to be used by Speech Recognizer functions
    private val permissionCode = 100
    private lateinit var voiceResults: TextView
    private lateinit var micButton: ImageView
    private lateinit var speechRecognizer: SpeechRecognizer
    private lateinit var recognizerIntent: Intent


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val diceRoller = DiceRoller()
        setContentView(R.layout.activity_main)

        //Speech Recognizer elements
        voiceResults = findViewById(R.id.displayVoiceText)
        micButton = findViewById(R.id.micButton)
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)


        val rolld20: ImageButton = findViewById(R.id.imageButton2)
        val rolld6: ImageButton = findViewById(R.id.imageButton3)
        val stringRoller: Button = findViewById(R.id.button)
        val rollResults: TextView = findViewById(R.id.displayRoll)
        val stringInput: EditText = findViewById(R.id.stringRoll)

        rolld20.setOnClickListener {
            rollResults.text = diceRoller.roll("1d20").toString()
        }
        rolld6.setOnClickListener {
            rollResults.text = diceRoller.roll("1d6").toString()
        }
        stringRoller.setOnClickListener {
            rollResults.text = diceRoller.roll(stringInput.text.toString()).toString()
        }

        //Create listener and intent for Speech Recognizer
        speechRecognizer.setRecognitionListener(this)
        recognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "US-en")
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)

        //Check for permissions: If microphone permissions are not granted, ask for permission
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            val permissions = arrayOf(Manifest.permission.RECORD_AUDIO)
            ActivityCompat.requestPermissions(this, permissions, 0)
        }

        //Mic button
        micButton.setOnTouchListener { _, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                speechRecognizer.stopListening()
            }
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                micButton.setImageResource(R.drawable.ic_mic_red_listening)
                speechRecognizer.startListening(recognizerIntent)
            }
            false
        }
    }

    //This method is invoked after .requestPermission is called
    //However, it does not seem to work properly
    //Work in progress
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissionArray: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissionArray, grantResults)
        when (requestCode) {
            permissionCode -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "Permission Granted",
                Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "Permission Denied",
                Toast.LENGTH_SHORT).show()
            }
        }
    }

    //This method is invoked when results are found
    override fun onResults(results: Bundle?) {
        val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        val matchedText: String = matches!![0]
        voiceResults.text = matchedText
        //voiceResults.text = matches!![0]
        micButton.setImageResource(R.drawable.ic_mic_black_off)
    }

    override fun onStop() {
        super.onStop()
        speechRecognizer.destroy()
    }
    override fun onReadyForSpeech(p0: Bundle?) {}
    override fun onBeginningOfSpeech() {
        voiceResults.text = ""
        voiceResults.hint = "Listening..."
    }
    override fun onRmsChanged(p0: Float) {}
    override fun onBufferReceived(p0: ByteArray?) {}
    override fun onEndOfSpeech() {}
    override fun onError(p0: Int) {}
    override fun onPartialResults(p0: Bundle?) {}
    override fun onEvent(p0: Int, p1: Bundle?) {}
}