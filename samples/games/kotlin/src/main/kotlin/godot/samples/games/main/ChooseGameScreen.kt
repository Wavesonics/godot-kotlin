package godot.samples.games.main

import godot.*
import godot.core.NodePath
import org.godotengine.kotlin.annotation.RegisterClass
import org.godotengine.kotlin.annotation.RegisterFunction

@RegisterClass("Games/Main/Scripts")
class ChooseGameScreen: Node() {

    lateinit var playDodgeButton: Button
    lateinit var playPongButton: Button
    lateinit var playShmupButton: Button
    lateinit var backButton: Button
    lateinit var playCatchBallButton: Button
    lateinit var playFastFinishButton: Button

    @RegisterFunction
    override fun _ready() {
        playDodgeButton = (Button from getNode(NodePath("MenuButtons/PlayDodgeButton"))).apply {
            connect("pressed", this@ChooseGameScreen, "_onPlayDodgeButtonPressed")
        }
        playPongButton = (Button from getNode(NodePath("MenuButtons/PlayPongButton"))).apply {
            connect("pressed", this@ChooseGameScreen, "_onPlayPongButtonPressed")
        }
        playShmupButton = (Button from getNode(NodePath("MenuButtons/PlayShmupButton"))).apply {
            connect("pressed", this@ChooseGameScreen, "_onPlayShmupButtonPressed")
        }
        playCatchBallButton = (Button from getNode(NodePath("MenuButtons/PlayCatchBallButton"))).apply {
            connect("pressed", this@ChooseGameScreen, "_onPlayCatchBallButtonPressed")
        }
        playFastFinishButton = (Button from getNode(NodePath("MenuButtons/PlayFastFinishButton"))).apply {
            connect("pressed", this@ChooseGameScreen, "_onPlayFastFinishButtonPressed")
        }
        backButton = (Button from getNode(NodePath("MenuButtons/BackButton"))).apply {
            connect("pressed", this@ChooseGameScreen, "_onBackButtonPressed")
        }
    }

    @RegisterFunction
    fun _onPlayDodgeButtonPressed() {
        getTree().changeScene("res://Games/Dodge/Scenes/Main.tscn")
    }

    @RegisterFunction
    fun _onPlayShmupButtonPressed() {
        getTree().changeScene("res://Games/Shmup/Scenes/Stage.tscn")
    }

    @RegisterFunction
    fun _onPlayCatchBallButtonPressed() {
        getTree().changeScene("res://Games/CatchBall/Scenes/Stage.tscn")
    }

    @RegisterFunction
    fun _onPlayFastFinishButtonPressed() {
        getTree().changeScene("res://Games/FastFinish/Scenes/Stage.tscn")
    }

    @RegisterFunction
    fun _onPlayPongButtonPressed() {
        getTree().changeScene("res://Games/Pong/Scenes/Main.tscn")
    }

    @RegisterFunction
    fun _onBackButtonPressed() {
        getTree().changeScene("res://Games/Main/Scenes/MainScreen.tscn")
    }
}