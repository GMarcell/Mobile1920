package com.github.gmarcell.myadventure

import android.app.Application
import android.media.Image

class MyApplication: Application() {

    data class Scene(
        val body: String,
        val actions: List<String>
    )

    companion object {
        // Constants
        val MAIN_MENU = "Main Menu"
        val TRY_AGAIN = "Try Again"


        // Scenes
        val scenes: List<Scene> = listOf (
            // 0
            Scene (
                "You wake up in the forest, what do you do?",
                actions = listOf("Scream loudly", "Wander around")
            ),

            // 1
            Scene (
                "A bear came and roared at you",
                actions = listOf("Run away","Play dead")),

            // 2 BAD END Devaured by Bear
            Scene (
                "You ran, but you're not fast enough to outrun the bear. You scream loudly as the bear devours you.",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 3
            Scene (
                "Just like in the movies, you try to play dead to fool the bear. The bear bought it and after sniffing you for a while, it went away.",
                actions = listOf ("continue to WANDER", "")),

            // 4
            Scene (
                "You wandered around for a while, but there's a fork on the road. Which way do you go?",
                actions = listOf("Left path", "Right path")),

            // 5
            Scene (
                "You try to go to the left path. The forest doesn't seem to have any end. After a while, you found an old hut. You're suspicious, but it's getting dark. Do you get in?",
                actions = listOf("You go inside", "You refuse to enter")),

            // 6
            Scene (
                "Inside, you find the hut is filled with mystical and strange tables. Do you go further inside?",
                actions = listOf("Investigate further", "You went to the exit as quick as you can")),

            // 7
            Scene (
                "As you investigate further, you found in one of the rooms, there is a witch. Nearby you can see a knife in the table. Or you can run away. What do you do?",
                actions = listOf ("Kill the witch", "Run away")),

            // 8 NORMAL ENDING
            Scene (
                "You sneak behind the witch, and you stab it in the back. It died before even seeing your face.",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 9 BAD END Died by Witch
            Scene (
                "You try to run away, but your steps made the witch notice your presence, and as it suddenly channeled a spell, your vision goes dark.",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 10 BAD END Undead
            Scene (
                "You don't want to go further, so you ran back outside. As you close the door, the ground start shaking as skeletons start emerging from the ground. You are surrounded with no way to escape..",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 11 BAD END Slow Death
            Scene (
                "You refuse to enter the hut, so you ran back the way you came. But night came and as you keep walking, you can't recognize the road anymore, as you become more hungry and thirsty, you feel more weaker and eventually, as your consciousness fade",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 12
            Scene (
                "You went to the right path. After a while, you reach the forest's exit. As you arrive, you notice it's getting late. Not far, there's a farmhouse. You may be able to stay the night there. What do you do?",
                actions = listOf("You went to the farm", "You refuse to go to the farm")),

            // 13
            Scene (
                "You enter the farm, and you knock on the door. An old farmer greets you, and he asks you what is your business here.",
                actions = listOf("Ask for shelter", "Threaten to kill him")),

            // 14 GOOD END
            Scene (
                "You asked the farmer for shelter, and he's more than happy to give it to you.",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 15 BAD END Rude Shelter
            Scene (
                "You attempt to rob the farmer of his belongings, and he pulls a shotgun and shoots you in the face.",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 16 BAD END Raiders
            Scene (
                "You refused to go the farm, and you chose to keep walking until you encounter the road. Not long though, a group of raiders ambushed you, and kills you.",
                actions = listOf (MAIN_MENU, TRY_AGAIN))
        )

        // Ending flags
        var badEnding1 = false //BAD END Devaured by Bear
        var badEnding2 = false //BAD END Died by Witch
        var badEnding3 = false //BAD END Undead
        var badEnding4 = false //BAD END Slow Death
        var badEnding5 = false //BAD END Rude Shelter
        var badEnding6 = false //BAD END Raiders
        var normalEnding = false
        var goodEnding = false

        // Utils
        lateinit var currentDisplayedEnding: Scene
    }
}
