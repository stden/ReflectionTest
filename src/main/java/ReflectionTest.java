import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {

    /**
     * Сохранение экземпляра класса
     * @param fileName имя файла
     * @param obj экземпляр класса
     * @throws Exception
     */
    public static void saveClass(String fileName, Object obj) throws FileNotFoundException,
            IllegalAccessException {
        try(PrintStream out = new PrintStream(fileName)){
            Class aClass = obj.getClass();
            out.println(aClass.getName());
            for (Field field : aClass.getDeclaredFields()){
                if ((field.getModifiers() & Modifier.PUBLIC) == 0)
                    field.setAccessible(true);
                out.println(field.get(obj).toString());
            }
        }
    }

    /**
     * Загрузка объекта из файла
     * @param fileName имя файла
     * @return загруженный объект
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object loadClass(String fileName) throws FileNotFoundException, ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        try (Scanner in = new Scanner(new FileInputStream(fileName))) {
            String className = in.nextLine();
            Class aClass = Class.forName(className);
            Object obj = aClass.newInstance();
            for (Field f : aClass.getDeclaredFields()) {
                if ((f.getModifiers() & Modifier.PUBLIC) == 0)
                    f.setAccessible(true);
                f.set(obj, castToPrimitiveType(f, in.next()));
            }
            return obj;
        }
    }

    /**
     * Привидение значения полей из файла к примитивным типам
     * @param field поле объекта
     * @param value значение поля
     * @return значение поля привидённое к одному из примитивных типов
     * @throws IllegalAccessException
     */
    private static Object castToPrimitiveType(Field field, String value) throws IllegalAccessException {
        Object object;
        switch (field.getType().toString()){
            case "byte":
                object = Byte.valueOf(value);
                break;
            case "short":
                object = Short.valueOf(value);
                break;
            case "int":
                object = Integer.valueOf(value);
                break;
            case "long":
                object = Long.valueOf(value);
                break;
            case "float":
                object = Float.valueOf(value);
                break;
            case "double":
                object = Double.valueOf(value);
                break;
            case "boolean":
                object = Boolean.valueOf(value);
                break;
            case "char":
                object = value.charAt(0);
                break;
            default:
                object = null;
                break;
        }
        return object;
    }
}
