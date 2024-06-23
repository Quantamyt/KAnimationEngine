package dev.quantam.kanimation

/**
 * The AnimationManager class is responsible for managing and updating multiple
 * animations. It maintains a list of animations and updates them on each frame.
 *
 * @author quantam
 * @since v1.0
 */
class AnimationManager {

    private val animations: MutableList<AnimationEngine> = mutableListOf()

    /**
     * Adds a new animation to the manager.
     *
     * @param animation The animation to be added.
     */
    fun addAnimation(animation: AnimationEngine) {
        animations.add(animation)
    }

    /**
     * Updates all the animations managed by this manager.
     * This method should be called on each frame to ensure smooth animations.
     *
     * @param deltaTime The time elapsed since the last update, in seconds.
     */
    fun update(deltaTime: Float) {
        for (animation in animations) {
            animation.update(deltaTime)
        }

        animations.removeIf { !it.isRunning }
    }
}
