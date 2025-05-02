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
    fun startingPoint()
    {
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.road)
        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You wake up and find yourself on a road that forks at the end.  There is a large wooden sign that says BEWARE on both directions.\nWhat do you want to do?"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Go North"
        gs.findViewById<Button>(R.id.choiceButton2).text = "Go East"
        gs.findViewById<Button>(R.id.choiceButton3).text = "Go West"
        gs.findViewById<Button>(R.id.choiceButton4).text = "Read The Sign"

        showAllButtons()

        nextPosition1 = "goldenCave"
        nextPosition2 = "undergroundLab"
        nextPosition3 = "forest"
        nextPosition4 = "sign"

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
        nextPosition2 = "slimedead"
        nextPosition3 = "death"
        nextPosition4 = ""
    }

    fun undergroundLab(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You wander through the forest looking for something, ANYTHING.\nYou see traces of slime residue, a slime has been here.\n Ahead, you see in the middle of an empy clearing a huge factory\n What do you do?"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Attempt to enter the facility..."
        gs.findViewById<Button>(R.id.choiceButton2).text = "Go back"
        gs.findViewById<Button>(R.id.choiceButton3).text = "Perception Check!!!" //when satchel implemented you will be able to find a firebomb plant you can use on shrapnel monster later since its weak to fire if failed you spawn in a
        //gs.findViewById<Button>(R.id.choiceButton4).text = ""
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "lockedLab"
        nextPosition2 = "startingPoint"
        nextPosition3 = "perception"
        nextPosition4 = ""
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
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
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
        gs.findViewById<TextView>(R.id.gameTextView).text = "You slowly tread along the sterile lab tiling until you reach a room and it is very dark.\n You faintly hear a hum of buzzing followed by low and sadistic laughter... YOU ARE NOT ALONE... A creature which you cannot fully make out yet enters the room with you\nWHAT DO YOU DO?!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "HIDE!!! (Initiate Sneak Roll)" //
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = "Hide inside of a mysterious vat of liquid." //you die, the liquid steams and bubbles as you enter, at first it feel like a warm bath then burning then screaming.  the creature chuckles and is intrigued
        gs.findViewById<Button>(R.id.choiceButton4).text = "FACE IT HEAD ON!!!"
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "noSneak"
        nextPosition2 = "labBowelsRight"
        nextPosition3 = "death"
        nextPosition4 = "quFight"
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


        nextPosition1 = "labBowelsLeft"
        nextPosition2 = "labBowelsRight"
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun labBowelsRight(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You slowly tread along the sterile lab tiling until you reach a room and it is very dark.\n You faintly hear a hum of buzzing followed by low and sadistic laughter... YOU ARE NOT ALONE... A creature which you cannot fully make out yet enters the room with you\nWHAT DO YOU DO?!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "HIDE!!! (Initiate Sneak Roll)"
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = "Hide inside of a mysterious vat of liquid."
        gs.findViewById<Button>(R.id.choiceButton4).text = "FACE IT HEAD ON!!!"
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.VISIBLE


        nextPosition1 = "perception"
        nextPosition2 = "deathByQu"
        nextPosition3 = "deathVat"
        nextPosition4 = "quFight"
    }

    fun quExplore(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You slowly tread along the sterile lab tiling until you reach a room and it is very dark.\n You faintly hear a hum of buzzing followed by low and sadistic laughter... YOU ARE NOT ALONE... A creature which you cannot fully make out yet enters the room with you\nWHAT DO YOU DO?!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "HIDE!!! (Initiate Sneak Roll)"
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = "Hide inside of a mysterious vat of liquid."
        gs.findViewById<Button>(R.id.choiceButton4).text = "FACE IT HEAD ON!!!"
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.VISIBLE


        nextPosition1 = "perception"
        nextPosition2 = "deathByQu"
        nextPosition3 = "deathVat"
        nextPosition4 = "quFight"
    }

    fun deathByQu(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "The creature pierces your chest with its tail-like appendage.  Your body begins to genetically mutate.  You are now a monstrosity."

        gs.findViewById<Button>(R.id.choiceButton1).text = "Endlessly wander the world in pain..."
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = ""
        gs.findViewById<Button>(R.id.choiceButton4).text = "Potion of RUN IT BACK!!!"
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.INVISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.INVISIBLE


        nextPosition1 = "perception"
        nextPosition2 = "deathByQu"
        nextPosition3 = "deathVat"
        nextPosition4 = "quFight"

    }

    fun quFight(){
        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.undergroundlab)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "You slowly tread along the sterile lab tiling until you reach a room and it is very dark.\n You faintly hear a hum of buzzing followed by low and sadistic laughter... YOU ARE NOT ALONE... A creature which you cannot fully make out yet enters the room with you\nWHAT DO YOU DO?!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "HIDE!!! (Initiate Sneak Roll)"
        gs.findViewById<Button>(R.id.choiceButton2).text = ""
        gs.findViewById<Button>(R.id.choiceButton3).text = "Hide inside of a mysterious vat of liquid."
        gs.findViewById<Button>(R.id.choiceButton4).text = "FACE IT HEAD ON!!!"
        gs.findViewById<Button>(R.id.choiceButton2).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton3).visibility = View.VISIBLE
        gs.findViewById<Button>(R.id.choiceButton4).visibility = View.VISIBLE


        nextPosition1 = "perception"
        nextPosition2 = "deathByQu"
        nextPosition3 = "deathVat"
        nextPosition4 = "quFight"
    }
    fun labExperiment(){

        gs.findViewById<ImageView>(R.id.gameImageView).setImageResource(R.drawable.expirispider)

        // Ensure GameScreen has these public properties
        gs.findViewById<TextView>(R.id.gameTextView).text = "UGH what is that wretched thing. YOU MUST ACT FAST. \n The smell of chemicals and rot fill your nostrils, its preparing to attack!"

        gs.findViewById<Button>(R.id.choiceButton1).text = "Pull out your knightly commisioned gas mask"  //make another area where you die if you do this
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
    }


    fun goldenCave(){

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

        nextPosition1 = "startingPoint"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun googahFight(){

        
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