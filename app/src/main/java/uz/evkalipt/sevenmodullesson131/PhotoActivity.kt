package uz.evkalipt.sevenmodullesson131

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import com.squareup.picasso.Picasso
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.activity_photo.view.*
import uz.evkalipt.sevenmodullesson131.databinding.ActivityPhotoBinding
import uz.evkalipt.sevenmodullesson131.db.MyDatabase
import uz.evkalipt.sevenmodullesson131.models.SaveModel

class PhotoActivity : AppCompatActivity() {
    lateinit var binding: ActivityPhotoBinding
    lateinit var myDatabase: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myDatabase = MyDatabase.getInstance(this)

        val stringExtra = intent.getStringExtra("url")
        val author = intent.getStringExtra("author")
        val likes = intent.getStringExtra("likes")
        val size = intent.getStringExtra("size")
        Picasso.get().load(stringExtra).into(binding.imagePhoto)
        binding.blurBack.setOnClickListener {
            finish()
        }

        binding.blurShare.setOnClickListener {
            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, stringExtra)
            intent.type = "text/plain"
            startActivity(intent)
        }

        val allPhoto = myDatabase.saveModelDao().getAllPhoto()
        for (saveModel in allPhoto) {
            if (saveModel.url.toString() == stringExtra){
                binding.blurSave1.visibility = View.VISIBLE
                binding.blurSave.visibility = View.INVISIBLE
            }
        }

        binding.blurSave.setOnClickListener {
            binding.blurSave1.visibility = View.VISIBLE
            binding.blurSave.visibility = View.INVISIBLE
            var saveModel = SaveModel(stringExtra,author,likes,size)
            myDatabase.saveModelDao().addPhoto(saveModel)
        }

        binding.blurSave1.setOnClickListener {
            binding.blurSave1.visibility = View.INVISIBLE
            binding.blurSave.visibility = View.VISIBLE
            var id = -1
            for (saveModel in myDatabase.saveModelDao().getAllPhoto()) {
                if (saveModel.url.toString() == stringExtra){
                    id = saveModel.id!!
                }
            }
            var saveModel = SaveModel(id, stringExtra, author, likes, size)
            myDatabase.saveModelDao().deletePhoto(saveModel)
        }

        binding.blurInfo.setOnClickListener {
            binding.blurBack.visibility = View.INVISIBLE
            binding.blurInfo.visibility = View.INVISIBLE
            binding.blurShare.visibility = View.INVISIBLE
            binding.blurClose.visibility = View.VISIBLE
            binding.bottomText.visibility = View.VISIBLE
            val radius = 24f

            val decorView: View = window!!.decorView
            val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
            val windowBackground = decorView.background

            binding.bottomText.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true)

            binding.bottomText.outlineProvider = ViewOutlineProvider.BACKGROUND
            binding.bottomText.clipToOutline = true

            binding.bottomText.website.text = "Website: unsplash.com"
            binding.bottomText.author.text = "Author: $author"
            binding.bottomText.download.text = "Likes: $likes"
            binding.bottomText.size.text = "Size: $size"


        }

        binding.blurClose.setOnClickListener {
            binding.blurBack.visibility = View.VISIBLE
            binding.blurInfo.visibility = View.VISIBLE
            binding.blurShare.visibility = View.VISIBLE
            binding.blurClose.visibility = View.INVISIBLE
            binding.bottomText.visibility = View.INVISIBLE
        }

        val radius = 24f

        val decorView: View = window!!.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackground = decorView.background

        binding.blurSave.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurSave.outlineProvider = ViewOutlineProvider.BACKGROUND
        binding.blurSave.clipToOutline = true

        binding.blurStar.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurStar.outlineProvider = ViewOutlineProvider.BACKGROUND
        binding.blurStar.clipToOutline = true

        binding.blurFon.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurFon.outlineProvider = ViewOutlineProvider.BACKGROUND
        binding.blurFon.clipToOutline = true

        binding.blurDownload.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurDownload.outlineProvider = ViewOutlineProvider.BACKGROUND
        binding.blurDownload.clipToOutline = true

        binding.blurBack.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurBack.outlineProvider = ViewOutlineProvider.BACKGROUND
        binding.blurBack.clipToOutline = true

        binding.blurInfo.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurInfo.outlineProvider = ViewOutlineProvider.BACKGROUND
        binding.blurInfo.clipToOutline = true

        binding.blurShare.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurShare.outlineProvider = ViewOutlineProvider.BACKGROUND
        binding.blurShare.clipToOutline = true

        binding.blurSave1.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurSave1.outlineProvider = ViewOutlineProvider.BACKGROUND
        binding.blurSave1.clipToOutline = true
    }
}