package com.example.techunicornassessment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.webkit.PermissionRequest
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.example.techunicornassessment.databinding.FragmentAudioBinding
import com.example.techunicornassessment.databinding.FragmentCameraBinding

class AudioFragment : Fragment(R.layout.fragment_audio) {
    private var _binding: FragmentAudioBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_audio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAudioBinding.bind(view)
        with(binding.audioWebview) {
            loadUrl("https://whatpwacando.today/audio-recording")
            settings.javaScriptEnabled = true
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
            binding.audioWebview.settings.allowFileAccess
            binding.audioWebview.settings.allowContentAccess
            binding.audioWebview.webChromeClient = object : WebChromeClient() {
                override fun onPermissionRequest(request: PermissionRequest?) {
                    request?.grant(request.resources)
                }
            }
        }

    }
}