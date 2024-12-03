package rpg.factory;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class EnemyFactory {

    private static final Random random = new Random();

    public static Enemy getEnemy() {

        Enemy enemyInstance;
        Set<Class<? extends Enemy>> enemyClasses;
        List<Class<? extends Enemy>> classList;
        // Configura Reflections para buscar clases en el classpath
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new SubTypesScanner(), new FieldAnnotationsScanner()));
        // Obtiene todas las clases que extienden de Enemy
        enemyClasses = reflections.getSubTypesOf(Enemy.class);
        // Filtra las clases para obtener solo las de tipo básico
        classList = filterList(enemyClasses.stream().toList(), EnemyType.BASIC);
        try {
            int randomIndex;
            if (classList != null) {

                randomIndex = random.nextInt(classList.size());
                enemyInstance = classList.get(randomIndex).getDeclaredConstructor()
                        .newInstance();
            }else {
                throw new Exception();
            }
        } catch (Exception e) {
            return null;
        }
        return enemyInstance;
    }

    private static List<Class<? extends Enemy>> filterList(List<Class<? extends Enemy>> classList, EnemyType enemyType) {

        Enemy enemy;
        List<Class<? extends Enemy>> classListFiltered = new ArrayList<>();
        for (Class<? extends Enemy> enemyClass : classList) {

            try {
                enemy = enemyClass.getDeclaredConstructor().newInstance();
                if (enemy.getType() == enemyType) {
                    classListFiltered.add(enemyClass);
                }
            } catch (Exception e) {
                return null;
            }
        }
        return classListFiltered;
    }
}
