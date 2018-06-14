package instance_static_initializer;

public class InstanceStaticInitializer {


    public InstanceStaticInitializer() {
        System.out.println("Inside no-arg constructor");
    }


    public InstanceStaticInitializer(int id) {
        System.out.println("Inside constructor with param ");
    }

    // it will be copied inside the beginning of the constructor method
    {
        System.out.println("\nInside instance initializer...");
    }


    public static void main(String[] args) {
        InstanceStaticInitializer something = new InstanceStaticInitializer(1);
    }
}
