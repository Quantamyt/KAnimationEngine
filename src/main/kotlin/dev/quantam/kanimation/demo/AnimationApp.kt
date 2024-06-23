package dev.quantam.kanimation.demo

import dev.quantam.kanimation.AnimationEngine
import dev.quantam.kanimation.AnimationManager
import dev.quantam.kanimation.easings.EaseFunctions
import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.Timer

/**
 * A simple animation demonstration using Java Swing in Kotlin.
 * This class extends JPanel and implements ActionListener
 * to animate a red circle moving back and forth horizontally,
 * with progress, position, and FPS displayed on the screen.
 *
 * @author quantam
 * @since v1.0
 */
class AnimationApp : JPanel(), ActionListener {

    private var circleX = 100
    private var circleY = 100
    private var progress = 0f
    private var animationTime = 0f
    private var forward = true
    private var frameCount = 0
    private var startTime: Long = 0
    private var fps = 0f

    private val animationManager = AnimationManager()

    init {
        // Example animation setup
        val moveRight = AnimationEngine(
            2.0f, // duration in seconds
            { progress -> circleX = (100 + 600 * progress).toInt() },
            EaseFunctions::easeInOutCubic
        )

        animationManager.addAnimation(moveRight)
        moveRight.start()

        // Start the animation timer (roughly 60 FPS)
        Timer(16, this).start()

        // Schedule a task to update FPS every second
        Timer(1000) {
            fps = frameCount.toFloat()
            frameCount = 0
        }.start()

        // Record the start time for FPS calculation
        startTime = System.currentTimeMillis()
    }

    /**
     * Updates the position of the circle based on the animation progress.
     *
     * @param progress The current progress of the animation (0.0 to 1.0).
     */
    private fun updatePosition(progress: Float) {
        this.progress = progress
        this.circleX = (100 + 600 * progress).toInt() // Move the circle horizontally
    }

    /**
     * Overrides the paintComponent method to draw the animation on the panel.
     *
     * @param g The Graphics object used for drawing.
     */
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.color = Color.RED
        g.fillOval(circleX, circleY, 50, 50) // Draw a red circle

        // Draw progress text in the center of the panel
        g.color = Color.BLACK
        g.font = Font("Arial", Font.BOLD, 24)
        g.drawString(String.format("Progress: %.2f", progress), width / 2 - 75, height / 2)

        // Draw X and Y position counters
        g.drawString(String.format("X: %d", circleX), 20, 30)
        g.drawString(String.format("Y: %d", circleY), 20, 50)

        // Draw FPS counter
        g.drawString(String.format("FPS: %.2f", fps), width - 100, 30)
    }

    /**
     * Handles the actionPerformed event from the Timer.
     * Updates the animation state and repaints the panel.
     *
     * @param e The ActionEvent triggered by the timer.
     */
    override fun actionPerformed(e: ActionEvent) {
        val deltaTime = 0.016f // Time elapsed per frame (roughly 16 ms)

        // Update animation time and direction
        if (forward) {
            animationTime += deltaTime
            if (animationTime >= 2.0f) {
                animationTime = 2.0f
                forward = false
            }
        } else {
            animationTime -= deltaTime
            if (animationTime <= 0.0f) {
                animationTime = 0.0f
                forward = true
            }
        }

        // Calculate easing progress and update circle position
        val progress = EaseFunctions.easeInOutCubic(animationTime / 2.0f)
        updatePosition(progress)

        // Increment frame count for FPS calculation
        frameCount++

        repaint() // Trigger repaint to update the animation
    }

    companion object {
        /**
         * The main entry point for the animation application.
         *
         * @param args Command-line arguments (not used).
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val frame = JFrame("KAnimation Example")
            val panel = AnimationApp()
            frame.add(panel)
            frame.setSize(800, 600)
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.isVisible = true
        }
    }
}
