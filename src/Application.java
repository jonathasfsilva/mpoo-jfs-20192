public class Application {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setNome("Jonathas");
        helloWorld.imprimir();

        HelloWorld helloWorld1 = new HelloWorld();
        helloWorld1.setNome("Jonathas F. Silva");
        helloWorld1.imprimir();

        HelloWorld helloWorld2 = new HelloWorld();
        helloWorld2.setNome("Silva");
        helloWorld2.imprimir();

        HelloWorld helloWorld3 = new HelloWorld();
        helloWorld3.imprimir();
    }
}