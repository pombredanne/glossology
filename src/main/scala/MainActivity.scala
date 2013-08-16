package io.sabina.glossology

import _root_.android.app.Activity
import _root_.android.os.Bundle
import _root_.android.view.Menu

class MainActivity extends Activity with TypedActivity {
  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)

   // findView(TR.textview).setText("Hello Lucy!")
  }
}
