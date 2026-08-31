import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Gatherer;

public class Container {
    private static Container container;

    private Container() {
    }

    public static Container instantiate() {
        if (container == null)
            container = new Container();

        return container;
    }

    public <TInterface, TClass> TInterface create(Class<TInterface> interfaceMetadata,
                                                  Class<TClass> classMetadata)
            throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException {

        Class<?>[] interfaces = classMetadata.getInterfaces();
        boolean interfaceImplemented = false;
        for (Class<?> clsInterface : interfaces) {
            if (clsInterface.getSimpleName().equals(interfaceMetadata.getSimpleName())) {
                interfaceImplemented = true;
                break;
            }
        }

        if (!interfaceImplemented)
            throw new ClassNotFoundException("the interface is not implemented in the class");
        else {
//            Constructor<?>[] constructors= classMetadata.getDeclaredConstructors();
//            for (Constructor<?> c:constructors){
//                if(c.getParameters().length>0){
//
//                }
//            }
            Constructor<TClass> constructorMedata = classMetadata.getDeclaredConstructor();
            return (TInterface) constructorMedata.newInstance();
        }
    }
}
