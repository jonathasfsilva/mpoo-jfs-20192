import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void imprimir(){
        System.out.println(this.getHora()+" - Ola "+this.getNome()+". Voce acabou de fazer seu primeiro Hello World em Java. Parabens.");
    }

    public String getHora(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String hora = dateFormat.format(date);
        return hora;
    }
}