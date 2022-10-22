import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) throws IOException {
        FirstTask();
        SecondTask();
        getFile();
        String s = "?2 + 5? = 69";
        Logger logger = Logger.getAnonymousLogger();
        logger.info(calcLogic(s));
    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void FirstTask(){
        Person person = new Person("Иванов", 5, "Математика");
        String json = GSON.toJson(person);
        System.out.println(json);

        Person person1 = GSON.fromJson(json, Person.class);
        StringBuilder sb = new StringBuilder();
        sb.append("Студент " + person1.getLastName() +
                " получил " + person1.getNumber() +
                " по предмету " + person1.getSubject());
        System.out.println(String.valueOf(sb));
    }

    public static void SecondTask() throws IOException {
        int[] mas = new int[]{5, 3, 9, 1, 6, 10, 15, 22, 0};
        int ineration = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mas.length - 1; i++)
            for (int j = 0; j < mas.length - i - 1; j++)
                if (mas[j] > mas[j + 1]) {
                    int k = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = k;
                    sb.append(String.valueOf(ineration++) + ": " +
                            String.valueOf(mas[j + 1]) + " > " +
                            String.valueOf(mas[j]) + "\n");
                } else {
                    sb.append(String.valueOf(ineration++) + ": " +
                            String.valueOf(mas[j]) + " < " +
                            String.valueOf(mas[j + 1]) + "\n");
                }
        try (FileWriter file = new FileWriter("log.txt", false)) {
            file.write(sb.toString());
            file.flush();
        }

        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);
        }
    }

    public static void getFile(){
        File dir = new File("I:\\dir");
        String contents[] = dir.list();
        String element = new String();
        for (int i = 0; i < contents.length; i++) {
            element = contents[i].substring(contents[i].lastIndexOf('.'));
            System.out.println("Расширение файла: " + element);
        }
    }

    public static String calcLogic(String s){
        System.out.print(s + " => ");
        String[] mas = s.split(" ");
        String k = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mas.length; i = i + 2){
            for (int j = 0; j < mas[i].length(); j++){
                if (mas[i].charAt(j) == '?'){
                    k += i;
                    break;
                }
            }
        }
        int a = 0, b = 0, c = 0;
        switch (k){
            case "0":
                b = Integer.parseInt(mas[2]);
                c = Integer.parseInt(mas[4]);
                if (c > b){
                    a = c - b;
                    sb.append(a + " + " + b + " = " + c);
                }
                else
                    sb.append("None!");
                break;
            case "2":
                a = Integer.parseInt(mas[0]);
                c = Integer.parseInt(mas[4]);
                if (c > a){
                    b = c - a;
                    sb.append(a + " + " + b + " = " + c);
                }
                else
                    sb.append("None!");
                break;
            case "02":
                c = Integer.parseInt(mas[4]);
                a = c / 2;
                b = c - a;
                sb.append(a + " + " + b + " = " + c);
                break;
            case "4":
                a = Integer.parseInt(mas[0]);
                b = Integer.parseInt(mas[2]);
                c = a + b;
                sb.append(a + " + " + b + " = " + c);
                break;
            default:
                sb.append("Error!");
                break;
        }
        return sb.toString();
    }
}