package com.liyaan.liyaanpush


import android.hardware.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.liyaan.liyaanpush.databinding.ActivityMainBinding
import com.yzw.permissiongranted.PermissionGrantedCallback
import com.yzw.permissiongranted.PermissionUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val livePusher by lazy {
        LivePusher(this,800,480,800_000,10, Camera.CameraInfo.CAMERA_FACING_BACK)
    }

    private val permission_CAMERA = arrayOf("android.permission.CAMERA")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        PermissionUtils.permissionCheck(this, permission_CAMERA, "xxx", object :
            PermissionGrantedCallback {

            override fun granted() {

                Log.d("permissionCheck", "同意")

            }

            override fun denied() {

                Log.d("permissionCheck", "拒绝")

            }

        })
        livePusher.setPreviewDisplay(binding.surface.holder)
        // Example of a call to a native method
//        binding.sampleText.text = stringFromJNI()
    }

    fun openSurface(view: View) {

    }

    /**
     * A native method that is implemented by the 'liyaanpush' native library,
     * which is packaged with this application.
     */
//    external fun stringFromJNI(): String

//    companion object {
//        // Used to load the 'liyaanpush' library on application startup.
//        init {
//            System.loadLibrary("liyaanpush")
//        }
//    }
}