package io.sabina.glossology

import android.app.Activity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.view.View
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener

import java.util.Locale

class MainActivity extends Activity with TypedActivity with OnInitListener with OnClickListener {

  private var myTTS : TextToSpeech = _
  lazy val myDataCheckCode = 0
  lazy val speakButton1 = findViewById(R.id.button1).asInstanceOf[Button]
  lazy val speakButton2 = findViewById(R.id.button2).asInstanceOf[Button]
  lazy val speakButton3 = findViewById(R.id.button3).asInstanceOf[Button]

  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)
    myTTS = new TextToSpeech(this, this)
    speakButton1.setOnClickListener(this)
    speakButton2.setOnClickListener(this)
    speakButton3.setOnClickListener(this)
  }

  private def speakWords(speech: String) {
    myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null)
  }

  override def onClick(v: View) {
    if (v == speakButton1)
      speakWords(getString(R.string.button_i_want))
    else if (v == speakButton2)
      speakWords(getString(R.string.button_to_watch))
    else if (v == speakButton3)
      speakWords(getString(R.string.button_Olivia))
  }

  def onInit(initStatus: Int) {
    if (initStatus == TextToSpeech.SUCCESS) {
      val result = myTTS setLanguage Locale.US
    }
  }

}

