import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) throws Exception {

        //Чтение из файла
        FileReader fr = new FileReader("c:/test/login.txt");
        FileReader fr1 = new FileReader("c:/test/Pass.txt");
        //Создание каталога
        File dir = new File("c:/test/Registration");
        System.out.println(dir.mkdir()? "Success!":"Faled");
        //Создание файла
        File file = new File("c:/test/Registration/reg.txt");
        System.out.println(file.createNewFile()? "Success!":"Faled");

        FileWriter fw = new FileWriter(file);
        //Создание буфера
        var readerLogin = new BufferedReader(fr);
        var readerPass = new BufferedReader(fr1);
        String strLogin;
        String strPass;
        //Создание массива
        List<String> login = new ArrayList<>();
        List<String> pass = new ArrayList<>();
        Map<String, String> reg = new HashMap<>();

        while ((strLogin = readerLogin.readLine()) != null){
            if(strLogin.isEmpty()) break;
            login.add(strLogin);
        }

        for (int i = 0; i < login.size(); i++) {
            strPass = readerPass.readLine();
            pass.add(strPass);
        }

        for (int i = 0; i < login.size(); i++) {
            reg.put(login.get(i), pass.get(i));
        }

        for (Map.Entry x: reg.entrySet()) {
            fw.write(String.format("Login: %15s\tPassword: %s\n",
                    x.getKey().toString(), x.getValue()));
        }

        fr.close();
        fr1.close();
        fw.close();
        readerLogin.close();
        readerPass.close();
    }
}
