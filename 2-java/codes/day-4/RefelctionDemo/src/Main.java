import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            useReflection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void useReflection() throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        //1.A. extracting a type (class) metadata from a JAR file
        //reference is added already
        Class<?> clsMetadata = Class.forName("com.demo.Messenger");

        //1.B. extracting method information from the metadata of the type (class)
        Method[] methods = clsMetadata.getMethods();
        Stream<Method> methodStream = Arrays.stream(methods);
        methodStream.forEachOrdered(method -> {
            System.out.println("Name: " + method.getName());
            System.out.println("Return Type: " + method.getReturnType().getName());
            System.out.println("\n");
        });

        //2. extracting (Default) constructor metadata and using the same to
        //create an instance
        Constructor<?> ctorMetadata = clsMetadata.getDeclaredConstructor();
        Object obj = ctorMetadata.newInstance();

        //3. extracting metadata of 'welcome' method and invoking the method
        //with that metadata (dynamic method invocation)
        Method welcomeMetadata = clsMetadata.getMethod("welcome", String.class);
        Object result = welcomeMetadata.invoke(obj, "joydip");
        System.out.println(result);
    }

    static void useDI() {
        Container container = Container.instantiate();
        Class<Reader> readerInterfaceType = Reader.class;
        Class<DbReader> readerClassType = DbReader.class;
        Reader reader = null;
        try {
            reader = container.create(readerInterfaceType, readerClassType);
            //Manager manager = container.create(Manager.class, DataManager.class);
            Manager manager = new DataManager(reader);
            System.out.println(manager.fetchData());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}