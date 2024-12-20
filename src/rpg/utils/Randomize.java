package rpg.utils;

/**
 * La interfaz Randomize.
 */
public interface Randomize {

    /**
     * Devuelve un número entero aleatorio entre min y max.
     *
     * @param min el valor mínimo del rango.
     * @param max el valor máximo del rango.
     * @return el número entero aleatorio dado el rango.
     */
    static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /**
     * Devuelve un valor booleano aleatorio.
     *
     * @return the random boolean
     */
    static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}
