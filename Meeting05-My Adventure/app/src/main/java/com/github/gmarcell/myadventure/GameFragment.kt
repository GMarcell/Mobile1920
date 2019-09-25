package com.github.gmarcell.myadventure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.gmarcell.myadventure.databinding.FragmentGameBinding


class GameFragment : Fragment(){
    lateinit var currentNarative: Narative
    lateinit var answers: MutableList<String>

    data class Narative(
            val text: String,
            val answer: List<String>)

    private val narative: MutableList<Narative> = mutableListOf(
            //A 0
            Narative(text = "You wake up in the forest, what do you do?",
                    answer = listOf("Scream loudly", "Wander around")),
            //B 1
            Narative(text = "A bear came and roared at you",
                    answer = listOf("Run away","Play dead")),
            //C 2
            Narative(text = "You ran, but you're not fast enough to outrun the bear. You scream loudly as the bear devours you.",
                    answer = listOf("")), //BAD END
            //D 3
            Narative(text = "Just like in the movies, you try to play dead to fool the bear. The bear bought it and after sniffing you for a while, it went away.",
                    answer = listOf("")), //continue to WANDER
            //E 4
            Narative(text = "You wandered around for a while, but there's a fork on the road. Which way do you go?",
                    answer = listOf("Left path", "Right path")),
            //F 5
            Narative(text = "You try to go to the left path. The forest doesn't seem to have any end. After a while, you found an old hut. You're suspicious, but it's getting dark. Do you get in?",
                    answer = listOf("You go inside", "You refuse to enter")),
            //G 6
            Narative(text = "Inside, you find the hut is filled with mystical and strange tables. Do you go further inside?",
                    answer = listOf("Investigate further", "You went to the exit as quick as you can")),
            //H 7
            Narative(text = "You investigated further, but as you go through numerous rooms, you see a witch concocting in the cauldron. On the right, you found a kitchen knife. Do you...",
                    answer = listOf("Kill the witch before it notices you", "Run away")),
            //I 8
            Narative(text = "You sneak behind the witch, and you stab it in the back. It died before even seeing your face.",
                    answer = listOf("")), //NORMAL ENDING
            //J 9
            Narative(text = "You try to run away, but your steps made the witch notice your presence, and as it suddenly channeled a spell, your vision goes dark.",
                    answer = listOf("")), //BAD END
            //K 10
            Narative(text = "You don't want to go further, so you ran back outside. As you close the door, the ground start shaking as skeletons start emerging from the ground. You are surrounded with no way to escape..",
                    answer = listOf("")), //BAD END Undead
            //L 11
            Narative(text = "You refuse to enter the hut, so you ran back the way you came. But night came and as you keep walking, you can't recognize the road anymore, as you become more hungry and thirsty, you feel more weaker and eventually, as your consciousness fade",
                    answer = listOf("")), //BAD END Slow Death
            //M 12
            Narative(text = "You went to the right path. After a while, you reach the forest's exit. As you arrive, you notice it's getting late. Not far, there's a farmhouse. You may be able to stay the night there. What do you do?",
                    answer = listOf("You went to the farm", "You refuse to go to the farm")),
            //N 13
            Narative(text = "You enter the farm, and you knock on the door. An old farmer greets you, and he asks you what is your business here.",
                    answer = listOf("Ask for shelter", "Threaten to kill him")),
            //O 14
            Narative(text = "You asked the farmer for shelter, and he's more than happy to give it to you.",
                    answer = listOf("")), //GOOD END
            //P 15
            Narative(text = "You attempt to rob the farmer of his belongings, and he pulls a shotgun and shoots you in the face.",
                    answer = listOf("")), //BAD END Rude Shelter
            //Q 16
            Narative(text = "You refused to go the farm, and you chose to keep walking until you encounter the road. Not long though, a group of raiders ambushed you, and kills you.",
                    answer = listOf("")) //BAD END Raiders
    )
    //private var narativeIndex = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
                R.layout.fragment_game, container, false)

        binding.game = this

        currentNarative = narative[0]

        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){
            view: View ->
            var checkedId = binding.narativeRadioGroup.checkedRadioButtonId
            if (-1 != checkedId){
                //var answerIndex = 0
                when (checkedId){
                    R.id.firstAnswerRadioButton -> checkedId = 0
                    R.id.secondAnswerRadioButton -> checkedId = 1
                }
                when (currentNarative){
                    narative[0] -> {
                        when(checkedId){
                            0 -> currentNarative = narative[1]
                            1 -> currentNarative = narative[4]
                        }
                    }
                    narative[1] -> {
                        when(checkedId){
                            0 -> currentNarative = narative[2] // bad ending devoured
                            1 -> currentNarative = narative[4]
                        }
                    }
                    narative[4] -> {
                        when(checkedId){
                            0 -> currentNarative = narative[5]
                            1 -> currentNarative = narative[12]
                        }
                    }
                    narative[5] -> {
                        when (checkedId) {
                            0 -> currentNarative = narative[6]
                            1 -> currentNarative = narative[11] // bad ending : Slow dead
                        }
                    }
                    narative[6] -> {
                        when (checkedId) {
                            0 -> currentNarative = narative[7]
                            1 -> currentNarative = narative[10] // bad ending : undead
                        }
                    }
                    narative[7] -> {
                        when (checkedId) {
                            0 -> currentNarative = narative[8] // normal ending
                            1 -> currentNarative = narative[9] // bad ending : enchanted
                        }
                    }
                    narative[12] -> {
                        when (checkedId) {
                            0 -> currentNarative = narative[13]
                            1 -> currentNarative = narative[16] // bad ending
                        }
                    }
                    narative[13] -> {
                        when (checkedId) {
                            0 -> currentNarative = narative[14] // good ending
                            1 -> currentNarative = narative[15] // bad ending
                        }
                    }
                }
            }
        }
        return binding.root
    }

}