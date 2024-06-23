package dev.quantam.kanimation

import java.util.function.Consumer
import java.util.function.Function

/**
 * The AnimationEngine class is responsible for handling the timing and progress of a single animation.
 * It uses an easing function to control the rate of change of the animation.
 *
 * @property duration The total duration of the animation in seconds.
 * @property updateCallback A callback function that receives the current progress of the animation (0.0 to 1.0).
 * @property easingFunction A function that defines the easing behavior of the animation.
 *
 * @author quantam
 * @since v1.0
 */
class AnimationEngine(
    private val duration: Float,
    private val updateCallback: Consumer<Float>,
    private val easingFunction: Function<Float, Float>
) {
    private var elapsed = 0f
    private var running = false

    /**
     * Starts the animation.
     */
    fun start() {
        running = true
    }

    /**
     * Stops the animation.
     */
    fun stop() {
        running = false
    }

    /**
     * Updates the animation state. This method should be called on each frame.
     *
     * @param deltaTime The time elapsed since the last update, in seconds.
     */
    fun update(deltaTime: Float) {
        if (!running) return

        elapsed += deltaTime
        if (elapsed > duration) {
            elapsed = duration
            running = false
        }

        val progress = easingFunction.apply(elapsed / duration)
        updateCallback.accept(progress)
    }

    /**
     * Checks if the animation is currently running.
     *
     * @return True if the animation is running, false otherwise.
     */
    val isRunning: Boolean
        get() = running
}
