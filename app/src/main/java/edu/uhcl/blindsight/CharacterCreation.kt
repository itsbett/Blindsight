package edu.uhcl.blindsight

import java.util.Locale
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.Manifest
import android.util.Log
import android.view.MotionEvent
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import edu.uhcl.blindsight.diceroller.DiceRoller
import org.w3c.dom.Text

class CharacterCreation : AppCompatActivity(), RecognitionListener, TextToSpeech.OnInitListener {

    private val permissionCode = 100
    private lateinit var voiceResults: TextView
    private lateinit var micButton: ImageView
    private lateinit var speechRecognizer: SpeechRecognizer
    private lateinit var recognizerIntent: Intent
    private var tts: TextToSpeech? = null


    @SuppressLint("MissingInflatedId", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val diceRoller = DiceRoller()
        setContentView(R.layout.activity_character_creation)

        voiceResults = findViewById(R.id.displayVoiceText)
        micButton = findViewById(R.id.micButton)
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)

        tts = TextToSpeech(this,this)

        speechRecognizer.setRecognitionListener(this)
        recognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "US-en")
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)

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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissionArray: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissionArray, grantResults)
        when (requestCode) {
            permissionCode -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@CharacterCreation, "Permission Granted",
                    Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@CharacterCreation, "Permission Denied",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    //This method is invoked when results are found
    override fun onResults(results: Bundle?) {
        val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        val matchedText: String = matches!![0]
        voiceResults.text = matchedText
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

    //TTS
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","Error")
            }
        }
    }

    private fun ttsSpeak(textToSpeak: String) {
        tts!!.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    public override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}