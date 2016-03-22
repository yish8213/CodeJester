package reflection.introspection;

import java.lang.reflect.*;

/**
 * Created by y1sh on 3/22/16.
 */
public class TestReflection {

    private static void classIntrospection(Object obj) {
        Class<?> typeClass = obj.getClass();
        System.out.println(typeClass.getSimpleName());
        System.out.println(Modifier.toString(typeClass.getModifiers()));

        // Field reflection
        System.out.println("=== Field reflection ===");
        try {
            Field[] fieldElements = typeClass.getDeclaredFields();
            for (Field fieldValue : fieldElements) {
                fieldValue.setAccessible(true); // Now we can access to private field, but not recommended
                System.out.println(fieldValue.get(obj));

                if ("name".equals(fieldValue.getName())) {
                    fieldValue.set(obj, "Seung-hwan Lee");
                } else if ("age".equals(fieldValue.getName())) {
                    fieldValue.set(obj, (byte) 36);
                }
            }

            System.out.println("==========");

            for (Field fieldValue : fieldElements) {
                System.out.println(fieldValue.get(obj));
                fieldValue.setAccessible(false);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        // Constructor reflection
        Constructor<Person> personConstructor = personClass.getConstructor(String.class, byte.class);
        Person p = personConstructor.newInstance("Linus Lee", (byte) 35);

        // Method reflection
        Method method = personClass.getMethod("setAge", byte.class);
        method.invoke(p, (byte) 34); // Replacing age value before calling classIntrospection method

        classIntrospection(p);

    }
}
