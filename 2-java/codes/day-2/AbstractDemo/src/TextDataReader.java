public class TextDataReader extends DataReader {

    @Override
    public String getData() {
        return "data from text file";
    }
}

interface A{
    void M1();
    default void M(){
        //code
    }
}
interface B{
    void M2();
}
class C extends DataReader implements A,B{

    @Override
    public String getData() {
        return "";
    }

    @Override
    public void M1() {

    }

    @Override
    public void M2() {

    }
}

