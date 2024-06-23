package dev.quantam.kanimation.easings

/**
 * Provides various easing functions for animations.
 * Easing functions define the rate of change of a parameter over time.
 *
 * @author quantam
 * @since v1.0
 */
object EaseFunctions {
    /**
     * Linear easing function.
     *
     * @param x The input value (progress).
     * @return The output value, which is equal to the input value for linear easing.
     */
    fun linear(x: Float): Float = x

    /**
     * Ease-in Sine easing function.
     *
     * @param x The input value (progress).
     * @return The eased output value.
     */
    fun easeInSine(x: Float): Float = (1 - Math.cos((x * Math.PI / 2).toDouble())).toFloat()

    /**
     * Ease-out Sine easing function.
     *
     * @param x The input value (progress).
     * @return The eased output value.
     */
    fun easeOutSine(x: Float): Float = Math.sin((x * Math.PI / 2).toDouble()).toFloat()

    /**
     * Ease-in-out Sine easing function.
     *
     * @param x The input value (progress).
     * @return The eased output value.
     */
    fun easeInOutSine(x: Float): Float = (-(Math.cos((Math.PI * x).toDouble()) - 1) / 2).toFloat()

    /**
     * Ease-in Cubic easing function.
     *
     * @param x The input value (progress).
     * @return The eased output value.
     */
    fun easeInCubic(x: Float): Float = x * x * x

    /**
     * Ease-out Cubic easing function.
     *
     * @param x The input value (progress).
     * @return The eased output value.
     */
    fun easeOutCubic(x: Float): Float = (1 - Math.pow((1 - x).toDouble(), 3.0)).toFloat()

    /**
     * Ease-in-out Cubic easing function.
     *
     * @param x The input value (progress).
     * @return The eased output value.
     */
    fun easeInOutCubic(x: Float): Float = if (x < 0.5) (4 * x * x * x) else (1 - Math.pow((-2 * x + 2).toDouble(), 3.0) / 2).toFloat()

    /**
     * Ease-in Quint easing function.
     *
     * @param x The input value (progress).
     * @return The eased output value.
     */
    fun easeInQuint(x: Float): Float = x * x * x * x * x

    /**
     * Ease-out Quint easing function.
     *
     * @param x The input value (progress).
     * @return The eased output value.
     */
    fun easeOutQuint(x: Float): Float = (1 - Math.pow((1 - x).toDouble(), 5.0)).toFloat()

    /**
     * Ease-in-out Quint easing function.
     *
     * @param x The input value (progress).
     * @return The eased output value.
     */
    fun easeInOutQuint(x: Float): Float = if (x < 0.5) (16 * x * x * x * x * x) else (1 - Math.pow((-2 * x + 2).toDouble(), 5.0) / 2).toFloat()
}
