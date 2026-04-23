package show.g

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import show.g.ui.AppRoot
import show.g.ui.theme.CogniviaBioTheme

class MainActivity : ComponentActivity() {
    private val windowController by lazy { WindowInsetsControllerCompat(window, window.decorView) }
    private var multiTouchDetected = false
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CogniviaBioTheme {
                AppRoot()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        windowController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowController.hide(WindowInsetsCompat.Type.systemBars())
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.pointerCount > 1) {
            if (!multiTouchDetected) {
                multiTouchDetected = true
                val cancelEvent = MotionEvent.obtain(ev)
                cancelEvent.action = MotionEvent.ACTION_CANCEL
                super.dispatchTouchEvent(cancelEvent)
                cancelEvent.recycle()
            }
            return true
        }

        if (multiTouchDetected) {
            if (ev.actionMasked == MotionEvent.ACTION_UP || ev.actionMasked == MotionEvent.ACTION_CANCEL) {
                multiTouchDetected = false
            }
            return true
        }

        return super.dispatchTouchEvent(ev)
    }
}
