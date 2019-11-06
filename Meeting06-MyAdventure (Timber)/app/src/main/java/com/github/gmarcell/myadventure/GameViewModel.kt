package com.github.gmarcell.myadventure

import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.gmarcell.myadventure.MyApplication.Companion.scenes

class GameViewModel: ViewModel() {

    private var _scene = MutableLiveData<MyApplication.Scene>()
    val scene: LiveData<MyApplication.Scene>
        get() = _scene

    private var _goToMainMenu = MutableLiveData<Boolean>()
    val goToMainMenu: LiveData<Boolean>
        get() = _goToMainMenu

    val scenes = MyApplication.scenes
    var selectedActionId = -1

    init {
        _scene.value = scenes[0]
        _goToMainMenu.value = false
    }

    fun onAction(actions: RadioGroup, opt1: RadioButton, opt2: RadioButton, scrollView: ScrollView) {
        val checkedRadioButtonId = actions.checkedRadioButtonId

        when (checkedRadioButtonId) {
            opt1.id -> selectedActionId = 0
            opt2.id -> selectedActionId = 1
        }

        if (checkedRadioButtonId != -1) {

            when (checkedRadioButtonId) {
                opt1.id -> selectedActionId = 0
                opt2.id -> selectedActionId = 1
            }

            when (_scene.value) {
                scenes[0] -> {
                    when (selectedActionId) {
                        0 -> _scene.value = scenes[1]
                        1 -> _scene.value = scenes[4]
                    }
                }
                scenes[1] -> {
                    when (selectedActionId) {
                        0 -> _scene.value = scenes[2]
                        1 -> _scene.value = scenes[4]
                    }
                }
                scenes[2] -> {
                    MyApplication.badEnding1 = true
                    ending()
                }
                scenes[3] -> {
                    when (selectedActionId) {
                        0 -> _scene.value = scenes[4]
                    }
                }
                scenes[4] -> {
                    when (selectedActionId) {
                        0 -> _scene.value = scenes[5]
                        1 -> _scene.value = scenes[12]
                    }
                }
                scenes[5] -> {
                    when (selectedActionId) {
                        0 -> _scene.value = scenes[6]
                        1 -> _scene.value = scenes[11]
                    }
                }
                scenes[6] -> {
                    when (selectedActionId) {
                        0 -> _scene.value = scenes[7]
                        1 -> _scene.value = scenes[10]
                    }
                }
                scenes[7] -> {
                    when (selectedActionId) {
                        0 -> _scene.value = scenes[8]
                        1 -> _scene.value = scenes[9]
                    }
                }
                scenes[8] -> {
                    MyApplication.normalEnding = true
                    ending()
                }

                scenes[9] -> {
                    MyApplication.badEnding2 = true
                    ending()
                }

                scenes[10] -> {
                    MyApplication.badEnding3 = true
                    ending()
                }

                scenes[11] -> {
                    MyApplication.badEnding4 = true
                    ending()
                }

                scenes[12] -> {
                    when (selectedActionId) {
                        0 -> _scene.value = scenes[13]
                        1 -> _scene.value = scenes[16]
                    }
                }

                scenes[13] -> {
                    when (selectedActionId) {
                        0 -> _scene.value = scenes[14]
                        1 -> _scene.value = scenes[15]
                    }
                }

                scenes[14] -> {
                    MyApplication.goodEnding = true
                    ending()
                }

                scenes[15] -> {
                    MyApplication.badEnding5 = true
                    ending()
                }

                scenes[16] -> {
                    MyApplication.badEnding6 = true
                    ending()
                }
            }

            // Disabling options if choice == "" and enabling them if not
            if (_scene.value!!.actions[0] == "") opt1.isEnabled = false else opt1.isEnabled = true
            if (_scene.value!!.actions[1] == "") opt2.isEnabled = false else opt2.isEnabled = true


            actions.clearCheck()
            scrollView.fullScroll(ScrollView.FOCUS_UP)
        }
    }
    private fun ending() {
        when(selectedActionId) {
            0 -> _goToMainMenu.value = true
            1 -> _scene.value = scenes[0]
        }
    }
}


