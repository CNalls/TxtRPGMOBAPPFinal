package com.example.txtrpgfinalmobapp

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class Story (val gs : GameScreen)

{

    var nextPosition1 = "";
    var nextPosition2 = "";
    var nextPosition3 = "";
    var nextPosition4 = "";
    var undergroundLabKey = false
    var wolfKey = false
    var westClosed = false
    var leftClosed = false
    var wolfClosed = false
    var acidicLiquid = false
    var razor = false



    fun selectPosition(position: String){

        when(position){
            "startingPoint" -> startingPoint()
            "sign" -> sign()
            "undergroundLab" -> undergroundLab()
            "slime" -> slime()
            "forest" -> forest()
            "death" -> death()
            "perception" -> perception()
            "titleScreen" -> goTitleScreen()
            "slimeDead" -> slimeDead()
            "lockedLab" -> lockedLab()
            "labBowels" -> labBowels()
            "labBowelsLeft" -> labBowelsLeft()
            "labBowelsRight" -> labBowelsRight()
            "goldenCave" -> goldenCave()
            "acidicMonstrisityDeath" -> acidicMonstrisityDeath()
            "shrapnelAlienDeath" -> shrapnelAlienDeath()
            "sneak" -> sneak()
            "quExplore" -> quExplore()
            "deathByQu" -> deathByQu()
            "quFight" -> quFight()
            "trueQuFight" -> trueQuFight()
            "mutantKnight" -> mutantKnight()
            "labExperiment" -> labExperiment()
            "gasMask" -> gasMask()
            "swordMelt" -> swordMelt()
            "corruptedGem" -> corruptedGem()
            "gooGah" -> gooGah()
            "googahQuest" -> googahQuest()
            "googahExplain" -> googahExplain()
            "googahFight" -> googahFight()
            "googahLariat" -> googahLariat()
            "deathByGoo" -> deathByGoo()
            "deathByGah" -> deathByGah()
            "googahConfuse" -> googahConfuse()
            "deathVat" -> deathVat()
            "feralWolves" -> feralWolves()
            "wolfDeath" -> wolfDeath()
            "wolfFight" -> wolfFight()
            "shrapnelAlien" -> shrapnelAlien()

        }
    }

    fun showAllButtons(){
        gs.findViewById<Button>(R.id.choiceButton1).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.VISIBLE
    }

    //where game starts
    @SuppressLint("SetTextI18n", "CutPasteId")
    fun startingPoint() {
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.road)
        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You wake up and find yourself on a road that forks at the end. There is a large wooden sign that says BEWARE on both directions.\nWhat do you want to do?"

        if (westClosed) {
            // West path is closed - hide the West button
            gs.findViewById<Button>(R.id.choiceButton1).text = "Go North"
            gs.findViewById<Button>(R.id.choiceButton2).text = "Go East"
            gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE  // Hide West button
            gs.findViewById<Button>(R.id.choiceButton4).text = "Read The Sign"

            nextPosition1 = "goldenCave"
            nextPosition2 = "undergroundLab"
            nextPosition3 = ""  // No position for West since it's closed
            nextPosition4 = "sign"
        } else {
            // All paths are open
            gs.findViewById<Button>(R.id.choiceButton1).text = "Go North"
            gs.findViewById<Button>(R.id.choiceButton2).text = "Go East"
            gs.findViewById<Button>(R.id.choiceButton3).text = "Go West"
            gs.findViewById<Button>(R.id.choiceButton4).text = "Read The Sign"

            nextPosition1 = "goldenCave"
            nextPosition2 = "undergroundLab"
            nextPosition3 = "forest"
            nextPosition4 = "sign"
        }

        // Make sure all buttons are visible (except West if closed)
        showAllButtons()
        if (westClosed) {
            gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        }
    }
    fun sign(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.sign)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "The sign says:\n\nCave of Riches Ahead! The the left it says FOREST CAUTION! and on right it says LAB CAUTION!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Go Back"
        //gs.findViewById<Button>(R.id.choiceButton2).text = ""
        //gs.findViewById<Button>(R.id.choiceButton3).text = ""
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "startingPoint"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""

    }
    fun forest(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.forest)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You traverse WEST through various thickets and vines.\nYou feel that there is something watching you\n What do you do?"

        gs.findViewById<Button>(R.id.choiceButton1).text = "RUN AWAY!!!"
        gs.findViewById<Button>(R.id.choiceButton2).text = "Unsheathe your knight commisioned sword, readying yourself!"
        gs.findViewById<Button>(R.id.choiceButton3).text = "Perception Check!!!"
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""


        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "startingPoint"
        nextPosition2 = "slime"
        nextPosition3 = "perception"
        nextPosition4 = ""
    }

    fun perception() {
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.forest) // Or specific perception image

        gs.findViewById<TextView>(R.id.gameTextView).text = "You focus your senses, trying to detect what's watching you..."

        // Hide all buttons except one
        gs.findViewById<Button>(R.id.choiceButton1).text = "Roll Perception Check"
        gs.findViewById<Button>(R.id.choiceButton1).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE

        // Set up the click listener for the perception check
        gs.findViewById<Button>(R.id.choiceButton1).setOnClickListener {
            // 50% chance for either result
            val rollResult = if ((1..2).random() == 1) "criticalSuccess" else "criticalFail"

            when (rollResult) {
                "criticalSuccess" -> {
                    gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.dyes)
                    gs.findViewById<TextView>(R.id.gameTextView).text = "NATURAL 20! You spot the creature, it is... A SLIME!"


                    // Set next positions for success
                    nextPosition1 = "slime" // You'll need to create this scene
                    nextPosition2 = ""
                    nextPosition3 = ""
                    nextPosition4 = ""
                }
                "criticalFail" -> {
                    gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.dno)
                    gs.findViewById<TextView>(R.id.gameTextView).text = "CRITICAL FAILURE! You're ambushed and die by an unknown entity!"
                    // Set next positions for failure
                    nextPosition1 = "death" // You'll need to create this scene
                    nextPosition2 = ""
                    nextPosition3 = ""
                    nextPosition4 = ""
                }
            }

            // Change button to continue
            gs.findViewById<Button>(R.id.choiceButton1).text = "Continue"
            gs.findViewById<Button>(R.id.choiceButton1).setOnClickListener {
                // Move to the next scene based on roll result
                selectPosition(if (rollResult == "criticalSuccess") nextPosition1 else nextPosition1)
            }
        }
    }

    fun sneak() {
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.forest) // Or specific perception image

        gs.findViewById<TextView>(R.id.gameTextView).text = "You think like a feline and move like a feline, or atleast try to..."

        // Hide all buttons except one
        gs.findViewById<Button>(R.id.choiceButton1).text = "Roll Sneak Check"
        gs.findViewById<Button>(R.id.choiceButton1).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE

        // Set up the click listener for the perception check
        gs.findViewById<Button>(R.id.choiceButton1).setOnClickListener {
            // 50% chance for either result
            val rollResult = if ((1..2).random() == 1) "criticalSuccess" else "criticalFail"

            when (rollResult) {
                "criticalSuccess" -> {
                    gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.dyes)
                    gs.findViewById<TextView>(R.id.gameTextView).text = "NATURAL 20! You hide just behind the door, for some reason its just dark enough there."


                    // Set next positions for success
                    nextPosition1 = "quExplore" // You'll need to create this scene
                    nextPosition2 = ""
                    nextPosition3 = ""
                    nextPosition4 = ""
                }
                "criticalFail" -> {
                    gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.dno)
                    gs.findViewById<TextView>(R.id.gameTextView).text = "CRITICAL FAILURE! You are violently erased from this existense!"
                    // Set next positions for failure
                    nextPosition1 = "death" // You'll need to create this scene
                    nextPosition2 = ""
                    nextPosition3 = ""
                    nextPosition4 = ""
                }
            }

            // Change button to continue
            gs.findViewById<Button>(R.id.choiceButton1).text = "Continue"
            gs.findViewById<Button>(R.id.choiceButton1).setOnClickListener {
                // Move to the next scene based on roll result
                selectPosition(if (rollResult == "criticalSuccess") nextPosition1 else nextPosition1)
            }
        }
    }

    fun slime(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.slime)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "Hmm, this thing looks disgusting...and depressed.\nWhat do you do?"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Throw your sword at the mass of gelatinous liquid and make an expidious retreat!."
        gs.findViewById<Button>(R.id.choiceButton2).text = "Attack it, using the knight martial arts!"
        gs.findViewById<Button>(R.id.choiceButton3).text = "Pet it."
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "startingPoint"
        nextPosition2 = "slimeDead"
        nextPosition3 = "death"
        nextPosition4 = ""
    }

    fun undergroundLab() {
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Main description text
        gs.findViewById<TextView>(R.id.gameTextView).text =
            "You wander through the forest looking for something, ANYTHING.\n" +
                    "You see traces of slime residue, a slime has been here.\n" +
                    "Ahead, you see in the middle of an empty clearing a huge factory\n" +
                    "What do you do?"

        // Always available options
        gs.findViewById<Button>(R.id.choiceButton1).text = "Attempt to enter the facility..."
        gs.findViewById<Button>(R.id.choiceButton2).text = "Go back"

        // Perception check option (currently invisible as per original code)
        gs.findViewById<Button>(R.id.choiceButton3).text = "Perception Check!!!"
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE

        // Handle wolfClosed state
        if (wolfClosed) {
            // Hide the "Check around back" option
            gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE
            nextPosition4 = ""  // No destination if somehow triggered
        } else {
            // Show the "Check around back" option
            gs.findViewById<Button>(R.id.choiceButton4).text = "Check around back of the facility..."
            gs.findViewById<Button>(R.id.choiceButton4).visibility = View.VISIBLE
            nextPosition4 = "feralWolves"
        }

        // Set other next positions
        nextPosition1 = "lockedLab"
        nextPosition2 = "startingPoint"
        nextPosition3 = "perception"

        // Make sure all buttons are visible (except those intentionally hidden)
        showAllButtons()
        // Re-hide buttons that should be invisible
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        if (wolfClosed) {
            gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE
        }
    }

    fun feralWolves(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.feralwolves)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You go around back and find where they discard trash,  All of a sudden a pack of wolves that seem to be feeding on the trash appear. \n\nWhat do you do?"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Engage!"
        gs.findViewById<Button>(R.id.choiceButton2).text = "Go back"
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "wolfFight"
        nextPosition2 = "undergroundLab"
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun wolfFight(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.feralwolves)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "This is nothing for you, mid tier mosnters at best.  Despite it being a pack, they seem sickly and irrational this will be easy...You dispatch them effeciently and quickly..."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Slice the creatures throats..."
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "wolfDeath"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun wolfDeath(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.deadcreature)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You slice all of the mutts in half.  From one you can see a rusty looking key peeking out of its throat.  It has a wierd insignia on it... YOU TAKE IT!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Continue back..."
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = "" //when satchel implemented you will be able to find a firebomb plant you can use on shrapnel monster later since its weak to fire if failed you spawn in a
        gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "undergroundLab"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
        wolfKey = true
        wolfClosed = true
    }

    fun fireBombPlant(){

    }

    fun lockedLab(){

        if (undergroundLabKey==false){
            gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

            // Ensure GameScreen has these public properties
            gs.findViewById<TextView>(R.id.gameTextView).text = "Upon looking closer, it appears that the lab is locked and needs a key of some sort..."

            gs.findViewById<Button>(R.id.choiceButton1).text = "Go Back..."
            gs.findViewById<Button>(R.id.choiceButton2).text = ""
            gs.findViewById<Button>(R.id.choiceButton3).text = ""
            //gs.findViewById<Button>(R.id.choiceButton4).text = ""
            gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
            gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
            gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


            nextPosition1 = "undergroundLab" //isnt calling for some reason
            nextPosition2 = ""
            nextPosition3 = ""
            nextPosition4 = ""
        }
        if (undergroundLabKey==true){
            gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

            // Ensure GameScreen has these public properties
            gs.findViewById<TextView>(R.id.gameTextView).text = "Upon looking closer, it appears that the lab is locked and needs a key of some sort..."

            gs.findViewById<Button>(R.id.choiceButton1).text = "Use the key that you recieved from the slime."
            gs.findViewById<Button>(R.id.choiceButton2).text = ""
            gs.findViewById<Button>(R.id.choiceButton3).text = ""
            //gs.findViewById<Button>(R.id.choiceButton4).text = ""
            gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
            gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
            gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


            nextPosition1 = "labBowels"
            nextPosition2 = ""
            nextPosition3 = ""
            nextPosition4 = ""
        }
    }

    fun labBowels(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)  //get hallway image

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You head down a long hall way and reach a dead end that goes left and right, which way will you go?"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Left..."
        gs.findViewById<Button>(R.id.choiceButton2).text = "Right..."
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "labBowelsLeft"
        nextPosition2 = "labBowelsRight"
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun labBowelsLeft(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You slowly tread along the sterile lab tiling until you reach are hit my the smell of death.\n There is a room up ahead and you get an uneasy feeling. As you reach the opening you see soemthing crunching on bones and chewing flesh.  The smell of rot fills your lungs...it sees you, and theres no running away this time...THE END IS NEAR!!!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "HOLD FAST!" //
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "shrapnelAlien"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun shrapnelAlien(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "The creature is straight out of an eldritch nightmare, with sharp unnatural claws and of alien origin.\n WHAT DO DO YOU?"

        gs.findViewById<Button>(R.id.choiceButton1).text = "You have studied in the arts of paladins as well.  CAST SMITE ON THEE FOUL DEMON!"  //you forgot you lack magic and holy power, you die
        gs.findViewById<Button>(R.id.choiceButton2).text = "You use your athletics to try and gain the advantage for a CRITICAL ATTACK"
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        //gs.findViewById<Button>(R.id.choiceButton4).text = "FACE IT HEAD ON!!!"
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "death"
        nextPosition2 = "shrapnelAlienDeath"
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun labBowelsRight(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You slowly tread along the sterile lab tiling until you reach a room and it is very dark.\n You faintly hear a hum of buzzing followed by low and sadistic laughter... YOU ARE NOT ALONE... A creature which you cannot fully make out yet enters the room with you\nWHAT DO YOU DO?!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "HIDE!!! (Initiate Sneak Roll)"
        gs.findViewById<Button>(R.id.choiceButton2).text = "Attempt to talk to it"
        gs.findViewById<Button>(R.id.choiceButton3).text = "Hide inside of a mysterious vat of liquid."
        gs.findViewById<Button>(R.id.choiceButton4).text = "FACE IT HEAD ON!!!"
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.VISIBLE


        nextPosition1 = "sneak"
        nextPosition2 = "deathByQu"
        nextPosition3 = "deathVat"
        nextPosition4 = "quFight"
    }

    fun deathVat(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "The liquid very painfully melts you, why would you do that???"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Continue"
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "death"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun quExplore(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You watch as the insectoid creature hovers through the room using its tail thing as a hand to reach different tools.  It then freezes, and turns towards your direction.  IT KNOWS YOU ARE THERE.  Your head begins to quake as it releasing something from a chamber with strange marking on it.  ANOTHER ONE???"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Brace Yourself..."
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "labExperiment"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun deathByQu(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "The creature pierces your chest with its tail-like appendage.  Your body begins to genetically mutate.  You are now a monstrosity."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Endlessly wander the world in pain..."
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "death"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""

    }

    fun quFight(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "This, THING its not from here.  Its bloodlust makes you feel as though there is no escape.  You can't beat it...."

        gs.findViewById<Button>(R.id.choiceButton1).text = "SUBMIT..."
        gs.findViewById<Button>(R.id.choiceButton2).text = "SUBMIT..."
        gs.findViewById<Button>(R.id.choiceButton3).text = "SUBMIT..."
        gs.findViewById<Button>(R.id.choiceButton4).text = "SUBMIT..."
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.VISIBLE


        nextPosition1 = "deathByQU"
        nextPosition2 = "deathByQu"
        nextPosition3 = "deathByQu"
        nextPosition4 = "deathByQu"
    }

    fun trueQuFight(){


    }

    fun mutantKnight(){

    }

    fun labExperiment(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.expirispider)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "UGH what is that wretched thing. YOU MUST ACT FAST. \n The smell of chemicals and rot fill your nostrils, its preparing to attack!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Pull out your knightly commisioned gas mask"
        gs.findViewById<Button>(R.id.choiceButton2).text = "Drop a mysterious vat of liquid and cause the creature to slip"  //leads to canister exploding and creature dying you gain access to a corrupted gemstone which you can give orc king but also makes him become the true boss
        gs.findViewById<Button>(R.id.choiceButton3).text = "Attempt to use your sword to stop the creature!"
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "gasMask"
        nextPosition2 = "acidicMonstrosityDeath"
        nextPosition3 = "swordMelt"
        nextPosition4 = ""
    }

    fun gasMask(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.expirispider)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "WAIT A MINUTE... You forgot your gas mask..."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Your mistake gives the creature enough time to pounce on you and savage you, death reaches your bones..."
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "death"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun swordMelt(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.expirispider)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "Upon swinging at the creature, your sword gets hit with the horrible liquid, causing it to melt.  A knight never leaves his sword behind so instead of letting it go, you squeeze tighter allowing the liquid to melt you as well.\n\n YOU ARE VERY DEAD"

        gs.findViewById<Button>(R.id.choiceButton1).text = "YOU HAVE PUDDLED..."
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "death"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }


    fun corruptedGem(){  //wip may not be needed
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.expirispider)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = ""

        gs.findViewById<Button>(R.id.choiceButton1).text = ""  //make another area where you die if you do this
        gs.findViewById<Button>(R.id.choiceButton2).text = "Drop a mysterious vat of liquid and cause the creature to slip"  //leads to canister exploding and creature dying you gain access to a corrupted gemstone which you can give orc king but also makes him become the true boss
        gs.findViewById<Button>(R.id.choiceButton3).text = "Attempt to use your sword to stop the creature!" //
        //gs.findViewById<Button>(R.id.choiceButton4).text = "FACE IT HEAD ON!!!" //the creature is too strong you are melted by the acidic chemicals
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.VISIBLE


        nextPosition1 = "labBowelsLeft"
        nextPosition2 = "labBowelsRight"
        nextPosition3 = ""
        nextPosition4 = ""
        //corruptedGem = true

    }


    fun goldenCave(){  //you can either help the greedy orc or steal his gold.

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.goldencave)
        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You reach a cave.  The entrance shimmers with a golden hue."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Go Back"
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = ""

        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE

        nextPosition1 = "startingPoint"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun gooGah(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.googah)
        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "Upon stepping closer to the cavernous entrance, you immediately see two creature step out.  It appears to be an...Ogre and a Goblin chained together???\n\nWhat do you do?"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Apologize and leave"
        gs.findViewById<Button>(R.id.choiceButton2).text = "Ask whats in that cave."
        gs.findViewById<Button>(R.id.choiceButton3).text = "ATTACK THY FOUL BEASTS"
        gs.findViewById<Button>(R.id.choiceButton4).text = "Ask why they are chained together"

        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE

        nextPosition1 = "googahConfuse"
        nextPosition2 = "googahExplain"
        nextPosition3 = "googahFight"
        nextPosition4 = "googahQuest"
    }

    fun googahQuest(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.googah)
        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "The explain to you that there is an evil lab to the east.  Their boss has ordered them to retrieve some gem from there but they failed and were binded together by a magical chain.\n\n If you were able to find some way there to release the binds or even better yet fidn the gem they would reward you..."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Accept quest and leave..."
        gs.findViewById<Button>(R.id.choiceButton2).text = "Ask whats in that cave."
        gs.findViewById<Button>(R.id.choiceButton3).text = "ATTACK THY FOUL BEASTS"
        gs.findViewById<Button>(R.id.choiceButton4).text = "Ask why they are chained together"

        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE

        nextPosition1 = "startingPoint"
        nextPosition2 = "googahExplain"
        nextPosition3 = "googahFight"
        nextPosition4 = ""
    }
    fun googahExplain(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.googah)
        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "The goblin looks at you like you are stupid and says in whatever language that they are speaking no not really...however you can understand it.  This is our cave they say in a booming tone. AND NO ONE IS ALLOWED INSIDE BUT THE GREEN AND GOLD GANG!!! I guess they are the green and gold gang."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Apologize and leave"
        gs.findViewById<Button>(R.id.choiceButton2).text = "Ask whats in that cave."
        gs.findViewById<Button>(R.id.choiceButton3).text = "ATTACK THY FOUL BEASTS"
        gs.findViewById<Button>(R.id.choiceButton4).text = "Ask why they are chained together"

        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.VISIBLE

        nextPosition1 = "googahConfuse"
        nextPosition2 = ""
        nextPosition3 = "googahFight"
        nextPosition4 = "googahQuest"
    }

    fun googahFight(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.googah)
        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "The two sense your aggression and begin to chant something.  The are charging an attack! \n What do you DOOOO!!!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Apologize and leave"
        gs.findViewById<Button>(R.id.choiceButton2).text = "Attack Their Chain"
        gs.findViewById<Button>(R.id.choiceButton3).text = "Attack GOO"
        gs.findViewById<Button>(R.id.choiceButton4).text = "Attack GAH"

        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.VISIBLE

        nextPosition1 = "googahConfuse"
        nextPosition2 = "googahLariat"
        nextPosition3 = "deathByGoo"
        nextPosition4 = "deathByGah"
    }
    fun googahLariat(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.googah)
        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You run up and attack the chain connecting the two.  Your sword bounces off as if you were thwarted by a magical force.\n\nAll of a sudden you get clothelined by the chain as the two's attack is done charging.  THEY CAST BERSERK LARIAT.... and yeah you die..."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Continue"
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = ""

        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE

        nextPosition1 = "death"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun deathByGoo(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.googah)
        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You run up to the goblin as he looks like the easiest target.  All of a sudden, you see the goblin turn golden and the ogre begins to spin with the goblin.\n\n Goo Crashes into your body like a golden flail and you explode and die...That must have been the spell they were casting..."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Continue"
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = ""

        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE

        nextPosition1 = "death"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun deathByGah(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.googah)
        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "The bigger they are the harder they fall you think as you go for the 17 foot tall ogre.\n\n Wait, all of a sudden you are in the sky, how did this happen?\n\n And now as you are falling through the sky after being tossed like a pebble you wonder why you put yourself in this situation as you hit the ground and become a puddle."

        gs.findViewById<Button>(R.id.choiceButton1).text = "YOU HAVE BEEN PUDDLED... Continue"
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = ""

        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE

        nextPosition1 = "death"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun googahConfuse(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.googah)
        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "The goblin and ogre look at the running knight as if he is a clown as he runs away. \n\n You have fled like a coward, you coward!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Continue"
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = ""

        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE

        nextPosition1 = "startingPoint"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun death(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.youdied)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "Yeah, it appears that you died.\nDon't feel bad though, theres always next time.\nGo ahead, choose an option below..."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Give In..."
        //gs.findViewById<Button>(R.id.choiceButton2).text = ""
        //gs.findViewById<Button>(R.id.choiceButton3).text = ""
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "titleScreen"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""


    }

    fun slimeDead(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.deadcreature)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "The slime is now dead, a mere puddle of what appears to be its lunch and a...WOAH a KEY!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Take the key and return to the path..."
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "startingPoint"
        nextPosition2 = "slimedead"
        nextPosition3 = "death"
        nextPosition4 = ""

        undergroundLabKey = true
        westClosed = true

    }

    fun acidicMonstrisityDeath(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.deadcreature)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "That thing has ceased all motor functions and the other one has dissapeared, that may have been your only chance to kill it earlier.  You decide collecting some fo the chemicals from this creature would stand useful, however you wouldn't want to get it on yourself or anything valuable. \n\n You make your way back to the forked hallway."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Collect some of the chemical in one of the nearby flasks and store for later..."
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "labBowels"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""

        acidicLiquid = true
    }

    fun shrapnelAlienDeath(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.deadcreature)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You leap off of the walls like a rabid lemur using your athletics to ascertain a swift and accurate critical hit on the creature. Your even surprised that this worked.  You get a feeling that you should collect one of the creatures razor sharp file like fingers as you think it would be really cool to have.\n\n You make your way back to the forked hallway."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Grab the parts and depart..."
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE

        leftClosed = true
        nextPosition1 = "labBowels"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""

        razor = true

    }

    fun goTitleScreen(){
        val intent = Intent(gs, TitleScreen::class.java).apply {
            putExtra("SOME_KEY", "some value")  // Optional: pass data
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP  // Optional: clear activity stack
        }
        gs.startActivity(intent)
        gs.finish()
    }

}